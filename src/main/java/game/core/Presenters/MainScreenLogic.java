package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.interfaces.IMainScreen;
import javafx.application.Platform;

/**
 * This class is a Presenter for the Main Screen
 * @author The SpecialFX
 */
public final class MainScreenLogic extends GameLogic {

    private IMainScreen mainView;

    public MainScreenLogic(IMainScreen newMainView, IModel model) {
        super(model);
        this.mainView = newMainView;

        this.mainView.setGameLogic(this);

    }

    public void passButton() {
        Platform.exit();
    }

    public void viewUpdated() {
        getGameEngine().setCurrentGameLogic(Mule.GAME_CONFIGURATION);
    }

    public void loadGame() {
        getGameEngine().loadGame();
        getGameEngine().setCurrentGameLogic(Mule.ROUNDSTART);
    }

    public void primeScreen() {
        mainView.initializeScreen();
    }
}
