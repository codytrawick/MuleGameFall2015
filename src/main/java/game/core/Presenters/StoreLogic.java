package game.core.Presenters;

import game.core.GameLogic;
import game.view.interfaces.IStoreScreen;
import game.model.IModel;

/**
 * Created by jarredaultman on 10/7/15.
 */
public class StoreLogic extends GameLogic {

    IStoreScreen storeView;

    public StoreLogic(IStoreScreen storeView, IModel imodel) {
        super(imodel);
        this.storeView = storeView;

        this.storeView.setGameLogic(this);
    }

    public void passButton() {}

    public void primeScreen() {}

    public void viewUpdated() {}



}