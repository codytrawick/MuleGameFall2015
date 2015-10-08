package game.view.interfaces;

import game.core.Presenters.BuySellAction;
import game.view.GameScreen;

import java.util.HashMap;

/**
 * Created by jarredaultman on 10/7/15.
 */
public interface IStoreScreen extends GameScreen {
    void setStoreAmounts(HashMap<String, Integer> amounts);

    public BuySellAction getBuySellAction();
    void setStorePrices(HashMap<String, Integer> prices);
    void setPlayerAmounts(HashMap<String, Integer> amounts);
}
