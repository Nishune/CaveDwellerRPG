package com.nishune.cavegame.model.character;

import com.nishune.cavegame.model.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Equipment {

    private Map<Slot, Item> equippedItems;

    public Equipment() {
        this.equippedItems = new HashMap<>();
    }

    public boolean equipItem(Item item, Slot slot) {
        if (equippedItems.containsKey(slot)) {
            System.out.println("You have already equipped an item in the " + slot.name().toLowerCase() + " slot.");
            return false;
        }
        equippedItems.put(slot, item);
        System.out.println("Equipped " + item.getName() + " in " + slot.toString().toLowerCase() + " slot.");
        return true;
    }

    public Item unequipItem(Slot slot) {
        return equippedItems.remove(slot);
    }

    public Item getEquippedItem(Slot slot) {
        return equippedItems.get(slot);
    }

    public void showEquipment() {
        System.out.println("Equipped items:");
        for (Slot slot : Slot.values()) {
            Item item = equippedItems.get(slot);
            System.out.println("- " + slot.toString().toLowerCase() + ": " + (item != null ? item.getName() : "Nothing equipped"));
        }
    }

    public enum Slot {
        HELMET, GLOVES, BOOTS, PANTS, WEAPON
    }
}
