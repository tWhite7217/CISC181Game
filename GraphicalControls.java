package g.cisc181.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

/**
 * Created by tombo on 5/1/2018.
 */

public class GraphicalControls implements IControls {

    String input = "";

    public void setInput(String newInput) {
        input = newInput;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            input = "a";
        }

        if (key == KeyEvent.VK_RIGHT) {
            input = "d";
        }

        if (key == KeyEvent.VK_UP) {
            input = "w";
        }

        if (key == KeyEvent.VK_DOWN) {
            input = "s";
        }
        if (key == KeyEvent.VK_SPACE) {
            input = "f";
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            input = "";
        }

        if (key == KeyEvent.VK_RIGHT) {
            input = "";
        }

        if (key == KeyEvent.VK_UP) {
            input = "";
        }

        if (key == KeyEvent.VK_DOWN) {
            input = "";
        }
    }

    public String move() {
        return input;
    }

    public boolean fire() {
        return input.equals("f");
    }
}
