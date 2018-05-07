package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
This implements IControls, allowing the user to input controls in the console.
 */
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class ConsoleControls implements IControls {
    private Scanner input = new Scanner(System.in);

    public void setInput(String newInput) {};

    public String move() {
        System.out.println("move?: ");
        return input.nextLine();
    }

    public boolean fire() {
        System.out.println("fire?: ");
        String fireString = input.nextLine();
        return fireString.equals("f");
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
