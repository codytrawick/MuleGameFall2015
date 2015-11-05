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
public final class RoundLogic extends GameLogic {

    private ITurnStart view;

//    public RoundLogic(Engine gameEngine, int roundNum) {
//        this.gameEngine = gameEngine;
//        this.roundNum = roundNum;
//    }

    public RoundLogic(ITurnStart configView, IModel model) {
        super(model);
        this.view = configView;

        this.view.setGameLogic(this);
    }

    public void viewUpdated() {
        getGameEngine().startMapTimer(getGameModel().currentPlayerTime());
        getGameModel().startTurn(getGameModel().currentPlayerTime());
        getGameEngine().setCurrentGameLogic(Mule.MAP2SCREEN);
    }

    public void passButton() {

    }

    public void primeScreen() {
        view.setSaveButton(getGameModel().getCurrentPlayerNumber() != 0);

        view.setRoundText(String.format("Round #%d", getGameModel().getCurrentRound()));
        view.setPlayerName(String.format("%s's Turn", getGameModel().currentPlayer()));
        view.setRandomEventText(getGameModel().performRandomEvent());


    }

    public void saveGame() {
        getGameEngine().saveGame();
    }

}
