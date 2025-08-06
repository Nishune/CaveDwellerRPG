package com.nishune.cavegame.model.locations;

import com.nishune.cavegame.model.Location;

public class Hallway extends Location {

    public Hallway() {
        super("The Hallway", "You find yourself in a hallway." +
                " The cave suddenly opens up, feeling broader than before - yet it remains cold and unwelcoming." +
                " Three paths lie ahead, each leading deeper into the unknown.");
    }

    @Override
    public void onEnter() {
        System.out.println("Three paths lie ahead, each leading deeper into the unknown.");
        System.out.println("-".repeat(30));
        System.out.println("North: A narrow passage that seems to lead to a dead end.");
        System.out.println("East: A wider tunnel that seems to expand into a larger chamber.");
        System.out.println("West: Someone has been struggling here, the ground is disturbed and the walls are scratched.");
        System.out.println("-".repeat(30));
    }

    @Override
    public void onExit(String direction) {
        switch (direction) {

            case "exit" ->
                    printDirectionMessage(direction, "You return back to the cave entrance, it feels warmer here.");
            case "north" ->
                    printDirectionMessage(direction, "You squeeze through the narrow passage, maybe there is something valuable here?");
            case "east" ->
                    printDirectionMessage(direction, "You enter a large chamber, the smell of death is overwhelming.");
            case "west" ->
                    printDirectionMessage(direction, "There is a dead body on the ground, it could have items on it.");
            default -> System.out.println("Unknown direction. Try 'north', 'east', 'west' or 'exit'.");

        }
    }

}


