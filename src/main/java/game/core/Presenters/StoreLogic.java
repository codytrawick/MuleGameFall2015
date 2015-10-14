package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.BuySellAction;
import game.view.interfaces.IStoreScreen;
import game.model.IModel;

/**
 * This class is the Presenter for the Store Screen
 * @author The SpecialFX
 */
public class StoreLogic extends GameLogic {

    IStoreScreen storeView;

    public StoreLogic(IStoreScreen storeView, IModel imodel) {
        super(imodel);
        this.storeView = storeView;

        this.storeView.setGameLogic(this);
    }

    public void passButton() {
        gameEngine.setCurrentGameLogic(Mule.MAP2SCREEN);
    }

    public void primeScreen() {
        storeView.setStoreAmounts(gameModel.getStoreValues());
        storeView.setStorePrices(gameModel.getStorePrices());
        storeView.setPlayerAmounts(gameModel.getCurPlayerResources());
        storeView.initializeScreen();
    }

    public void viewUpdated() {


        BuySellAction action = storeView.getBuySellAction();
        if (action != null) {
            gameModel.performBuySellAction(action);
        }

        storeView.setPlayerAmounts(gameModel.getCurPlayerResources());
        storeView.setStoreAmounts(gameModel.getStoreValues());
    }



}
