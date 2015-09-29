package game.core.Presenters;

import game.core.Engine;
import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.interfaces.IGameConfiguration;
import game.view.interfaces.IMainScreen;

/**
 * Created by Cody on 9/29/2015.
 */
public class MainScreenLogic extends GameLogic {

    IMainScreen mainView;

    public MainScreenLogic(IMainScreen mainView, IModel gameModel) {
        super(gameModel);
        this.mainView = mainView;

        this.mainView.setGameLogic(this);

    }

    public void setEngine(Engine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void passButton() {
        System.exit(0);
    }

    public void viewUpdated() {
        gameEngine.setCurrentGameLogic(Mule.GAME_CONFIGURATION);
    }

    public void primeScreen() {
        mainView.initializeScreen();
    }
}
