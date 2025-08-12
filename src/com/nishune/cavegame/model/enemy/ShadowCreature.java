package com.nishune.cavegame.model.enemy;

public class ShadowCreature extends Enemy {

    public ShadowCreature() {
        super("Shadow Creature", 30, 8);
    }

    @Override
    public String getAttackMessage() {
        return "The shadow Creature lunges at you with its dark claws!";
    }

    @Override
    public String getDeathMessage() {
        return "The shadow Creature falls down to the ground, its death is silent and eerie.";
    }
}
