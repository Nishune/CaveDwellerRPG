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
        if (direction.equals("exit")) {
            System.out.println("You exit the cave, stepping back into the light of day.");
        } else if (direction.equals("north")) {
            System.out.println("You head deeper into the cave, the path winding further into the darkness.");
        }
    }
}
