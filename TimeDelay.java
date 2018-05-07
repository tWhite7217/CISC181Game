package g.cisc181.game;

/**
 * Created by tombo on 5/1/2018.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
/*import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;*/
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimeDelay extends JPanel implements ActionListener {

    private Timer timer;
    private Game game;
    private final int DELAY = 50;

    public TimeDelay(Game game) {
        this.game = game;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (game.getHealth() > 0) {
            game.tick();
        }
        else {
            game.getUiEngine().showScore(game.getScore());
            System.exit(0);
        }
    }

}
