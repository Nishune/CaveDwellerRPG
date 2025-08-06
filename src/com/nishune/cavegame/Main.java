package com.nishune.cavegame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.playGame(scanner);
        scanner.close();

    }
}
