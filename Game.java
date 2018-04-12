package e.ryanpetery.java;

/**
 * Created by Ryan Petery on 4/11/2018.
 */

public class Game {
    public int score;

    public int health;

    public Game() {
        score = 0;

        health = 3;
    }

    public boolean isHit(){ return true; }

    public boolean isDetected() { return true; }

    public void tick() {}

    public void main(String[] args) {}

}
