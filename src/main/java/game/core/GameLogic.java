package game.core;

import game.model.IModel;

/**
 * This interface represents any object that implements game logic.
 *
 * @author The SpecialFX
 * @version 1.0
 */
public abstract class GameLogic {
    private Engine gameEngine;
    private IModel gameModel;

    public GameLogic(IModel newGameModel) {
        this.gameModel = newGameModel;

    }

    public abstract void viewUpdated();

    public abstract void passButton();

    protected Engine getGameEngine() {
        return gameEngine;
    }

    protected IModel getGameModel() {
        return gameModel;
    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

    public void updateModel(IModel newGameModel) {
        gameModel = newGameModel;
    }

    public abstract void primeScreen();

    public void setModel(IModel newModel) {
        gameModel = newModel;
    }
}
