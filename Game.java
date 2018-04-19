package e.ryanpetery.java;

/*
Ryan Petery and Tommy White
4/15/18
This class contains the logic for the game and is the main class that starts a new game.
 */

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class Game {
    private int score;
    private int health;
    private IUIEngine uiEngine;
    private IControls controls;
    private ArrayList<Target> targets = new ArrayList<>();
    private ArrayList<RadarPlane> radarPlanes = new ArrayList<>();
    private CrossHairs crossHair = new CrossHairs();

    public Game() {
        score = 0;
        health = 3;
        uiEngine = new ConsoleGraphics();
        controls = new ConsoleControls();
    }

    public void move() {
        String moveString = controls.move();
        if(moveString.equals("w")) {  crossHair.position[1] += 1; }
        if(moveString.equals("s")) { crossHair.position[1] -= 1; }
        if(moveString.equals("a")) {crossHair.position[0] -= 100;}
        if(moveString.equals("d")) {crossHair.position[0] += 100;}
    }

    public void moveTargetsandPlanes() { //temporary move values
        for(int i = 0; i < targets.size(); i++) {
            targets.get(i).position[0] -= 10;
            if(targets.get(i).position[0] < 0) {
                targets.remove(i);
                i--;
            }
        }
        for(int i1 = 0; i1 < radarPlanes.size(); i1++) {
            radarPlanes.get(i1).position[0] -= 10;
            if(radarPlanes.get(i1).position[0] < 0) {
                radarPlanes.remove(i1);
                i1--;
            }
        }
    }

    public void isHit(){
        for(int i = 0; i < targets.size(); i++) {
            if(Math.abs(targets.get(i).position[0] - crossHair.position[0]) <= 0.5*(1.0/4.0 + (1.0/4.0) * ((targets.get(i).size))) && (targets.get(i).position[1] == crossHair.position[1])) {
                if(controls.fire()) {
                    if(targets.get(i).givesHeart) {health += 1;}
                    score += targets.get(i).pointValue;
                    targets.remove(i);
                    i--;
                }
            }
        }
    }

    public void isDetected() {
        for(int i = 0; i< radarPlanes.size(); i++) {
            if(Math.abs(radarPlanes.get(i).position[0] - crossHair.position[0]) <= 0.5*(radarPlanes.get(i).size)) {
                health--;
            }
        }
    }

    public void startGame() {
        uiEngine.showIntro();
        while (health > 0) {
            tick();
        }
        uiEngine.showScore(score);
    }

    public void spawn() {
        Random random = new Random();
        int randInt = random.nextInt(1); // variate for game performance
        if (randInt == 0) {
            int randTargetInt = random.nextInt(100);
            if (randTargetInt == 0) {
                targets.add(new Target(true));
            } // complete
            else {
                int planeOrTarget = random.nextInt(1);
                if (planeOrTarget == 0) {
                    targets.add(new Target());
                } else {
                    radarPlanes.add(new RadarPlane());
                }
            }
        }
    }

    public void tick() {
        spawn();
        isHit();
        isDetected();
        uiEngine.updateUI(targets, radarPlanes, crossHair);
        move();
        moveTargetsandPlanes();
        uiEngine.updateUI(targets, radarPlanes, crossHair);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

}
