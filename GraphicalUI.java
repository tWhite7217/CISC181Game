package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
This class implements the IUIEngine, allowing the game to be displayed using Java graphics.
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Graphics;

public class GraphicalUI implements IUIEngine {

    private JFrame window;
    private Game game;
    JComponent intro = new IntroJComponent();
    JComponent uiComponent = new updateUIComponent(new ArrayList<Target>(), new ArrayList<RadarPlane>(), new CrossHairs());

    public void setGame(Game game) {
        this.game = game;
    }


    public void showIntro() {
        window = new JFrame();
        window.setFocusable(true);
        window.addKeyListener(new GameAdapter());
        window.setSize(600, 448);
        window.setTitle("Window");
        window.add(intro);

        window.setVisible(true);
    }



    public void updateUI(ArrayList<Target> targets, ArrayList<RadarPlane> radarPlanes, CrossHairs crossHairs) {
        window.remove(uiComponent);
        uiComponent = new updateUIComponent(targets, radarPlanes, crossHairs);
        window.remove(intro);
        window.add(uiComponent);
        window.setVisible(true);

    }
    public void showScore(int score) {
        System.out.println("Game Over");
        System.out.println("Score: " + score);
    }


    private class GameAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            game.getControls().keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            game.getControls().keyPressed(e);
        }
    }
}
