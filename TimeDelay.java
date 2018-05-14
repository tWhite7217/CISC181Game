package g.cisc181.game;

/*
Ryan Petery and Tommy White
5/14/18
This class implements ActionListener. The class allows the game to wait a certain amount of time
before updating.
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimeDelay implements ActionListener {

    private final int DELAY = 50;
    private Timer timer;
    private Game game;
    private int count;

    public TimeDelay(Game game) {
        this.game = game;
        timer = new Timer(DELAY, this);
        timer.start();
        count = 0;
    }

    /*
    actionPerformed specifies what should happen after the amount of time specified by the Timer
    object's delay has passed. If the player still has health, the game continues. Otherwise,
    actionPerformed will check if the player wishes to quit the game or play again.
    Input: an ActionEvent e
    Output: none
    Side effects: none
     */
    public void actionPerformed(ActionEvent e) {
        if (game.getHealth() > 0) {
            game.tick(count);
            if (count < 11) {
                count++;
            } else {
                count = 0;
            }
            if (timer.getDelay() > 20) {
                timer.setDelay(50 - game.getScore() / 5);
            }
        } else {
            if (game.getControls().getInput().equals("q")) {
                System.exit(0);
            } else if (game.getControls().getInput().equals("r")) {
                timer.stop();
                game.getUiEngine().closeWindow();
                game.startGame();
            } else {
                game.getUiEngine().showScore(game.getScore());
            }
        }
    }
}