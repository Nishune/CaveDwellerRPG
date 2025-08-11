package com.nishune.cavegame.model.character;

import java.util.Scanner;

public class CharacterCreator {

    private Scanner scanner;

    public CharacterCreator(Scanner scanner) {
        this.scanner = scanner;
    }

    public Player createCharacter() {
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        String gender = "";
        while (gender.isEmpty()) {
            System.out.println("Choose your character's gender:");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.print("Enter your choice (1 or 2): ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    gender = "Male";
                    break;
                case "2":
                    gender = "Female";
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    break;
            }
        }
        return new Player(name, gender);
    }
}
