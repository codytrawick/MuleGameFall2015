package game.view.interfaces;

import game.view.GameScreen;

/**
 * Created by Cody on 9/29/2015.
 */
public interface IPlayerConfiguration extends GameScreen {
    public String getPlayerName();
    public String getPlayerRace();
    public String getPlayerColor();
}
