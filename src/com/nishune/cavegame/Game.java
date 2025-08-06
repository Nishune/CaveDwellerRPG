package com.nishune.cavegame;

import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.World;

import java.util.Scanner;

public class Game {
    private World world;
    private Location currentLocation;
    private Scanner scanner;
    private boolean running;

    public Game(World world, Location currentLocation, Scanner scanner, boolean running) {
        this.world = world;
        this.currentLocation = currentLocation;
        this.scanner = scanner;
        this.running = running;
    }

    public void start() {
        System.out.println("Welcome to Cave Dweller!");
        System.out.println(currentLocation.getDescription());

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
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
        Location nextLocation = currentLocation.getExit(direction);
        if (nextLocation != null) {
            currentLocation.onExit(direction);
            currentLocation = nextLocation;
            currentLocation.onEnter();
            System.out.println(currentLocation.getDescription());
        } else {
            System.out.println("You can't go that way!");
        }
    }
}
