package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
This class contains the logic for the game and is the main class that starts a new game.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Random random = new Random();
    private int score;
    private int health;
    private IUIEngine uiEngine;
    private IControls controls;
    private ArrayList<Target> targets;
    private ArrayList<RadarPlane> radarPlanes;
    private CrossHairs crossHair;

    public Game(IUIEngine engine, IControls contr) {
        uiEngine = engine;
        controls = contr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter anything to play the game normally or enter 2 to play in the console (not recommended).");
        String answer = scan.nextLine();
        if (answer.equals("2")) {
            Game game = new Game(new ConsoleGraphics(), new ConsoleControls());
            game.startGame();
        } else {
            Game game = new Game(new GraphicalUI(), new GraphicalControls());
            game.startGame();
        }
    }

    public int getHealth() {
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
        if (moveString.equals("w")) {
            controls.setInput("");
            if (crossHair.position[1] != 3) {
                crossHair.position[1] += 1;
            }
        }
        if (moveString.equals("s")) {
            controls.setInput("");
            if (crossHair.position[1] != 1) {
                crossHair.position[1] -= 1;
            }
        }
        if (moveString.equals("a")) {
            if (crossHair.position[0] > 99) {
                crossHair.position[0] -= 15;
            }
        }
        if (moveString.equals("d")) {
            if (crossHair.position[0] < 499) {
                crossHair.position[0] += 15;
            }
        }
    }

    public void moveTargetsAndPlanes() { //temporary move values
        for (int i = 0; i < targets.size(); i++) {
            targets.get(i).position[0] -= 10;
            if (targets.get(i).position[0] < 0) {
                targets.remove(i);
                i--;
            }
        }
        for (int i1 = 0; i1 < radarPlanes.size(); i1++) {
            radarPlanes.get(i1).position[0] -= 10;
            if (radarPlanes.get(i1).position[0] < 0) {
                radarPlanes.remove(i1);
                i1--;
            }
        }
    }

    public void isHit() {
        if (controls.fire()) {
            controls.setInput("");
            for (int i = 0; i < targets.size(); i++) {
                if (Math.abs(targets.get(i).position[0] - crossHair.position[0]) <= ((25 + (25 * (targets.get(i).size))) / 2) && targets.get(i).position[1] == crossHair.position[1]) {
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
        for (int i = 0; i < radarPlanes.size(); i++) {
            if ((Math.abs(radarPlanes.get(i).position[0] - crossHair.position[0]) <= 25) && radarPlanes.get(i).position[1] == crossHair.position[1] && !(radarPlanes.get(i).hasDetected)) {
                health--;
                radarPlanes.get(i).hasDetected = true;
            }
        }
    }

    public void startGame() {
        score = 0;
        health = 3;
        targets = new ArrayList<>();
        radarPlanes = new ArrayList<>();
        crossHair = new CrossHairs();
        uiEngine.setGame(this);
        uiEngine.showIntro();
        new TimeDelay(this);
    }

    public void spawn(int type) {
        int randTargetInt = random.nextInt(100);
        if (type <= 2) {
            if (randTargetInt == 0) {
                targets.add(new Target(0, type + 1, true));
            } else {
                int planeOrTarget = random.nextInt(2);
                if (planeOrTarget == 0) {
                    targets.add(new Target(random.nextInt(3), type + 1, false));
                } else {
                    radarPlanes.add(new RadarPlane(1, type + 1));
                }
            }
        } else if (type == 3) {
            spawnType3(randTargetInt);
        } else if (type == 4) {
            spawnType4(randTargetInt);
        } else if (type == 5) {
            spawnType5(randTargetInt);
        } else if (type == 6) {
            spawnType6(randTargetInt);
        }

    }

    public void spawnType3(int randTargetInt) {
        if (randTargetInt == 0) {
            targets.add(new Target(0, 1, true));
            radarPlanes.add(new RadarPlane(1, 2));
        } else {
            int planeOrTarget = random.nextInt(3);
            if (planeOrTarget == 0) {
                targets.add(new Target(random.nextInt(3), 1, false));
                radarPlanes.add(new RadarPlane(1, 2));
            } else if (planeOrTarget == 1) {

                targets.add(new Target(random.nextInt(3), 2, false));
                radarPlanes.add(new RadarPlane(1, 1));
            } else {
                radarPlanes.add(new RadarPlane(1, 1));
                radarPlanes.add(new RadarPlane(1, 2));
            }
        }
    }

    public void spawnType4(int randTargetInt) {
        if (randTargetInt == 0) {
            targets.add(new Target(0, 3, true));
            radarPlanes.add(new RadarPlane(1, 2));
        } else {
            int planeOrTarget = random.nextInt(3);
            if (planeOrTarget == 0) {
                targets.add(new Target(random.nextInt(3), 3, false));
                radarPlanes.add(new RadarPlane(1, 2));
            } else if (planeOrTarget == 1) {

                targets.add(new Target(random.nextInt(3), 2, false));
                radarPlanes.add(new RadarPlane(1, 3));
            } else {
                radarPlanes.add(new RadarPlane(1, 3));
                radarPlanes.add(new RadarPlane(1, 2));
            }
        }
    }

    public void spawnType5(int randTargetInt) {
        if (randTargetInt == 0) {
            int topOrBottom = random.nextInt(2);
            if (topOrBottom == 0) {
                targets.add(new Target(0, 1, true));
                radarPlanes.add(new RadarPlane(1, 3));
            } else {
                targets.add(new Target(0, 3, true));
                radarPlanes.add(new RadarPlane(1, 1));
            }
        } else {
            int planeOrTarget = random.nextInt(3);
            if (planeOrTarget == 0) {
                targets.add(new Target(random.nextInt(3), 1, false));
                radarPlanes.add(new RadarPlane(1, 3));
            } else if (planeOrTarget == 1) {

                targets.add(new Target(random.nextInt(3), 3, false));
                radarPlanes.add(new RadarPlane(1, 1));
            } else {
                radarPlanes.add(new RadarPlane(1, 1));
                radarPlanes.add(new RadarPlane(1, 3));
            }
        }
    }

    public void spawnType6(int randTargetInt) {
        if (randTargetInt == 0) {
            targets.add(new Target(0, 2, true));
            radarPlanes.add(new RadarPlane(1, 1));
            radarPlanes.add(new RadarPlane(1, 3));
        } else {
            int planeOrTarget = random.nextInt(3);
            if (planeOrTarget == 0) {
                targets.add(new Target(random.nextInt(3), 2, false));
                radarPlanes.add(new RadarPlane(1, 1));
                radarPlanes.add(new RadarPlane(1, 3));
            } else if (planeOrTarget == 1) {
                targets.add(new Target(random.nextInt(3), 3, false));
                radarPlanes.add(new RadarPlane(1, 1));
                radarPlanes.add(new RadarPlane(1, 2));
            } else {
                targets.add(new Target(random.nextInt(3), 1, false));
                radarPlanes.add(new RadarPlane(1, 2));
                radarPlanes.add(new RadarPlane(1, 3));
            }
        }
    }

    public void tick(int count) {
        if (count % 12 == 0) {
            spawn(random.nextInt(7));
        }
        isHit();
        isDetected();
        uiEngine.updateUI(targets, radarPlanes, crossHair);
        move();
        moveTargetsAndPlanes();
        uiEngine.updateUI(targets, radarPlanes, crossHair);
    }

}
