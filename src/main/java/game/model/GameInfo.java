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
//    private Player curPlayer;
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

    public String getTileMule(int row, int column) {
        return myGameMap.getTile(row, column).getMuleType();
    }

    public void setTileOwner(int row, int column, Player owner) {
        myGameMap.getTile(row, column).setOwner(owner);
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
        return round.getCurPlayerResources();
    }

    public void resolveRound() {
        store.produceMules();
        round.consumeFood();
    }

    public void performBuySellAction(BuySellAction action) {
        //round.performBuySellAction(action, store);
        //make interface called Sellable, have Food, Energy, and Ore implement it?
        Player player = round.getActualPlayerObjectRemoveLater();
        HashMap<String, Integer> prices = store.getStorePrices();
        int foodPrice = prices.get("Food");
        int energyPrice = prices.get("Energy");
        int orePrice = prices.get("Ore");
        int muleBase = prices.get("Mule");
        if (action.buying()) {
            if (action.getType().equals("Food")) {
                if (store.hasFood() && player.canAfford(foodPrice)) {
                    player.spendMoney(foodPrice);
                    player.addFood(1);
                    store.removeFood(1);
                }
            } else if (action.getType().equals("Energy")) {
                if (store.hasEnergy() && player.canAfford(energyPrice)) {
                    player.spendMoney(energyPrice);
                    player.addEnergy(1);
                    store.removeEnergy(1);
                }
            } else if (action.getType().equals("Ore")) {
                if (store.hasOre() && player.canAfford(orePrice)) {
                    player.spendMoney(orePrice);
                    player.addOre(1);
                    store.removeOre(1);
                }
            } else {
                if (action.getType().substring(0, 5).equals("Mule:")) {
                    String muleType = action.getType().substring(5);
                    int mulePrice = muleBase;
                    if (muleType.equals("Food")) {
                        mulePrice = muleBase + 25;
                    } else if (muleType.equals("Energy")) {
                        mulePrice = muleBase + 50;
                    } else if (muleType.equals("Ore")) {
                        mulePrice = muleBase + 75;
                    }
                    if (store.hasMule() && player.canAfford(mulePrice)) {
                        player.spendMoney(mulePrice);
                        player.setMule(muleType);
                        store.removeMule();
                    }
                }
            }
        } else {
            if (action.getType().equals("Food") && player.hasFood()) {
                player.earnMoney(foodPrice);
                player.addFood(-1);
                store.addFood(1);
            } else if (action.getType().equals("Energy") && player.hasEnergy()) {
                player.earnMoney(energyPrice);
                player.addEnergy(-1);
                store.addEnergy(1);
            } else if (action.getType().equals("Ore") && player.hasOre()) {
                player.earnMoney(orePrice);
                player.addOre(-1);
                store.addOre(1);
            }
        }
    }

    public String getPlayerMule() {
        return round.getPlayerMule();
    }

    public void placeMule(int x, int y, String mule) {
        myGameMap.placeMule(x, y, mule);
    }
}
