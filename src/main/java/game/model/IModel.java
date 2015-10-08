package game.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Cody on 9/29/2015.
 */
public interface IModel {
    int getPlayerNumber();
    void setPlayerNumber(int number);
    void setMapType(String mapType);
    void setDifficulty(String difficulty);
    void createNewPlayer(String name, String color, String race);
    ArrayList<Player> getPlayers();
    String getTileTerrain(int row, int column);
    String getTileOwner(int row, int column);
    void setTileOwner(int row, int column, Player owner);
    String currentPlayer();
    void nextPlayer();
    int currentPlayerTime();
    void createRound(int number);
    int getCurrentRound();
    Round getRound();
    void giveMoney(int money);
    void startTurn(int turnTime);
    String getCurrentPlayerColor();
    int getPlayerFood();
    HashMap<String, Integer> getStoreValues();
    HashMap<String, Integer> getStorePrices();
    HashMap<String, Integer> getCurPlayerResources();
    void resolveRound();

}
