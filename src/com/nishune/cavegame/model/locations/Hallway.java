package com.nishune.cavegame.model.locations;

import com.nishune.cavegame.model.Location;

public class Hallway extends Location {

    public Hallway() {
        super("The Hallway", """
                
                The cave suddenly opens up, feeling broader than before - yet it remains cold and unwelcoming.
                
                 Three paths lie ahead:
                 - To the North, there is a damaged door with bloodstains on it.
                 - To the East, the cave seems to expand into a larger chamber.
                 - To the West, a narrow passage is open. Something glimmers faintly in the darkness.
                
                """);
    }

    @Override
    public String getAvailableControls() {
        return "Available commands: North (n), East (e), West (w), Back (b), Quit (q)";
    }


}


