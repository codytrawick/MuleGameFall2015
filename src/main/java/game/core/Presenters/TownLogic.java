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
        //Nothing to do here yet
    }

    public void viewUpdated() {
        //TODO
    }
}