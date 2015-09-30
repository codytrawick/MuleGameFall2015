package game.core;

import game.model.IModel;
import game.view.GameScreen;
import game.view.interfaces.IGameConfiguration;

/**
 * This controls the logic for a round
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class RoundLogic extends GameLogic {

    int roundNum;
    GameScreen view;

//    public RoundLogic(Engine gameEngine, int roundNum) {
//        this.gameEngine = gameEngine;
//        this.roundNum = roundNum;
//    }

    public RoundLogic(IGameConfiguration configView, IModel gameModel) {
        super(gameModel);
    }


    /**
     * This method will update the information in the view.
     * @param view The target view. Pre-condition: Must be the game map
     */
    public void updateView(GameScreen view) {

    }

    public void checkView(int row, int column) {

        if(row==2 && column==4) {
            gameEngine.setScreen(Mule.TOWN_SCREEN);
        }

    }

    public void setView(GameScreen view) {
        this.view = view;
    }

    public void viewUpdated() {

    }

    public void passButton() {

    }

    public void primeScreen() {

    }
}
