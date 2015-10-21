package game.view.interfaces;

import game.model.Player;
import game.view.GameScreen;

import javafx.beans.property.IntegerProperty;
import java.util.ArrayList;

/**
 * Created by Cody on 9/30/2015.
 */
public interface IMapScreen extends GameScreen {
    TileSelected lastTileClicked();
    void addTileElement(String type, String color, int row, int column);
    void setPlayerInfo(ArrayList<Player> players);
    void setTile(String terrain, String owner, String mule, int row, int column);
    void setRoundNumber(int newNum);
    void setCurrentPlayer(String player);
    void setTimerBind(IntegerProperty timeSeconds);
    void setTimerText(String timeLeft);
    int timeLeft();
}
