package game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Cody on 9/29/2015.
 */
public interface IModel {
    int getPlayerNumber();
    int getCurrentPlayerNumber();
    void setPlayerNumber(int number);
    void setMapType(String mapType);
    void setDifficulty(String difficulty);
    void createNewPlayer(String name, String color, String race);
    ArrayList<Player> getPlayers();
    String getTileTerrain(int row, int column);
    String getTileOwner(int row, int column);
    String getTileMule(int row, int column);
    void setTileOwner(int row, int column, Player owner);
    String currentPlayer();
    void nextPlayer();
    int currentPlayerTime();
    void createRound(int number);
    int getCurrentRound();
    boolean isRoundOver();
    //Round getRound();
    void giveMoney(int money);
    void startTurn(int turnTime);
    String getCurrentPlayerColor();
    //int getPlayerFood();
    Map<String, Integer> getStoreValues();
    Map<String, Integer> getStorePrices();
    Map<String, Integer> getCurPlayerResources();
    void resolveRound();
    String getPlayerMule();
    void placeMule(int x, int y);
    void performBuySellAction(BuySellAction action);
    String performRandomEvent();
}
