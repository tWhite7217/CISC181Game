package e.ryanpetery.java;

/*
Ryan Petery and Tommy White
4/15/18
This implements IControls, allowing the user to input controls in the console.
 */
import java.util.Scanner;

public class ConsoleControls implements IControls {
    Scanner input = new Scanner(System.in);

    public boolean moveLeft() {
        return (input.next().equals("a"));
    }

    public boolean moveRight() {
        return (input.next().equals("d"));
    }

    public boolean moveUp() {
        return (input.next().equals("w"));
    }

    public boolean moveDown() {
        return (input.next().equals("s"));
    }

    public boolean fire() {
        return (input.next().equals("f"));
    }
}
