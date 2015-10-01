package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.interfaces.ITownScreen;

/**
 * Created by Cody on 9/29/2015.
 */
public class TownLogic extends GameLogic {

    ITownScreen townView;

    public TownLogic(ITownScreen townView, IModel model) {
        super(model);
        this.townView = townView;

        this.townView.setGameLogic(this);
    }

    public void passButton() {
        gameEngine.setCurrentGameLogic(Mule.MAP2SCREEN);
    }

    public void primeScreen() {
        gameEngine.setCurrentGameLogic(Mule.MAP2SCREEN);
    }

    public void viewUpdated() {
        if (townView.getTargetLocation() == "Pub") {
            int roundNumber = gameModel.getCurrentRound();
            int roundBonus = (15 * roundNumber + 50);
            if (roundBonus > 200) {
                roundBonus = 200;
            }

            int timeBonus = 0; //TODO

            int totalBonus = roundBonus + timeBonus;
            gameModel.giveMoney(totalBonus);
            gameEngine.setCurrentGameLogic(Mule.ROUNDSTART);

        }
        System.out.printf("%s", townView.getTargetLocation());
    }
}
