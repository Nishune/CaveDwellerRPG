package com.nishune.cavegame;

import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.World;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        World world = new World();
        Location startingLocation = world.getStartingLocation();
        Scanner scanner = new Scanner(System.in);

        Game game = new Game(world, startingLocation, scanner, true);
        game.start();

    }
}
