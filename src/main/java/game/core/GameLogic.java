package game.core;

import game.model.IModel;
import game.view.GameScreen;
import game.view.interfaces.IGameConfiguration;

/**
 * This interface represents any object that implements game logic.
 *
 * @author The SpecialFX
 * @version 1.0
 */
public abstract class GameLogic {
    protected Engine gameEngine;
    protected GameScreen abstractView;
    protected IModel gameModel;

    public GameLogic(GameScreen configView, IModel gameModel) {
        this.abstractView = configView;
        this.gameModel = gameModel;

        configView.setGameLogic(this);
    }

    public abstract void viewUpdated();

    public abstract void passButton();

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }
}
