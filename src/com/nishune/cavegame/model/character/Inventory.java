package com.nishune.cavegame.model.character;

import com.nishune.cavegame.model.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Added " + item + " to inventory.");
    }

    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(item -> item.getName().equals(itemName));
    }

    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory: ");
            for (Item item : items) {
                System.out.println("- " + item.getName());
            }
        }
    }
}
