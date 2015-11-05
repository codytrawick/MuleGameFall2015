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
public final class StoreLogic extends GameLogic {

    private IStoreScreen storeView;

    public StoreLogic(IStoreScreen newStoreView, IModel imodel) {
        super(imodel);
        this.storeView = newStoreView;

        this.storeView.setGameLogic(this);
    }

    public void passButton() {
        getGameEngine().setCurrentGameLogic(Mule.MAP2SCREEN);
    }

    public void primeScreen() {
        storeView.setStoreAmounts(getGameModel().getStoreValues());
        storeView.setStorePrices(getGameModel().getStorePrices());
        storeView.setPlayerAmounts(getGameModel().getCurPlayerResources());
        storeView.initializeScreen();
    }

    public void viewUpdated() {


        BuySellAction action = storeView.getBuySellAction();
        if (action != null) {
            getGameModel().performBuySellAction(action);
        }

        storeView.setPlayerAmounts(getGameModel().getCurPlayerResources());
        storeView.setStoreAmounts(getGameModel().getStoreValues());
    }



}
