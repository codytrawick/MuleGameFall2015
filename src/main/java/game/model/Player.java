package game.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a player. This class will hold the important
 * information about that player
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class Player {

    private String name;
    private String color;
    private String race;
    private int money;
    private int food;
    private int energy;
    private int ore;
    private int score;
    private List<Tile> ownedTiles = new ArrayList<>();
    private String mule;

    public Player(String name, String color, String race) {
        this.name = name;
        this.color = color;
        this.race = race;
        if (race.equals("Humanoid")) {
            money = 600;
        } else if (race.equals("Flapper")) {
            money = 1600;
        } else {
            money = 1000;
        }
        score = 0;
        food = 8;
        energy = 8;
        mule = "";
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getRace() {
        return race;
    }

    public String toString() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void spendMoney(int amount) {
        money -= amount;
    }

    public void earnMoney(int amount) {
        money += amount;
    }

    public int getScore() {
        return money + 500*ownedTiles.size();
    }

    public void purchaseTile(Tile tile) {
        ownedTiles.add(tile);
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        food = food - amount;
    }

    public int getEnergy() {
        return energy;
    }

    public int getOre() {
        return ore;
    }

    public String getMule() {
        return mule;
    }

    public void setMule(String mule) {
        this.mule = mule;
    }

//    public int getScore() {
//        return score;
//    }

}
