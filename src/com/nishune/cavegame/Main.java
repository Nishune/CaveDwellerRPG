package com.nishune.cavegame;

import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.World;
import com.nishune.cavegame.model.character.CharacterCreator;
import com.nishune.cavegame.model.character.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CharacterCreator characterCreator = new CharacterCreator(scanner);
        Player player = characterCreator.createCharacter();

        World world = new World();
        Location startingLocation = world.getStartingLocation();


        Game game = new Game(world, startingLocation, scanner, player, true);
        game.start();

    }
}
