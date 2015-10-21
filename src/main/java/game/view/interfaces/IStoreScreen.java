package game.view.interfaces;

import game.model.BuySellAction;
import game.view.GameScreen;

import java.util.Map;

/**
 * Created by jarredaultman on 10/7/15.
 */
public interface IStoreScreen extends GameScreen {
    void setStoreAmounts(Map<String, Integer> amounts);
    BuySellAction getBuySellAction();
    void setStorePrices(Map<String, Integer> prices);
    void setPlayerAmounts(Map<String, Integer> amounts);
}
