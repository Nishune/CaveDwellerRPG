package com.nishune.cavegame.command;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private Map<String, GameCommand> commands;

    public CommandRegistry() {
        this.commands = new HashMap<>();
        registerDefaultCommands();
    }

    private void registerDefaultCommands() {

        QuitCommand quitCommand = new QuitCommand();
        registerCommand("quit", quitCommand);
        registerCommand("q", quitCommand);

        HelpCommand helpCommand = new HelpCommand();
        registerCommand("help", helpCommand);
        registerCommand("h", helpCommand);

        InventoryCommand inventoryCommand = new InventoryCommand();
        registerCommand("inventory", inventoryCommand);
        registerCommand("i", inventoryCommand);

        CharacterCommand characterCommand = new CharacterCommand();
        registerCommand("character", characterCommand);
        registerCommand("c", characterCommand);

        TakeCommand takeCommand = new TakeCommand();
        registerCommand("take", takeCommand);
        registerCommand("t", takeCommand);

        OpenCommand openCommand = new OpenCommand();
        registerCommand("open", openCommand);
        registerCommand("o", openCommand);

        registerCommand("north", new MoveCommand("north"));
        registerCommand("n", new MoveCommand("north"));
        registerCommand("south", new MoveCommand("south"));
        registerCommand("s", new MoveCommand("south"));
        registerCommand("east", new MoveCommand("east"));
        registerCommand("e", new MoveCommand("east"));
        registerCommand("west", new MoveCommand("west"));
        registerCommand("w", new MoveCommand("west"));

        BackCommand backCommand = new BackCommand();
        registerCommand("back", backCommand);
        registerCommand("b", backCommand);
    }

    public void registerCommand(String keyword, GameCommand command) {
        commands.put(keyword.toLowerCase(), command);
    }

    public GameCommand getCommand(String keyword) {
        return commands.get(keyword.toLowerCase());
    }

    public boolean hasCommand(String keyword) {
        return commands.containsKey(keyword.toLowerCase());
    }

    public void displayAvailableCommands() {
        System.out.println("Available commands:");
        for (Map.Entry<String, GameCommand> entry : commands.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue().getDescription());
        }
    }
}
