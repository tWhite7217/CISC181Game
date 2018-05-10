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

    public Target(int size, int yPos, boolean heartTarget) {
        givesHeart = heartTarget;

        this.size = size;

        if (heartTarget) {
            pointValue = 0;
        } else {
            pointValue = 3 - size;
        }
        position[0] = 599;

        position[1] = yPos;
    }


}
