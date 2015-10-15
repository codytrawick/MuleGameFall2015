package game.view.interfaces;

import game.view.GameScreen;

/**
 * Created by Cody on 9/30/2015.
 */
public interface ITurnStart extends GameScreen {
    void setRoundText(String text);
    void setPlayerName(String name);
    void setRandomEventText(String name);
    void setPubMoney(String amount);

}
