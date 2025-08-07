package com.nishune.cavegame.model.locations;

import com.nishune.cavegame.model.Location;

public class NarrowPassage extends Location {

    public NarrowPassage() {
        super("Narrow Passage", """
                
                After squeezing through the narrow passage, you find youtself in a dimly lit corridor.
                An old chest sits against the wall, covered in dust and cobwebs.
                
                You have a feeling that this chest might hold something valuable for your journey, but could it be a trap?
                
                You have two options:
                - Open the chest
                - Leave the chest alone and continue exploring the cave
                
                """);
    }

    @Override
    public String getAvailableControls() {
        return "Available commands: Open Chest (o), Go Back (b), Quit Game (q)";
    }
}
