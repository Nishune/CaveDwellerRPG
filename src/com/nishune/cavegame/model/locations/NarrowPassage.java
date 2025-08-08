package com.nishune.cavegame.model.locations;

import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.items.Chest;
import com.nishune.cavegame.model.items.HealthPotion;

public class NarrowPassage extends Location {
    private Chest chest;

    public NarrowPassage() {
        super("Narrow Passage", """
                
                After squeezing through the narrow passage, you find youtself in a dimly lit corridor.
                An old chest sits against the wall, covered in dust and cobwebs.
                
                You have a feeling that this chest might hold something valuable for your journey, but could it be a trap?
                
                You have two options:
                - Open the chest
                - Leave the chest alone and continue exploring the cave
                
                """);
        this.chest = new Chest();
        chest.addItem(new HealthPotion());
        chest.addItem(new HealthPotion());
    }

    public Chest getChest() {
        return chest;
    }

    @Override
    public String getAvailableControls() {
        return "Available commands: Open Chest (o), Go Back (b), Quit Game (q)";
    }
}
