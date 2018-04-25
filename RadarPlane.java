package e.ryanpetery.java;

/*
Ryan Petery and Tommy White
4/15/18
This is a subclass of GameObjects, with methods that apply specifically to radar plane objects.
 */

import java.util.Random;

public class RadarPlane extends GameObjects {

    boolean hasDetected;

    public RadarPlane() {
        size = 1;

        hasDetected = false;

        Random random = new Random();

        int randYPos = random.nextInt(3)+1;

        position[0] = 599;
        position[1] = randYPos;

    }


}
