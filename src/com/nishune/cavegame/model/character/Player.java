package com.nishune.cavegame.model.character;

public class Player {
    private String name;
    private String gender;
    private int health;
    private int maxHealth;
    private Inventory inventory;
    private Equipment equipment;

    public Player(String name, String gender) {
        this.name = name;
        this.gender = gender;
        health = 100;
        maxHealth = 100;
        this.inventory = new Inventory();
        this.equipment = new Equipment();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ") - Health: " + health + "/" + maxHealth;
    }
}
