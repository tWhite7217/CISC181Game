package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
This is a subclass of GameObjects, with methods that apply specifically to radar plane objects.
 */

import java.util.Random;

public class RadarPlane extends GameObjects {

    boolean hasDetected;

    public RadarPlane(int size, int yPos) {
        this.size = size;

        position[0] = 599;
        position[1] = yPos;

    }


}
