package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.interfaces.IPlayerConfiguration;

/**
 * This class is the presenter for the Player Creation Screen
 * @author The SpecialFX
 */
public class PlayerCreationLogic extends GameLogic {
    private IPlayerConfiguration playerView;
    private int currentPlayerNum = 0;

    public PlayerCreationLogic(IPlayerConfiguration playerView, IModel game) {
        super(game);
        this.playerView = playerView;

        this.playerView.setGameLogic(this);
    }

    public void passButton() {
        gameEngine.setCurrentGameLogic(Mule.WELCOME_PAGE);
    }

    public void viewUpdated() {
        gameModel.createNewPlayer(playerView.getPlayerName(), playerView.getPlayerColor(), playerView.getPlayerRace());
        if (++currentPlayerNum == gameModel.getPlayerNumber()) {
            gameEngine.setCurrentGameLogic(Mule.LAND_SELECTION);
        }
    }

    public void primeScreen() {
        playerView.initializeScreen();
    }
}
