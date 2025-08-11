package com.nishune.cavegame.command;

public class CharacterCommand implements GameCommand {

    @Override
    public boolean execute(GameContext context) {
        context.getInventoryController().showInteractiveCharacter();
        return true;
    }

    @Override
    public String getDescription() {
        return "View character information";
    }
}
