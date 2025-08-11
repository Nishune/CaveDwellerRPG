package com.nishune.cavegame.command;

public interface GameCommand {
    boolean execute(GameContext context);

    String getDescription();
}
