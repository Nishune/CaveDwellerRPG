package com.nishune.cavegame.model;

public abstract class Location {

    protected String name;
    protected String description;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void onEnter();
    public abstract void onExit(String direction);
}
