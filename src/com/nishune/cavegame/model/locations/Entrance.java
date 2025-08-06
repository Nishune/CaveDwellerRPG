package com.nishune.cavegame.model.locations;

import com.nishune.cavegame.model.Location;

public class Entrance extends Location {

    public Entrance() {
        super("Cave Entrance", "You stand at the mouth of a dark cave, the air is cool and damp." +
                " The cave seems to stretch deep into the earth, its entrance framed by jagged rocks." +
                " A faint sound of dripping water echoes from within.");
    }

    @Override
    public void onEnter() {
        System.out.println("You step into the cave, the darkness enveloping you as you venture deeper.");
    }

    @Override
    public void onExit(String direction) {
        switch (direction) {
            case "north" ->
                    printDirectionMessage(direction, "You move deeper into the cave, the darkness thickens around you.");
            case "south" ->
                    printDirectionMessage(direction, "You step back outside, feeling the fresh air once again.");
            default -> {
                System.out.println("Unknown direction. Try 'forward' to go deeper into the cave or 'back' to return to the entrance.");
            }
        }
    }
}
