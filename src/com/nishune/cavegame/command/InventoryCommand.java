package com.nishune.cavegame.command;

public class InventoryCommand implements GameCommand {

    @Override
    public boolean execute(GameContext context) {
        context.getInventoryController().showInteractiveInventory();
        context.displayCurrentLocation();
        return true;
    }

    @Override
    public String getDescription() {
        return "Display your inventory";
    }
}
