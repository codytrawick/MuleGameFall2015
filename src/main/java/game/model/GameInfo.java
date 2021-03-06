package game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class holds the information that's important for the game to run
 * It should take in the game information from the Configuration screen
 * then help players create their Player information
 *
 * @author The SpecialFX
 * @version 1.0
 */
public final class GameInfo implements IModel, Serializable {

    private int numPlayers;
    private List<Player> playerList;
    private String mapType;
    private String difficulty;
    private GameMap myGameMap;
//    private Player curPlayer;
//    private int curPlayerNumber;
    private Round round;
    private Store store;

    public List<Player> getPlayers() {
        return playerList;
    }

    public int getPlayerNumber() {
        return numPlayers;
    }

    public int getCurrentPlayerNumber() {
        return round.getCurrentPlayerNumber();
    }

    public void setPlayerNumber(int newNumPlayers) {
        this.numPlayers = newNumPlayers;
        playerList = new ArrayList<>(); //Number of players
    }

    public GameMap getMyGameMap() {
        return myGameMap;
    }

    public String toString() {
        String output = "";
        output += mapType + " " + difficulty + " " + numPlayers;
        return output;
    }

    public void setDifficulty(String newDifficulty) {
        this.difficulty = newDifficulty;
        store = new Store(difficulty);
    }

    public void setMapType(String newMapType) {
        this.mapType = newMapType;
        this.myGameMap = new GameMap(mapType);
    }

    public void createNewPlayer(String name, String color, String race) {
        playerList.add(new Player(name, color, race));
    }

    public String getTileTerrain(int row, int column) {
        return myGameMap.getTile(row, column).toString();
    }

    public String getTileOwner(int row, int column) {
        String owner = myGameMap.getTile(row, column).getOwner();
        return owner != null ? owner : "None";
    }

    public String getTileMule(int row, int column) {
        return myGameMap.getTile(row, column).getMuleType();
    }

    public void setTileOwner(int row, int column, Player owner) {
        myGameMap.getTile(row, column).setOwner(owner);
        owner.purchaseTile(myGameMap.getTile(row, column));
    }

    public String getCurrentPlayerColor() {
        return round.currentPlayerColor();
    }

    public String currentPlayer() {
        return round.currentPlayer();
    }

    public int currentPlayerTime() {
        return round.getPlayerTime();
    }

    public void createRound(int number) {
        round = new Round(number, playerList);
    }

    public int getCurrentRound() {
        if (round == null) {
            return 0;
        }
        return round.getNumber();
    }

    public void giveMoney(int money) {
        round.giveMoney(money);
    }

    public void nextPlayer() {
        if (round.isOver() && round.getNumber() < 12) { //&& round.getNumber() < 12
            resolveRound();
            createRound(round.getNumber() + 1);
        } else {
            round.nextPlayer();
        }
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

    public Map<String, Integer> getStoreValues() {
        return store.getStoreValues();
    }

    public Map<String, Integer> getStorePrices() {
        return store.getStorePrices();
    }

    public Map<String, Integer> getCurPlayerResources() {
        return round.getCurPlayerResources();
    }

    public boolean isRoundOver() {
        return round.isOver();
    }

    public void resolveRound() {
        store.produceMules();
        round.consumeFood();
        round.calculateProduction();
        //myGameMap.produceStuff();
    }

    public String performRandomEvent() {
        return round.performRandomEvent();
    }

    public void performBuySellAction(BuySellAction action) {
        String actionType = action.getType();
        int resourcePrice = store.resourcePrice(actionType);
        if (action.buying()) {
            if (actionType.length() > 5 && actionType.substring(0, 5).equals("Mule:")) { //Size of the word "Mule:"
                String muleType = actionType.substring(5);
                if (store.hasResource("Mule") && round.canAfford(resourcePrice)) {
                    round.giveMoney(-resourcePrice);
                    round.setMule(muleType);
                    store.removeResource("Mule");
                }
            } else if (store.hasResource(actionType) &&
                    round.canAfford(resourcePrice)) {
                round.giveMoney(-resourcePrice);
                round.addResource(actionType, 1);
                store.removeResource(actionType);
            }
        } else {
            if (round.hasResource(action.getType())) {
                round.giveMoney(resourcePrice);
                round.addResource(action.getType(), -1);
                store.addResource(action.getType());
            }
        }
    }

    public String getPlayerMule() {
        return round.getPlayerMule();
    }

    public void placeMule(int x, int y) {
        String tileOwner = getTileOwner(x, y);
        String muleType = getPlayerMule();
        if (!muleType.equals("") && tileOwner.equals(getCurrentPlayerColor())) {
            myGameMap.placeMule(x, y, muleType);
        }
    }
}
