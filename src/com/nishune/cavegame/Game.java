package com.nishune.cavegame;

import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.World;
import com.nishune.cavegame.model.character.Player;
import com.nishune.cavegame.model.items.Item;
import com.nishune.cavegame.model.locations.NarrowPassage;

import java.util.List;
import java.util.Scanner;

public class Game {
    private World world;
    private Location currentLocation;
    private Location previousLocation;
    private Scanner scanner;
    private Player player;
    private boolean running;


    public Game(World world, Location currentLocation, Scanner scanner, Player player, boolean running) {
        this.world = world;
        this.currentLocation = currentLocation;
        this.scanner = scanner;
        this.player = player;
        this.running = running;
    }

    public static String repeatChar(char c, int count) {
        return String.valueOf(c).repeat(count);
    }

    public void printIntro() {
        System.out.println();
        String title = " Welcome to Cave Dweller " + player.getName() + "! ";
        int width = title.length();
        String border = repeatChar('#', width);
        System.out.println(border);
        System.out.println(title);
        System.out.println(border);
        System.out.println();
    }

    private void displayControls() {
        System.out.println();
        System.out.println("Utility commands: Inventory (i)");
        System.out.println();
        System.out.println(currentLocation.getAvailableControls());

    }

    public void start() {
        printIntro();
        String border = repeatChar('-', currentLocation.getDescription().length());
        System.out.println(border);
        System.out.println(currentLocation.getDescription());
        System.out.println(border);
        System.out.println();
        displayControls();
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "inventory":
                case "i":
                    player.getInventory().showInventory();
                    break;
                case "open":
                case "o":
                    openChest();
                    break;
                case "north":
                case "n":
                    move("north");
                    break;
                case "south":
                case "s":
                    move("south");
                    break;
                case "east":
                case "e":
                    move("east");
                    break;
                case "west":
                case "w":
                    move("west");
                    break;
                case "back":
                case "b":
                    move("back");
                    break;
                case "quit":
                case "q":
                    running = false;
                    System.out.println("Thanks for playing Cave Dweller!");
                    break;
                default:
                    System.out.println("Unknown command. Try 'north', 'south', 'east', 'west', or 'quit'.");
                    break;
            }
        }
    }

    public void move(String direction) {
        if (direction.equals("back") || direction.equals("b")) {
            if (previousLocation != null) {
                Location temp = currentLocation;
                currentLocation = previousLocation;
                previousLocation = temp;


                String border = repeatChar('-', currentLocation.getDescription().length());
                System.out.println(border);
                System.out.println(currentLocation.getDescription());
                System.out.println(border);
                displayControls();
            } else {
                System.out.println("You can't go back from here!");
            }
            return;
        }
        Location nextLocation = currentLocation.getExit(direction);
        if (nextLocation != null) {
            previousLocation = currentLocation;
            currentLocation = nextLocation;

            String border = repeatChar('-', currentLocation.getDescription().length());
            System.out.println(border);
            System.out.println(currentLocation.getDescription());
            System.out.println(border);
            System.out.println();
            System.out.println(currentLocation.getAvailableControls());
            System.out.println("Utility commands: Inventory (i)");
        } else {
            System.out.println("You can't go that way!");
        }
    }

    private void openChest() {
        if (currentLocation instanceof NarrowPassage) {
            NarrowPassage passage = (NarrowPassage) currentLocation;
            List<Item> items = passage.getChest().openChest();
            for (Item item : items) {
                player.getInventory().addItem(item);
            }
            System.out.println();
            displayControls();
        } else {
            System.out.println("There is no chest here to open!");
        }
    }
}


