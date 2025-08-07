package com.nishune.cavegame.model.locations;

import com.nishune.cavegame.model.Location;

public class BloodstainedDoor extends Location {

    public BloodstainedDoor() {
        super("Bloodstained Door", """
                
                You stand before a door that is damaged and stained with blood. The air is thick with an unsettling silence, 
                and the faint smell of iron lingers. The door appears to have been forced open, leaving jagged edges and splintered wood.
                
                On the ground, you discover a dead warrior lying face down, his armor dented and his sword still tightly gripped in his hand.
                
                You have a choice to make:
                - Take the warrior's sword.
                - Leave the sword and step back through the door.
                
                """);
    }

    @Override
    public String getAvailableControls() {
        return "Available commands: Take Sword (t), Step Back (b), Quit Game (q)";
    }
}
