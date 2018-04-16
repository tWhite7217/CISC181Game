package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
This is a subclass of GameObjects, with methods that apply specifically to target objects, such as
their point values.
 */

public class Target extends GameObjects {

    boolean givesHeart;

    int pointValue;

    int size;

    int speed;

    public Target() {
        givesHeart = false;

        int size = 0;

        int speed = 0;
    }

    public void goesOffScreen() {}


}
