package g.cisc181.game;

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
    private TimeDelay timeDelay;

    public Game(IUIEngine engine, IControls contr) {
        score = 0;
        health = 3;
        uiEngine = engine;
        controls = contr;
    }

    public int getHealth(){
        return health;
    }

    public int getScore() {
        return score;
    }

    public IUIEngine getUiEngine() {
        return uiEngine;
    }

    public IControls getControls() {
        return controls;
    }

    public void move() {
        String moveString = controls.move();
        if(moveString.equals("w")) {
            controls.setInput("");
            if(crossHair.position[1] != 3) {
                crossHair.position[1] += 1;
            }
        }
        if(moveString.equals("s")) {
            controls.setInput("");
            if(crossHair.position[1] != 1) {
                crossHair.position[1] -= 1;
            }
        }
        if(moveString.equals("a")) {
            controls.setInput("");
            if(crossHair.position[0] > 99) {
                crossHair.position[0] -= 100;
            }
        }
        if(moveString.equals("d")) {
            controls.setInput("");
            if(crossHair.position[0] < 499) {
                crossHair.position[0] += 100;
            }
        }
    }

    public void moveTargetsAndPlanes() { //temporary move values
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

    public void isHit() {
        if (controls.fire()) {
            controls.setInput("");
            for (int i = 0; i < targets.size(); i++) {
                if (Math.abs(targets.get(i).position[0] - crossHair.position[0]) <= ((25 + (25 * (targets.get(i).size)))/2) && targets.get(i).position[1] == crossHair.position[1]) {
                    if (targets.get(i).givesHeart) {
                        health += 1;
                    }
                    score += targets.get(i).pointValue;
                    targets.remove(i);
                    i--;
                }

            }
        }
    }

    public void isDetected() {
        for(int i = 0; i< radarPlanes.size(); i++) {
            if((Math.abs(radarPlanes.get(i).position[0] - crossHair.position[0]) <= 25) && radarPlanes.get(i).position[1] == crossHair.position[1] && !(radarPlanes.get(i).hasDetected)) {
                health--;
                radarPlanes.get(i).hasDetected = true;
            }
        }
    }

    public void startGame() {
        uiEngine.showIntro();
        uiEngine.setGame(this);
        this.timeDelay = new TimeDelay(this);

    }

    public void spawn() {
        Random random = new Random();
        int randInt = random.nextInt(5); // variate for game performance
        if (randInt == 0) {
            int randTargetInt = random.nextInt(100);
            if (randTargetInt == 0) {
                targets.add(new Target(true));
            } // complete
            else {
                int planeOrTarget = random.nextInt(5);
                if (planeOrTarget != 0) {
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
        moveTargetsAndPlanes();
        uiEngine.updateUI(targets, radarPlanes, crossHair);
    }

    public static void main(String[] args) {
        Game game = new Game(new GraphicalUI(), new GraphicalControls());
        game.startGame();
    }

}
