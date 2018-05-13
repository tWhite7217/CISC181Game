package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
This implements IControls, allowing the user to input controls in the console.
 */

import java.util.Scanner;

public class ConsoleControls implements IControls {
    private Scanner scan = new Scanner(System.in);
    private String input;

    /*
    getInput uses a Scanner object to return a String that will determine if the game should end or be restarted
    Input: String (Scanner input)
    Output: A String specifying a command
    Side effects: none
     */
    public String getInput() {
        System.out.println("Enter q to quit or enter r to play again.");
        return scan.nextLine();
    }

    /*
    setInput is a simple setter method that can change the private field input in this class
    Input: String
    Output: none
    Side effects: changes the value of the private field input
     */
    public void setInput(String newInput) {
        input = newInput;
    }

    /*
    move uses a Scanner object to return a String that will be read by Game to determine how the
    crossHairs should move
    Input: String (Scanner input)
    Output: A String specifying a direction
    Side effects: changes the position of the crossHairs object (indirectly)
     */
    public String move() {
        System.out.println("move?: ");
        input = scan.nextLine();
        return input;
    }

    /*
    fire uses a Scanner to return a boolean that will be read by Game to determine if the player has
    fired
    Input: String (Scanner input)
    Output: A boolean specifying whether the player fired
    Side effects: May remove a target from the targets ArrayList in Game
     */
    public boolean fire() {
        System.out.println("fire?: ");
        input = scan.nextLine();
        return input.equals("f");
    }
}
