# CaveDwellerRPG

A small, text-based RPG prototype where you explore a dark cave, collect items, and equip gear through simple commands.
It’s a learning project focused on practicing core Java and object‑oriented programming concepts in a contained,
playable example.

## What this project is

CaveDwellerRPG is a console adventure game. You:

- Enter your character’s name and gender.
- Read narrative descriptions of locations as you move around the cave.
- Use simple commands (north, south, open, take, inventory, equip, etc.).
- Find items (e.g., Health Potions, a Bronze Sword) and equip gear.

It’s designed to be easy to read and extend, making it suitable for experimenting with Java fundamentals.

## Java concepts practiced

This project intentionally exercises several Java concepts:

- Object‑Oriented Design
    - Abstraction via abstract base classes (Location, Item)
    - Inheritance with concrete subclasses (Entrance, Hallway, NarrowPassage, BloodstainedDoor; BronzeSword,
      HealthPotion)
    - Composition (World contains and wires Locations; Player has Inventory and Equipment)
    - Encapsulation with getters and private fields
    - Basic polymorphism (treating locations/items via their abstract types)
- Collections API
    - Maps for exits between locations
    - Lists for inventory and chest contents
- Packages and project structure (com.nishune.cavegame and subpackages)
- Control flow and user input (Scanner-driven command loop)
- Enums (Equipment.Slot)
- Java 15+ text blocks for multi-line descriptions (""")

## How to run the project

Requirement: Java 17 (or newer) is recommended, Java 15+ required (for text blocks).

Option A — Run in IntelliJ IDEA (recommended)

1. Open the project folder (CaveDwellerRPG) in IntelliJ.
2. Ensure Project SDK is set to Java 17+ (File > Project Structure > Project SDK).
3. Locate Main.java at src/com/nishune/cavegame/Main.java.
4. Right‑click Main and choose “Run 'Main'”.

Option B — Run from the command line
From the project root directory:

1. Compile sources into an out directory:
    - Windows PowerShell:
      javac -d out -sourcepath src src\com\nishune\cavegame\Main.java
    - macOS/Linux (if applicable):
      javac -d out -sourcepath src src/com/nishune/cavegame/Main.java
2. Run the program:
    - Windows PowerShell:
      java -cp out com.nishune.cavegame.Main
    - macOS/Linux:
      java -cp out com.nishune.cavegame.Main

If you see errors about text blocks, ensure your Java version is 15+ and the project language level is set
appropriately.

## Controls (in-game commands)

- Movement: north (n), south (s), east (e), west (w), back (b)
- Inventory: inventory (i)
- Equip currently owned weapon: equip (eq)
- Character sheet: character (c)
- Contextual actions:
    - At a chest: open (o)
    - At the bloodstained door: take (t) — take the sword
- Quit game: quit (q)

## Project structure (high level)

- src/com/nishune/cavegame
    - Main.java — Program entry
    - Game.java — Game loop and input handling
- src/com/nishune/cavegame/model
    - World.java — Builds locations and exits
    - Location.java — Abstract base for locations
    - character/ — Player, Inventory, Equipment (with Slot enum)
    - items/ — Item (abstract), BronzeSword, HealthPotion, Chest
    - locations/ — Entrance, Hallway, NarrowPassage, BloodstainedDoor

## Features you can try

- Explore: Move between rooms and read narrative descriptions.
- Loot: Open a chest to acquire health potions.
- Equip: Take a sword and equip it via the inventory.
- Inspect: View your character’s health and equipped items.

## Ideas for future improvements

- Combat system and enemies
- Saving/loading game state
- More item types and equipment slots
- Expanded world with puzzles and branching paths
- Command help and input validation improvements

