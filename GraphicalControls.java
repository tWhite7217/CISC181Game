package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
Graphical controls implements IControls, acting as the controls class when the game is played using
Java's Swing graphics.
 */

public class GraphicalControls implements IControls {

    String input = "";

    public String getInput() {
        return input;
    }

    public void setInput(String newInput) {
        input = newInput;
    }

    /*
    move returns a String that will be read by Game to determine how the crossHairs should move
    Input: none
    Output: A String specifying a direction
    Side effects: changes the position of the crossHairs object (indirectly)
     */
    public String move() {
        return input;
    }

    /*
    fire returns a boolean that will be read by Game to determine if the player has fired
    Input: none
    Output: A boolean specifying whether the player fired
    Side effects: May remove a target from the targets ArrayList in Game
     */
    public boolean fire() {
        return input.equals("f");
    }
}
