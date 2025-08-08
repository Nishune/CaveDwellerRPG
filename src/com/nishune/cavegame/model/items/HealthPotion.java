package com.nishune.cavegame.model.items;

public class HealthPotion extends Item {

    private int healAmount;

    public HealthPotion() {
        super("Health Potion", "A red potion that restores 25 health points.");
        this.healAmount = 25;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
