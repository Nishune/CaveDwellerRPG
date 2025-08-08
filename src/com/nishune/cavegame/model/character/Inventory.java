package com.nishune.cavegame.model.character;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<String> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
        System.out.println("Added " + item + " to inventory.");
    }

    public boolean hasItem(String item) {
        return items.contains(item);
    }

    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory: " + items);
        }
    }
}
