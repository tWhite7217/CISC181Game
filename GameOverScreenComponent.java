package g.cisc181.game;

/**
 * Created by tombo on 5/8/2018.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

public class GameOverScreenComponent extends JComponent {
    private Game game;

    public GameOverScreenComponent(Game game) {
        this.game = game;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(-100, 0, 800, 400);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Game Over", 50, 100);
        g.drawString("Score: " + game.getScore(), 350, 100);
        g.drawString("Press Esc to quit or R to play again.", 50, 300);
    }
}
