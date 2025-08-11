package com.nishune.cavegame.model.items;

import com.nishune.cavegame.model.character.Player;

public class HealthPotion extends ConsumableItem {

    private int healAmount;

    public HealthPotion() {
        super("Health Potion", "A red potion that restores 25 health points.");
        this.healAmount = 25;
    }

    @Override
    public void consume(Player player) {
        player.heal(healAmount);
        System.out.println("You consumed a health potion and restored " + healAmount + " health!");
    }

    public int getHealAmount() {
        return healAmount;
    }
}
