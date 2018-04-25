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

    Random random = new Random();


    public Target() {
        givesHeart = false;

        int randYPos = random.nextInt(3)+1;

        size = random.nextInt(3);

        pointValue = 3-size;

        position[0] = 599;
        position[1] = randYPos;
    }

    public Target(boolean heartTarget) {
        givesHeart = heartTarget;

        int size = 0;

        pointValue = 0;

        int randYPos = random.nextInt(3)+1;

        position[0] = 599;

        position[1] = randYPos;
    }


}
