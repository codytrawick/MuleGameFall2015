package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.GameScreen;
import game.view.interfaces.IGameConfiguration;
import game.view.interfaces.ITurnStart;

/**
 * This controls the logic for a round
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class RoundLogic extends GameLogic {

    private int roundNum;
    private int turnNumber;
    private ITurnStart view;

//    public RoundLogic(Engine gameEngine, int roundNum) {
//        this.gameEngine = gameEngine;
//        this.roundNum = roundNum;
//    }

    public RoundLogic(ITurnStart configView, IModel gameModel) {
        super(gameModel);
        this.view = configView;

        this.view.setGameLogic(this);
    }

    public void viewUpdated() {
        gameEngine.startMapTimer(gameModel.currentPlayerTime());
        gameEngine.setCurrentGameLogic(Mule.MAP2SCREEN);
    }

    public void passButton() {

    }

    public void primeScreen() {
        if (roundNum == 0) {
            gameModel.createRound(1);
        }
        view.setPlayerName(String.format("%s's Turn", gameModel.currentPlayer()));
    }
}
