package com.nishune.cavegame.command;

import com.nishune.cavegame.controller.InventoryController;
import com.nishune.cavegame.model.Location;
import com.nishune.cavegame.model.character.Player;

import java.util.Scanner;

public class GameContext {

    private Player player;
    private Location currentLocation;
    private Location previousLocation;
    private InventoryController inventoryController;
    private Scanner scanner;
    private boolean running;

    public GameContext(Player player, Location currentLocation, InventoryController inventoryController, Scanner scanner, boolean running) {
        this.player = player;
        this.currentLocation = currentLocation;
        this.inventoryController = inventoryController;
        this.scanner = scanner;
        this.running = true;
    }

    public Player getPlayer() {
        return player;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Location getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }

    public InventoryController getInventoryController() {
        return inventoryController;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void moveToLocation(Location newLocation) {
        if (newLocation != null) {
            this.previousLocation = this.currentLocation;
            this.currentLocation = newLocation;
        }
    }
}
