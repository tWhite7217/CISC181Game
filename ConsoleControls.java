package e.ryanpetery.java;

/*
Ryan Petery and Tommy White
4/15/18
This implements IControls, allowing the user to input controls in the console.
 */
import java.util.Scanner;

public class ConsoleControls implements IControls {
    private Scanner input = new Scanner(System.in);

    public String move() {
        return input.nextLine();
    }

    public boolean fire() {
        if (input.nextLine().equals("f")) {
            return true;
        } else { return false; }
    }
}
