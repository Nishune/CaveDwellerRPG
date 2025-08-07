package com.nishune.cavegame.model;

import com.nishune.cavegame.model.locations.Entrance;
import com.nishune.cavegame.model.locations.Hallway;
import com.nishune.cavegame.model.locations.NarrowPassage;

import java.util.HashMap;
import java.util.Map;

// The world-class represents the gameworld and handles all the locations and their connections.
public class World {
    //Map that stores all the locations with name as key. (eg, "entrance" -> Entrance object)
    private Map<String, Location> locations;


    //Constructor that initializes the world with locations and their connections.
    public World() {
        locations = new HashMap<>();
        initializeLocations();
        setupConnections();
    }

    // Initializes the locations in the game, and adds them to the locations map.
    private void initializeLocations() {
        locations.put("entrance", new Entrance());
        locations.put("hallway", new Hallway());
        locations.put("narrow passage", new NarrowPassage());

    }

    // Sets up the connections between the locations.
    private void setupConnections() {

        locations.get("entrance").setExit("north", locations.get("hallway"));
        locations.get("hallway").setExit("south", locations.get("entrance"));
        locations.get("hallway").setExit("west", locations.get("narrow passage"));
        locations.get("narrow passage").setExit("east", locations.get("hallway"));
    }

    // returns the starting location of the game, which is the entrance.
    public Location getStartingLocation() {
        return locations.get("entrance");
    }

    // Returns a location by its name.
    public Location getLocation(String locationName) {
        return locations.get(locationName);
    }
}
