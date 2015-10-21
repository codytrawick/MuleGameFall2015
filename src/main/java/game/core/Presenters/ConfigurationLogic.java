package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.interfaces.IGameConfiguration;

/**
 * @author The SpecialFX
 */
public class ConfigurationLogic extends GameLogic {

    private IGameConfiguration configView;

    public ConfigurationLogic(IGameConfiguration iGameConfiguration, IModel gameModel) {
        super(gameModel);
        this.configView = iGameConfiguration;

        this.configView.setGameLogic(this);
    }

    public void viewUpdated() {
        gameModel.setPlayerNumber(configView.getPlayerNumber());
        gameModel.setDifficulty(configView.getDifficulty());
        gameModel.setMapType(configView.getMapType());
        gameEngine.setCurrentGameLogic(Mule.PLAYER_CREATION_PAGE);

    }

    public void passButton() {
        gameEngine.setScreen(Mule.WELCOME_PAGE);
    }

    public void primeScreen() {
        configView.initializeScreen();
    }

}
