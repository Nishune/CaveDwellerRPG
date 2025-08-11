package com.nishune.cavegame.command;

public class HelpCommand implements GameCommand {

    @Override
    public boolean execute(GameContext context) {
        System.out.println("\n=== Cave Dweller Commands ===");
        System.out.println("Movement:");
        System.out.println("  north, n     - Move north");
        System.out.println("  south, s     - Move south");
        System.out.println("  east, e      - Move east");
        System.out.println("  west, w      - Move west");
        System.out.println("  back, b      - Go back to the previous location");
        System.out.println();
        System.out.println("Actions:");
        System.out.println("  take, t     - Take an item from the current location");
        System.out.println("  open, o     - Open a chest or container");
        System.out.println();
        System.out.println("Character:");
        System.out.println("  inventory, i - View and manage your inventory");
        System.out.println("  character, c - View your character information and equipment");
        System.out.println();
        System.out.println("  help, h   - Show this help message");
        System.out.println("  quit, q   - Quit the game");
        System.out.println();
        return true;
    }

    @Override
    public String getDescription() {
        return "Show available commands and help information";
    }
}
