package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
This class implement IUIEngine, allowing the game to be displayed in the console.
 */
import java.util.ArrayList;

public class ConsoleGraphics implements IUIEngine {
    public void showIntro() {
        System.out.println("game started");
        System.out.println("");
    }
    public void updateUI(ArrayList<Target> targets, ArrayList<RadarPlane> radarPlanes, CrossHairs crossHairs) {
        String[][] gameWorld = new String[3][60];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 60; j++) {
                gameWorld[i][j] = "-";
            }
        }
        for(int i = 0; i < targets.size(); i++) {
            int xpos = targets.get(i).position[0] / 10;
            int ypos = targets.get(i).position[1] - 1;
            gameWorld[ypos][xpos] = "*";
        }
        for(int i = 0; i < radarPlanes.size(); i++) {
            int xpos = radarPlanes.get(i).position[0] / 10;
            int ypos = radarPlanes.get(i).position[1] - 1;
            if (radarPlanes.get(i).hasDetected) {
                gameWorld[ypos][xpos] = "#";
            } else {
                gameWorld[ypos][xpos] = "@";
            }

        }
        int crossPosy = crossHairs.position[1] - 1;
        int crossPosx = crossHairs.position[0] / 10;
        gameWorld[crossPosy][crossPosx] = "+";

        for(int i = gameWorld.length-1; i >= 0; i--) {
            for (String column : gameWorld[i]) {
                System.out.print(column);
            }
            System.out.println("");
        }
    }
    public void showScore(int score) {
        System.out.println("");
        System.out.println("your score is: " + score);
    }
}
