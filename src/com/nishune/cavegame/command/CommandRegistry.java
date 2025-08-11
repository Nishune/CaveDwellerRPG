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

        InventoryCommand inventoryCommand = new InventoryCommand();
        registerCommand("inventory", inventoryCommand);
        registerCommand("i", inventoryCommand);
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
