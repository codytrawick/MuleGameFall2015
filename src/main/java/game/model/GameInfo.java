package game.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class holds the information that's important for the game to run
 * It should take in the game information from the Configuration screen
 * then help players create their Player information
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class GameInfo implements IModel {

    private int numPlayers;
    private ArrayList<Player> players;
    private String mapType;
    private String difficulty;
    private GameMap myGameMap;
    private Player curPlayer;
//    private int curPlayerNumber;
    private Round round;
    private Store store;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getPlayerNumber() {
        return numPlayers;
    }

    public void setPlayerNumber(int numPlayers) {
        this.numPlayers = numPlayers;
        players = new ArrayList<>(4);
    }

    public GameMap getMyGameMap() {
        return myGameMap;
    }

    public String toString() {
        String output = "";
        output += mapType + " " + difficulty + " " + numPlayers;
        return output;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        store = new Store(difficulty);
    }

    public void setMapType(String mapType) {
        this.mapType = mapType;
        this.myGameMap = new GameMap(mapType);
    }

    public void createNewPlayer(String name, String color, String race) {
        players.add(new Player(name, color, race));
    }

    public String getTileTerrain(int row, int column) {
        return myGameMap.getTile(row, column).toString();
    }

    public String getTileOwner(int row, int column) {
        Player owner = myGameMap.getTile(row, column).getOwner();
        return owner != null ? owner.getColor() : "None";
    }

    public void setTileOwner(int row, int column, Player owner) {
        myGameMap.getTile(row, column).setOwner(owner);
    }

    public String getCurrentPlayerColor() {
        return curPlayer.getColor();
    }

    public String currentPlayer() {
        return round.currentPlayer();
    }

    public int currentPlayerTime() {
        return round.getPlayerTime();
    }

    public void createRound(int number) {
        round = new Round(number, players);
    }

    public int getCurrentRound() {
        return round.getNumber();
    }

    public void giveMoney(int money) {
        round.giveMoney(money);
    }

    public void nextPlayer() {
        round.nextPlayer();
    }

    public Round getRound() {
        return round;
    }

    public int getPlayerFood() {
        return round.getPlayerFood();
    }

    public void startTurn(int turnTime) {
        round.timerStart(turnTime);
    }

    public HashMap<String, Integer> getStoreValues() {
        return store.getStoreValues();
    }

    public HashMap<String, Integer> getStorePrices() {
        return store.getStorePrices();
    }

    public HashMap<String, Integer> getCurPlayerResources() {
        return curPlayer.getResources();
    }

    public void resolveRound() {
        store.produceMules();
    }

}
