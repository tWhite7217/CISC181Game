package g.cisc181.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * Created by tombo on 5/1/2018.
 */

public class IntroJComponent extends JComponent {
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(-100, 0, 800, 400);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
        g.drawString("Get Ready!", 50, 200);
    }
}
