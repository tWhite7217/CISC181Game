package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
This class implements the IUIEngine, allowing the game to be displayed using Java graphics.
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GraphicalUI implements IUIEngine {

    JComponent intro;
    JComponent uiComponent;
    JComponent gameOver;
    private JFrame window;
    private Game game;

    public GraphicalUI() {
        intro = new IntroJComponent();
        uiComponent = new updateUIComponent(new ArrayList<Target>(), new ArrayList<RadarPlane>(), new CrossHairs());

    }

    public void setGame(Game game) {
        this.game = game;
        gameOver = new GameOverScreenComponent(game);

    }

    public void showIntro() {
        window = new JFrame();
        window.setFocusable(true);
        window.addKeyListener(new GameAdapter());
        window.setSize(600, 448);
        window.add(intro);
        window.setTitle("Game");
        window.setVisible(true);
    }

    public void updateUI(ArrayList<Target> targets, ArrayList<RadarPlane> radarPlanes, CrossHairs crossHairs) {
        window.remove(intro);
        window.remove(uiComponent);
        window.remove(gameOver);
        uiComponent = new updateUIComponent(targets, radarPlanes, crossHairs);
        window.add(uiComponent);
        window.setTitle("Score: " + game.getScore() + "   Health: " + game.getHealth());
        window.setVisible(true);
    }

    public void showScore(int score) {
        window.remove(uiComponent);
        window.add(gameOver);
        window.repaint();
        window.setVisible(true);
    }

    public void closeWindow() {
        window.dispose();
    }


    private class GameAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                game.getControls().setInput("a");
            }

            if (key == KeyEvent.VK_RIGHT) {
                game.getControls().setInput("d");
            }

            if (key == KeyEvent.VK_UP) {
                game.getControls().setInput("w");
            }

            if (key == KeyEvent.VK_DOWN) {
                game.getControls().setInput("s");
            }
            if (key == KeyEvent.VK_SPACE) {
                game.getControls().setInput("f");
            }
            if (key == KeyEvent.VK_ESCAPE) {
                game.getControls().setInput("q");
            }
            if (key == KeyEvent.VK_R) {
                game.getControls().setInput("r");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                game.getControls().setInput("");
            }
            if (key == KeyEvent.VK_RIGHT) {
                game.getControls().setInput("");
            }
            if (key == KeyEvent.VK_ESCAPE) {
                game.getControls().setInput("");
            }
            if (key == KeyEvent.VK_R) {
                game.getControls().setInput("");
            }
        }
    }
}
