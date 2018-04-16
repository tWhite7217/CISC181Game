package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
This class contains the logic for the game and is the main class that starts a new game.
 */

import java.util.ArrayList;

public class Game {
    private int score;
    private int health;
    private IUIEngine uiEngine;
    private ArrayList<GameObjects> gameObjects = new ArrayList<>();

    public Game() {
        score = 0;
        health = 3;
        uiEngine = new ConsoleGraphics();
    }

    public boolean isHit(){ return true; }

    public boolean isDetected() { return true; }

    public void startGame() {}

    public void tick() {}

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

}
