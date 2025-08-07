package com.nishune.cavegame.model.character;

public class Player {
    private String name;
    private String gender;
    private int health;
    private int maxHealth;

    public Player(String name, String gender) {
        this.name = name;
        this.gender = gender;
        health = 100;
        maxHealth = 100;
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

    public void heal(int amout) {
        health = Math.min(maxHealth, health + amout);
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ") - Health: " + health + "/" + maxHealth;
    }
}
