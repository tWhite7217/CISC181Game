package g.cisc181.game;

/*
Ryan Petery and Tommy White
4/15/18
An interface that provides methods for the game to create an user interface. This interface will
allow the Game class to work separately from UI implementation, making it easier to run the game on
different types of displays.
*/

interface IUIEngine {
    void showIntro();
    void updateUI();
    void showScore();
}
