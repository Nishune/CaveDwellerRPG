package com.nishune.cavegame.command;

import com.nishune.cavegame.controller.InventoryController;
import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.World;
import com.nishune.cavegame.model.character.Player;

import java.util.Scanner;

public class GameEngine {

    private GameContext context;
    private CommandRegistry commandRegistry;

    public GameEngine(Player player, World world, Location startingLocation, InventoryController inventoryController, Scanner scanner) {
        this.context = new GameContext(player, world, startingLocation, inventoryController, scanner, true);
        this.commandRegistry = new CommandRegistry();
    }

    public void run() {
        System.out.println("Game started! Type 'help' for available commands.");

        while (context.isRunning()) {
            System.out.print("> ");
            String input = context.getScanner().nextLine().trim().toLowerCase();

            if (input.equals("help")) {
                commandRegistry.displayAvailableCommands();
                continue;
            }

            GameCommand command = commandRegistry.getCommand(input);
            if (command != null) {
                command.execute(context);
            } else {
                System.out.println("Unknown command: " + input + ". Type 'help' for available commands.");
            }
        }
    }

    public CommandRegistry getCommandRegistry() {
        return commandRegistry;
    }

    public GameContext getContext() {
        return context;
    }
}
