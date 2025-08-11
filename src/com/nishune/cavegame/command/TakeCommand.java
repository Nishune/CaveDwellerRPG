package com.nishune.cavegame.command;

import com.nishune.cavegame.model.items.BronzeSword;
import com.nishune.cavegame.model.locations.BloodstainedDoor;

public class TakeCommand implements GameCommand {

    @Override
    public boolean execute(GameContext context) {
        if (context.getCurrentLocation() instanceof BloodstainedDoor) {
            BloodstainedDoor bloodstainedRoom = (BloodstainedDoor) context.getCurrentLocation();
            if (!bloodstainedRoom.isSwordTaken()) {
                BronzeSword sword = bloodstainedRoom.getSword();
                bloodstainedRoom.setSwordTaken(true);
                System.out.println("You carefully take the bronze sword from the fallen warrior's grip.");
                context.getPlayer().getInventory().addItem(sword);
                context.displayCurrentLocation();
                return true;
            } else {
                System.out.println("You have already taked the sword from the dead warrior.");
                return false;
            }
        } else {
            System.out.println("There is no sword to take here!");
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "Take an item from the current location";
    }
}
