package game.view;

import game.core.GameLogic;

/**
 * This interface allows a screen in our Game to have access to our engine.
 * In addition, GameScreens must be initialized prior to switching to the screen
 * @author The SpecialFX
 * @version 1.0
 */
public interface GameScreen {

//    /**
//     * This method sets the game scree's engine. All game screens will have
//     * a reference to the Engine presenter so that they can change screens
//     *
//     * @param parent The main game engine
//     */
////    void setEngine(Engine parent);

    void setGameLogic(GameLogic logic);

    /**
     * This method will handle the initialization before a screen is displayed.
     * Not all GameScreens will have useful code here, but those that need to
     * update their information can do so in here.
     */
    void initializeScreen();
}
