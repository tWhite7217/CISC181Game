package e.ryanpetery.java;

/*
Ryan Petery and Tommy White
4/15/18
An interface that provides methods for the game to create an user interface. This interface will
allow the Game class to work separately from UI implementation, making it easier to run the game on
different types of displays.
*/
import java.lang.reflect.Array;
import java.util.ArrayList;

interface IUIEngine {
    void showIntro();
    void updateUI(ArrayList<Target> targets, ArrayList<RadarPlane> radarPlanes, CrossHairs crossHairs);
    void showScore(int score);
}
