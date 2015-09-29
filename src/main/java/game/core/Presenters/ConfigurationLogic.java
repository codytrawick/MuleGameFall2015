package game.core.Presenters;

import game.core.Engine;
import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.controllers.GameConfigurationController;
import game.view.interfaces.IGameConfiguration;

/**
 * Created by Cody on 9/29/2015.
 */
public class ConfigurationLogic extends GameLogic {

    private IGameConfiguration configView;

    public ConfigurationLogic(IGameConfiguration configView, IModel gameModel) {
        super(configView, gameModel);
        configView = (IGameConfiguration) abstractView;
    }

    public void viewUpdated() {
        gameModel.setPlayerNumber(configView.getPlayerNumber());
        gameModel.setDifficulty(configView.getDifficulty());
        gameModel.setMapType(configView.getMapType());
        System.out.println("View Updated");

    }

    public void passButton() {
        gameEngine.setScreen(Mule.WELCOME_PAGE);
    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }


}
