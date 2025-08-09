package com.nishune.cavegame.controller;

import com.nishune.cavegame.model.character.Equipment;
import com.nishune.cavegame.model.character.Player;
import com.nishune.cavegame.model.items.BronzeSword;
import com.nishune.cavegame.model.items.Item;

import java.util.List;
import java.util.Scanner;

public class InventoryController {
    private Player player;
    private Scanner scanner;

    public InventoryController(Player player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }

    public void showInteractiveInventory() {
        if (player.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
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
                        showInteractiveInventory();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    showInteractiveInventory();
                }
            }
        } else {
            System.out.println("Unknown command. Try 'equip [number]' or 'back'.");
            showInteractiveInventory();
        }
    }

    public void showInteractiveCharacter() {
        System.out.println("\n=== Character Information ===");
        System.out.println("Name: " + player.getName());
        System.out.println("Health: " + player.getHealth() + " / " + player.getMaxHealth());
        System.out.println();
        player.getEquipment().showEquipment();
        System.out.println();

        boolean hasEquippedItems = false;
        for (Equipment.Slot slot : Equipment.Slot.values()) {
            if (player.getEquipment().getEquippedItem(slot) != null) {
                hasEquippedItems = true;
                break;
            }
        }

        if (hasEquippedItems) {
            System.out.println("Commands: Unequip (uneq), Back (b)");
            System.out.print("> ");

            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("b") || input.equals("back")) {
                return;
            }

            if (input.equals("uneq") || input.equals("unequip")) {
                showInteractiveUnequip();
            } else {
                System.out.println("Unknown command. Try 'unequip' or 'back'.");
                showInteractiveCharacter();
            }
        }
    }

    private void showInteractiveUnequip() {
        System.out.println("\n=== Unequip Items ===");

        int itemCount = 0;
        Equipment.Slot[] equippedSlots = new Equipment.Slot[Equipment.Slot.values().length];

        for (Equipment.Slot slot : Equipment.Slot.values()) {
            Item equippedItem = player.getEquipment().getEquippedItem(slot);
            if (equippedItem != null) {
                itemCount++;
                equippedSlots[itemCount - 1] = slot;
                System.out.println(itemCount + ". " + equippedItem.getName() + " (" + slot.toString().toLowerCase() + ")");
            }
        }

        if (itemCount == 0) {
            System.out.println("No items equipped.");
            showInteractiveCharacter();
            return;
        }

        System.out.println("\nCommands: Unequip [number] (e.g. 'unequip 1'), Back (b)");
        System.out.print("> ");

        String input = scanner.nextLine().toLowerCase().trim();

        if (input.equals("b") || input.equals("back")) {
            showInteractiveCharacter();
            return;
        }

        if (input.startsWith("unequip ") || input.startsWith("uneq ")) {
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                try {
                    int itemIndex = Integer.parseInt(parts[1]) - 1;
                    if (itemIndex >= 0 && itemIndex < itemCount) {
                        unequipItemBySlot(equippedSlots[itemIndex]);
                    } else {
                        System.out.println("Invalid item number.");
                        showInteractiveUnequip();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    showInteractiveUnequip();
                }
            }
        } else {
            System.out.println("Unknown command. Try 'unequip [number]' or 'back'.");
            showInteractiveUnequip();
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
    }

    private void unequipItemBySlot(Equipment.Slot slot) {
        Item unequippedItem = player.getEquipment().unequipItem(slot);
        if (unequippedItem != null) {
            player.getInventory().addItem(unequippedItem);
            System.out.println("Unequipped " + unequippedItem.getName() + " and added it to inventory.");
        }
    }

    private Equipment.Slot determineSlot(Item item) {
        if (item instanceof BronzeSword) {
            return Equipment.Slot.WEAPON;
        }
        return null;
    }
}