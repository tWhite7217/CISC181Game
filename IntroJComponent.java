package g.cisc181.game;

/*
Ryan Petery and Tommy White
5/11/18
This class extends JComponent and draws an introductory screen.
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

public class IntroJComponent extends JComponent {

    /*
    paintComponent draws an introductory screen
    Input: Graphics g
    Output: none
    Side effects: none
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(-100, 0, 800, 400);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
        g.drawString("Get Ready!", 50, 200);
    }
}
