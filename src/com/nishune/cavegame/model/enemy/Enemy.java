package com.nishune.cavegame.model.enemy;

public abstract class Enemy {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attackDamage;
    protected boolean isAlive;

    public Enemy(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackDamage = attackDamage;
        this.isAlive = true;
    }

    public abstract String getAttackMessage();

    public abstract String getDeathMessage();

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
        if (health == 0) {
            isAlive = false;
        }
    }

    public int attack() {
        return attackDamage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
