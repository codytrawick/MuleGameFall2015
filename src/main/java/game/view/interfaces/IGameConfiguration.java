package game.view.interfaces;

import game.core.Presenters.ConfigurationLogic;
import game.view.GameScreen;

/**
 * Created by Cody on 9/29/2015.
 */
public interface IGameConfiguration extends GameScreen {
    public String getMapType();
    public String getDifficulty();
    public int getPlayerNumber();
}
