package g.cisc181.game;

/**
 * Created by tombo on 5/1/2018.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class TimeDelay extends JPanel implements ActionListener {

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
        } else if (game.getControls().getInput() == "q") {
            System.exit(0);
        } else if (game.getControls().getInput() == "r") {
            timer.stop();
            game.getUiEngine().closeWindow();
            game.startGame();
        } else {
            game.getUiEngine().showScore(game.getScore());
        }
    }

}
