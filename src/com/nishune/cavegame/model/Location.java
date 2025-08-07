package com.nishune.cavegame.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Location {

    protected String name;
    protected String description;
    protected Map<String, Location> exits;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
    }

    public String getDescription() {
        return description;
    }

    public void setExit(String direction, Location location) {
        exits.put(direction, location);
    }

    public Location getExit(String direction) {
        return exits.get(direction);
    }

    public abstract String getAvailableControls();

}
