package e.ryanpetery.java;

/*
Ryan Petery and Tommy White
4/15/18
This is a subclass of GameObjects, with methods that apply specifically to target objects, such as
their point values.
 */

import java.util.Random;

import javax.swing.plaf.basic.BasicBorders;

public class Target extends GameObjects {

    boolean givesHeart;

    int pointValue;

    int size;


    public Target() {
        givesHeart = false;

        Random random = new Random();

        int randSize = random.nextInt(3);

        int randYPos = random.nextInt(3);

        int size = randSize;

        pointValue = 4-size;

        position[0] = 599;
        position[1] = randYPos;
    }

    public Target(boolean heartTarget) {
        givesHeart = heartTarget;

        int size = 0;

        pointValue = 0;

        Random random = new Random();

        int randYPos = random.nextInt(3);

        position[0] = 599;
        position[1] = randYPos;
    }


}
