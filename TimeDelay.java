package g.cisc181.game;

/**
 * Created by tombo on 5/1/2018.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimeDelay extends JPanel implements ActionListener {

    private Timer timer;
    private Game game;
    private final int DELAY = 50;
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
            }
            else {
                count = 0;
            }
        }
        else {
            game.getUiEngine().showScore(game.getScore());
            System.exit(0);
        }
    }

}
