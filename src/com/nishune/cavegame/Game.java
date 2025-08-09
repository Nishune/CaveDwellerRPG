package com.nishune.cavegame;

import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.World;
import com.nishune.cavegame.model.character.Equipment;
import com.nishune.cavegame.model.character.Player;
import com.nishune.cavegame.model.items.BronzeSword;
import com.nishune.cavegame.model.items.Item;
import com.nishune.cavegame.model.locations.BloodstainedDoor;
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
        System.out.println("Utility commands: Inventory (i), Character (c)");
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
                    interactiveInventory();
                    break;
                case "equip":
                case "eq":
                    equipWeapon();
                    break;
                case "character":
                case "c":
                    showCharacter();
                    break;
                case "open":
                case "o":
                    openChest();
                    break;
                case "take":
                case "t":
                    takeSword();
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

    private void showCharacter() {
        System.out.println("\n=== Character Information ===");
        System.out.println("Name: " + player.getName());
        System.out.println("Health: " + player.getHealth() + " / " + player.getMaxHealth());
        System.out.println();
        player.getEquipment().showEquipment();
        System.out.println();
        displayControls();
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

    private void takeSword() {
        if (currentLocation instanceof BloodstainedDoor) {
            BloodstainedDoor bloodstainedRoom = (BloodstainedDoor) currentLocation;
            if (!bloodstainedRoom.isSwordTaken()) {
                BronzeSword sword = bloodstainedRoom.getSword();
                player.getInventory().addItem(sword);
                bloodstainedRoom.setSwordTaken(true);
                displayControls();
            } else {
                System.out.println("You have already taken the sword from the dead warrior.");
            }
        }
    }

    private void equipWeapon() {
        if (player.getInventory().hasItem("Warrior's Bronze Sword")) {
            Item sword = player.getInventory().removeItem("Warrior's Bronze Sword");
            if (sword != null) {
                player.getEquipment().equipItem(sword, Equipment.Slot.WEAPON);
            }
        } else {
            System.out.println("You dont have a weapon to equip!");
        }
    }

    private void interactiveInventory() {
        if (player.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
            displayControls();
            return;
        }

        System.out.println("\n=== Interactive Inventory ===");
        List<Item> items = player.getInventory().getItems();

        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " - " + items.get(i).getDescription());
        }

        System.out.println("\nCommands: Equip [number] (e.g. 'equip 1'), back (b)");
        System.out.print("> ");

        String input = scanner.nextLine().toLowerCase().trim();

        if (input.equals("b") || input.equals("back")) {
            displayControls();
            return;
        }

        if (input.startsWith("equip ") || input.startsWith("eq ")) {
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                try {
                    int itemIndex = Integer.parseInt(parts[1]) - 1;
                    if (itemIndex >= 0 && itemIndex < items.size()) {
                        equipItemByIndex(itemIndex);
                    } else {
                        System.out.println("Invalid item number.");
                        interactiveInventory();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    interactiveInventory();
                }
            }
        } else {
            System.out.println("Unknown command. Try 'equip [number]' or 'back'.");
            interactiveInventory();
        }
    }

    private void equipItemByIndex(int index) {
        List<Item> items = player.getInventory().getItems();
        Item item = items.get(index);

        Equipment.Slot slot = determineSlot(item);
        if (slot != null) {
            Item removedItem = player.getInventory().removeItem(item.getName());
            if (removedItem != null) {
                if (player.getEquipment().equipItem(removedItem, slot)) {
                    System.out.println("Equipped " + item.getName());
                } else {
                    player.getInventory().addItem(removedItem);
                }
            }
        } else {
            System.out.println("This item cannot be equipped.");
        }
        displayControls();
    }

    private Equipment.Slot determineSlot(Item item) {
        if (item instanceof BronzeSword) {
            return Equipment.Slot.WEAPON;
        }
        return null;
    }
}


