package g.cisc181.game;

/*
Ryan Petery and Tommy White
5/14/18
This class extends JComponent and draws a Game Over Screen
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

    /*
    paintComponent draws a Game Over screen
    Input: Graphics g
    Output: none
    Side effects: none
     */
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
