package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.interfaces.ITownScreen;
import javafx.beans.property.IntegerProperty;

import java.util.Random;

/**
 * This class is the Presenter for the Town screen
 * @author The SpeicalFX
 */
public class TownLogic extends GameLogic {

    private ITownScreen townView;

    public TownLogic(ITownScreen townView, IModel model) {
        super(model);
        this.townView = townView;

        this.townView.setGameLogic(this);
    }

    public void passButton() {
        getGameEngine().setCurrentGameLogic(Mule.MAP2SCREEN);
    }

    public void primeScreen() {
        getGameEngine().setCurrentGameLogic(Mule.MAP2SCREEN);
    }

    public void viewUpdated() {
        if (townView.getTargetLocation().equals("Pub")) {
            int roundNumber = getGameModel().getCurrentRound();
            int roundBonus = (15 * roundNumber + 50);
            if (roundBonus > 200) {
                roundBonus = 200;
            }

            Random rand = new Random();
            int timeBonus = rand.nextInt(getGameEngine().turnTimeLeft() + 1);

            int totalBonus = roundBonus + timeBonus;
            getGameModel().giveMoney(totalBonus);
            getGameModel().nextPlayer();
            getGameEngine().setCurrentGameLogic(Mule.ROUNDSTART);

        } else if (townView.getTargetLocation().equals("Store")) {
            getGameEngine().setCurrentGameLogic(Mule.STORE_SCREEN);
        }
    }

    public void timerStart(IntegerProperty timeLeft) {
//        IntegerProperty timeSeconds = new SimpleIntegerProperty(timeLeft);
        townView.setTimerBind(timeLeft);
    }
}
