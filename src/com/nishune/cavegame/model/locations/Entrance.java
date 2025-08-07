package com.nishune.cavegame.model.locations;

import com.nishune.cavegame.model.Location;

public class Entrance extends Location {

    public Entrance() {
        super("Cave Entrance", "You stand at the mouth of a dark cave, the air is cool and damp." +
                " The cave seems to stretch deep into the earth, its entrance framed by jagged rocks." +
                " A faint sound of dripping water echoes from within.");
    }

    @Override
    public String getAvailableControls() {
        return "Available commands: North (n), Quit (q)";
    }

}
