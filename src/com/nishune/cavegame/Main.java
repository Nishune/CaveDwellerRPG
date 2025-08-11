package com.nishune.cavegame;

import com.nishune.cavegame.command.GameEngine;
import com.nishune.cavegame.controller.InventoryController;
import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.World;
import com.nishune.cavegame.model.character.CharacterCreator;
import com.nishune.cavegame.model.character.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CharacterCreator characterCreator = new CharacterCreator(scanner);
        Player player = characterCreator.createCharacter();

        World world = new World();
        Location startingLocation = world.getStartingLocation();
        InventoryController inventoryController = new InventoryController(player, scanner);

        GameEngine gameEngine = new GameEngine(player, world, startingLocation, inventoryController, scanner);

        printIntro(player);
        displayInitialLocation(startingLocation);

        gameEngine.run();

    }

    private static void printIntro(Player player) {
        String title = " Welcome to Cave Dweller " + player.getName() + "! ";
        int width = title.length();
        String border = "#".repeat(width);
        System.out.println();
        System.out.println(border);
        System.out.println(title);
        System.out.println(border);
        System.out.println();
    }

    private static void displayInitialLocation(Location location) {
        String border = "-".repeat(location.getDescription().length());
        System.out.println(border);
        System.out.println(location.getDescription());
        System.out.println(border);
        System.out.println();
        System.out.println(location.getAvailableControls());
    }
}
