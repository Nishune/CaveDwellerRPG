package com.nishune.cavegame.command;

import com.nishune.cavegame.model.items.Item;
import com.nishune.cavegame.model.locations.NarrowPassage;

import java.util.List;

public class OpenCommand implements GameCommand {

    @Override
    public boolean execute(GameContext context) {
        if (context.getCurrentLocation() instanceof NarrowPassage) {
            NarrowPassage passage = (NarrowPassage) context.getCurrentLocation();
            List<Item> items = passage.getChest().openChest();
            for (Item item : items) {
                context.getPlayer().getInventory().addItem(item);
            }
            context.displayCurrentLocation();
            return true;
        } else {
            System.out.println("There is nothing to open here.");
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "Open a chest or container.";
    }
}