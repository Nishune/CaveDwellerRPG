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
        System.out.println();
        System.out.println("Added " + item + " to inventory.");
    }

    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(item -> item.getName().equals(itemName));
    }

    public Item removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(itemName)) {
                return items.remove(i);
            }
        }
        return null;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    ;

    public boolean isEmpty() {
        return items.isEmpty();
    }

}
