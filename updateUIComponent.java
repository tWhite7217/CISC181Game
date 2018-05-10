package g.cisc181.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * Created by tombo on 5/1/2018.
 */

public class updateUIComponent extends JComponent {

    ArrayList<Target> targets;
    ArrayList<RadarPlane> radarPlanes;
    CrossHairs crossHairs;

    public updateUIComponent(ArrayList<Target> targets, ArrayList<RadarPlane> radarPlanes, CrossHairs crossHairs) {
        this.targets = targets;
        this.radarPlanes = radarPlanes;
        this.crossHairs = crossHairs;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(-100, 0, 800, 400);
        g.setColor(Color.MAGENTA);
        g.drawLine(0, 100, 600, 100);
        g.drawLine(0, 200, 600, 200);
        g.drawLine(0, 300, 600, 300);

        g.setColor(Color.RED);
        for (int i = 0; i < targets.size(); i++) {
            int xpos = targets.get(i).position[0];
            int ypos = (4 - targets.get(i).position[1]) * 100;
            int size = 25 + 25 * targets.get(i).size;
            g.fillOval(xpos - size / 2, ypos - size / 2, size, size);
            if (targets.get(i).givesHeart) {
                g.setColor(Color.PINK);
                g.fillOval(xpos - size / 2, ypos - size / 2, size, size);
                g.setColor(Color.RED);
            }
        }
        for (int i = 0; i < radarPlanes.size(); i++) {
            int xpos = radarPlanes.get(i).position[0];
            int ypos = (4 - radarPlanes.get(i).position[1]) * 100;
            if (radarPlanes.get(i).hasDetected) {
                g.setColor(Color.GRAY);
                g.fillOval(xpos - 25, ypos - 25, 50, 50);
            } else {
                g.setColor(Color.GREEN);
                g.fillOval(xpos - 25, ypos - 25, 50, 50);
            }

        }
        g.setColor(Color.WHITE);
        int crossPosy = (4 - crossHairs.position[1]) * 100;
        int crossPosx = crossHairs.position[0];
        g.drawLine(crossPosx, crossPosy - 25, crossPosx, crossPosy + 25);
        g.drawLine(crossPosx - 25, crossPosy, crossPosx + 25, crossPosy);
        g.drawOval(crossPosx - 25, crossPosy - 25, 50, 50);
    }
}