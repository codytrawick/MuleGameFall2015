package game.model;

/**
 * Created by Cody on 9/29/2015.
 */
public interface IModel {
    int getPlayerNumber();
    void setPlayerNumber(int number);
    void setMapType(String mapType);
    void setDifficulty(String difficulty);

}
