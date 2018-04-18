package e.ryanpetery.java;

/*
Ryan Petery and Tommy White
4/15/18
This interface allows the Game class to work separately from control implementation. By providing
generic control methods, the game logic can run without considering how input will occur.
 */

public interface IControls {
    boolean moveLeft();

    boolean moveRight();

    boolean moveUp();

    boolean moveDown();

    boolean fire();
}
