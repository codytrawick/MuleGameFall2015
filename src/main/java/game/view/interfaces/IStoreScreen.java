package game.view.interfaces;

import game.view.GameScreen;

import java.util.HashMap;

/**
 * Created by jarredaultman on 10/7/15.
 */
public interface IStoreScreen extends GameScreen {
    void setStoreAmounts(HashMap<String, Integer> amounts);
}
