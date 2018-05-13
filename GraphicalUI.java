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

    /*
    showIntro creates a new JFrame object and draws a simple introductory screen using an IntroJComponent
    Input: none
    Output: none
    Side effects: none
     */
    public void showIntro() {
        window = new JFrame();
        window.setFocusable(true);
        window.addKeyListener(new GameAdapter());
        window.setSize(600, 448);
        window.add(intro);
        window.setTitle("Game");
        window.setVisible(true);
    }

    /*
    updateUI uses an UpdateUIComponent to draw a graphical representation of the current state of the game
    Input: an ArrayList of Target object, an ArrayList of RadarPlane objects, and a CrossHairs object
    Output: none
    Side effects: none
     */
    public void updateUI(ArrayList<Target> targets, ArrayList<RadarPlane> radarPlanes, CrossHairs crossHairs) {
        window.remove(intro);
        window.remove(uiComponent);
        window.remove(gameOver);
        uiComponent = new updateUIComponent(targets, radarPlanes, crossHairs);
        window.add(uiComponent);
        window.setTitle("Score: " + game.getScore() + "   Health: " + game.getHealth());
        window.setVisible(true);
    }

    /*
    showScore uses a GameOverScreenComponent to display the player's score at the end of the game
    Input: int score
    Output: none
    Side effects: none
     */
    public void showScore(int score) {
        window.remove(uiComponent);
        window.add(gameOver);
        window.repaint();
        window.setVisible(true);
    }

    /*
    closeWindow disposes the JFrame object
    Input: none
    Output: none
    Side effects: none
     */
    public void closeWindow() {
        window.dispose();
    }

    /*
    GameAdapter is a private class extending KeyAdapter, allowing the game to accept keyboard input
    Input: none
    Output: none
    Side effects: none
     */
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
