package game.core;

import game.core.Engine;

/**
 * This interface allows a screen in our Game to have access to our engine
 */
public interface GameScreen {

    void setEngine(Engine parent);

    void initializeScreen();
}
