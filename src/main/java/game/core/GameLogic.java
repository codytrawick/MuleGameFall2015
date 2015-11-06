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

    public final void setEngine(Engine parent) {
        gameEngine = parent;
    }

    public final void updateModel(IModel newGameModel) {
        gameModel = newGameModel;
    }

    public final void setModel(IModel newModel) {
        gameModel = newModel;
    }

    protected final IModel getGameModel() {
        return gameModel;
    }

    protected final Engine getGameEngine() {
        return gameEngine;
    }

    public abstract void viewUpdated();

    public abstract void passButton();

    public abstract void primeScreen();
}
