package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
This interface allows the Game class to work separately from control implementation. By providing
generic control methods, the game logic can run without considering how input will occur.
 */

import java.awt.event.KeyEvent;

public interface IControls {

    void setInput(String newInput);

    String move();

    boolean fire();

    void keyPressed(KeyEvent e);

    void keyReleased(KeyEvent e);
}
