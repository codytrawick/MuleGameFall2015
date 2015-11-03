package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.interfaces.ITurnStart;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    @FXML
    private Button saveButton;

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
//        if (gameModel.getCurrentRound() == 0) {
//            gameModel.createRound(1);
//            roundNum++;
//        } else if (gameModel.getCurrentPlayerNumber() + 1 == gameModel.getPlayerNumber()) {
//            gameModel.resolveRound();
//            if (gameModel.getCurrentRound() < 12) {
//                gameModel.createRound(++roundNum);
//            }
//        } else {
//            gameModel.nextPlayer();
//        }
        view.setSaveButton(gameModel.getCurrentPlayerNumber() != 0);

        view.setRoundText(String.format("Round #%d", gameModel.getCurrentRound()));
        view.setPlayerName(String.format("%s's Turn", gameModel.currentPlayer()));
        view.setRandomEventText(gameModel.performRandomEvent());


    }

    public void saveGame() {
        gameEngine.saveGame();
    }

}
