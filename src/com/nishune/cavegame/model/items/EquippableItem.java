package com.nishune.cavegame.model.items;

import com.nishune.cavegame.model.character.Equipment;

public abstract class EquippableItem extends Item {

    public EquippableItem(String name, String description) {
        super(name, description);
    }

    public abstract Equipment.Slot getSlot();
}
