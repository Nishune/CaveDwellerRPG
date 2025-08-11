package com.nishune.cavegame.command;

import com.nishune.cavegame.model.Location;

public class MoveCommand implements GameCommand {

    private String direction;

    public MoveCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public boolean execute(GameContext context) {
        Location nextLocation = context.getCurrentLocation().getExit(direction);

        if (nextLocation != null) {
            context.moveToLocation(nextLocation);
            displayLocation(context);
            return true;
        } else {
            System.out.println("You can't go that way!");
            return false;
        }
    }

    private void displayLocation(GameContext context) {
        String description = context.getCurrentLocation().getDescription();
        String border = "-".repeat(description.length());
        System.out.println(border);
        System.out.println(description);
        System.out.println(border);
        System.out.println();
        System.out.println(context.getCurrentLocation().getAvailableControls());
    }

    @Override
    public String getDescription() {
        return "Move " + direction;
    }
}
