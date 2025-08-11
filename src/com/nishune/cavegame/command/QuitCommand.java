package com.nishune.cavegame.command;

public class QuitCommand implements GameCommand {

    @Override
    public boolean execute(GameContext context) {
        context.setRunning(false);
        System.out.println("Thanks for playing Cave Dweller!");
        return true;
    }

    @Override
    public String getDescription() {
        return "Quit the game";
    }
}
