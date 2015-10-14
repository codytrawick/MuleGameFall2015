package game.core;

import game.model.IModel;

/**
 * This interface represents any object that implements game logic.
 *
 * @author The SpecialFX
 * @version 1.0
 */
public abstract class GameLogic {
    protected Engine gameEngine;
    protected IModel gameModel;

    public GameLogic(IModel gameModel) {
        this.gameModel = gameModel;

    }

    public abstract void viewUpdated();

    public abstract void passButton();


    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

    public abstract void primeScreen();
}
