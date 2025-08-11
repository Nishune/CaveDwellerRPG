package com.nishune.cavegame.model.items;

import com.nishune.cavegame.model.character.Player;

public abstract class ConsumableItem {

    public ConsumableItem(String name, String description) {
        super(name, description);
    }

    public abstract void consume(Player player);
}
