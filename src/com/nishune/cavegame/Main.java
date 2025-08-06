package com.nishune.cavegame;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();

        game.movePlayer("north");
        game.movePlayer("exit");
    }
}
