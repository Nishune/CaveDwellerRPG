package com.nishune.cavegame.model.items;

import java.util.ArrayList;
import java.util.List;

public class Chest {
    private List<Item> contents;
    private boolean isOpened;

    public Chest() {
        this.contents = new ArrayList<>();
        this.isOpened = false;
    }

    public void addItem(Item item) {
        contents.add(item);
    }

    public List<Item> openChest() {
        if (!isOpened) {
            isOpened = true;
            System.out.println("You opened the chest and found: ");
            for (Item item : contents) {
                System.out.println("- " + item.getName() + " which has been added to your inventory.");
            }
            return new ArrayList<>(contents);
        } else {
            System.out.println("This chest seems to have its contents already taken! :(");
            return new ArrayList<>();
        }
    }

    public boolean isOpened() {
        return isOpened;
    }
}
