package com.nishune.cavegame.model.items;

public class BronzeSword extends Item {

    private int damage;

    public BronzeSword() {
        super("Warrior's Bronze Sword", "A bloodstained sword with a sharp blade, used by a Warrior");
        this.damage = 15;
    }


    public int getDamage() {
        return damage;
    }
}
