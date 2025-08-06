package com.nishune.cavegame;

import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.locations.Entrance;

public class Game {
    private Location currentLocation;

    public Game() {
        currentLocation = new Entrance();
    }
    public void start() {
        System.out.println("You are at the " + currentLocation.getName());
        System.out.println(currentLocation.getDescription());

        currentLocation.onEnter();
    }

    public void movePlayer(String direction) {

        currentLocation.onExit(direction);
    }

}
