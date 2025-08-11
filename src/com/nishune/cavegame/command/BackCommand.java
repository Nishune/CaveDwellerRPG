package com.nishune.cavegame.command;

import com.nishune.cavegame.model.Location;

public class BackCommand implements GameCommand {

    @Override
    public boolean execute(GameContext context) {
        if (context.getPreviousLocation() != null) {
            Location temp = context.getCurrentLocation();
            context.setCurrentLocation(context.getPreviousLocation());
            context.setPreviousLocation(temp);

            displayLocation(context);
            return true;
        } else {
            System.out.println("You can't go back from here!");
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
        return "Go back to the previous location.";
    }
}
