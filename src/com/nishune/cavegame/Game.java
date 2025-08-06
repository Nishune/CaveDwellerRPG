package com.nishune.cavegame;

import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.locations.Entrance;

import java.util.Scanner;

public class Game {
    private Location currentLocation;

    public Game() {
        currentLocation = new Entrance();
    }
    public void start() {
        System.out.println("You are at the " + currentLocation.getName());
        System.out.println(currentLocation.getDescription());

        currentLocation.onEnter();
    }

    public void movePlayer(String direction) {

        currentLocation.onExit(direction);
    }

    public void playGame(Scanner scanner) {
        System.out.print("Welcome to Cave Dweller! Explore the cave and discover its secrets.");
        System.out.println();
        System.out.println(currentLocation.getName());
        System.out.println(currentLocation.getDescription());
        System.out.println();

        boolean inMenu = true;
        while (inMenu) {
            System.out.print("What do you want to do? (enter / quit): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("enter")) {
                currentLocation.onEnter();
                inMenu = false;

                boolean playing = true;
                while (playing) {
                    System.out.print("\nEnter command (move <direction>/quit): ");
                    String input = scanner.nextLine().trim().toLowerCase();

                    if (input.equals("quit")) {
                        System.out.println("Thanks for playing Cave Dweller!");
                        playing = false;
                    } else if (input.startsWith("move")) {
                        String direction = input.substring(5);
                        movePlayer(direction);
                    } else {
                        System.out.println("Unknown command. try 'move north' or 'quit'");
                    }
                }
            } else if (choice.equals("quit")) {
                System.out.println("Thanks for playing Cave Dweller!");
                inMenu = false;
            } else {
                System.out.println("Invalid choice. Please enter 'enter' to start or 'quit' to exit.");
            }
        }
    }
}
