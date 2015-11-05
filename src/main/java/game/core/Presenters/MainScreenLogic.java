package game.core.Presenters;

import game.core.Engine;
import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.interfaces.IMainScreen;
import javafx.application.Platform;

/**
 * This class is a Presenter for the Main Screen
 * @author The SpecialFX
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
        Platform.exit();
    }

    public void viewUpdated() {
        gameEngine.setCurrentGameLogic(Mule.GAME_CONFIGURATION);
    }

    public void loadGame() {
        //TODO: Add loadGame method functionality
        gameEngine.loadGame();
        gameEngine.setCurrentGameLogic(Mule.ROUNDSTART);
    }

    public void primeScreen() {
        mainView.initializeScreen();
    }
}
