package g.cisc181.game;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by tombo on 5/1/2018.
 */

public class IntroJComponent extends JComponent {
    public void paintComponent (Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(-100,0, 800, 400);
        g.setColor(Color.BLACK);
        g.drawLine(0,100,600,100);
        g.drawLine(0,200,600,200);
        g.drawLine(0,300,600,300);
    }
}
