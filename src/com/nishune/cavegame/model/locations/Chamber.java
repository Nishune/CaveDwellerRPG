package com.nishune.cavegame.model.locations;

import com.nishune.cavegame.model.Location;

public class Chamber extends Location {

    public Chamber() {
        super("Chamber", "A vase chamber, something is living here.");

    }

    @Override
    public String getDescription() {
        return "You are in a large chamber, an enemy is approaching you from the shadows.";
    }

    @Override
    public String getAvailableControls() {
        return "";
    }
}
