package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
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
        gameModel.startTurn(gameModel.currentPlayerTime());
        gameEngine.setCurrentGameLogic(Mule.MAP2SCREEN);
    }

    public void passButton() {

    }

    public void primeScreen() {
        if (roundNum == 0) {
            gameModel.createRound(1);
            roundNum = 1;
        } else if (turnNumber == gameModel.getPlayerNumber()) {
            gameModel.resolveRound();
            if (roundNum < 12) {
                gameModel.createRound(++roundNum);
            }
            turnNumber = 0;
        } else {
            gameModel.nextPlayer();
        }
        view.setRoundText(String.format("Round #%d", gameModel.getCurrentRound()));
        view.setPlayerName(String.format("%s's Turn", gameModel.currentPlayer()));
        view.setRandomEventText(gameModel.performRandomEvent());
        turnNumber++;

    }

    public void saveGame() {
        //Put saving method in here!
        //Seriously, put it in here.
        //TODO: Put things in here. Do it. Now.
        gameEngine.saveGame();
    }

}
