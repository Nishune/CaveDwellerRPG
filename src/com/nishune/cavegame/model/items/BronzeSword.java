package com.nishune.cavegame.model.items;

import com.nishune.cavegame.model.character.Equipment;

public class BronzeSword extends EquippableItem {

    private int damage;

    public BronzeSword() {
        super("Warrior's Bronze Sword", "A bloodstained sword with a sharp blade, used by a Warrior");
        this.damage = 15;
    }


    @Override
    public Equipment.Slot getSlot() {
        return Equipment.Slot.WEAPON;
    }

    public int getDamage() {
        return damage;
    }
}

