package game.model;

import java.util.ArrayList;

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
    int currentPlayerTime();
    void createRound(int number);
    String getCurrentPlayerColor();

}
