package g.cisc181.game;

/**
 * Created by tombo on 5/1/2018.
 */

public class GraphicalControls implements IControls {

    String input = "";

    public String getInput() {
        return input;
    }

    public void setInput(String newInput) {
        input = newInput;
    }

    public String move() {
        return input;
    }

    public boolean fire() {
        return input.equals("f");
    }
}
