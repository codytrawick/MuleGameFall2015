package game.model;

import game.model.tile.Tile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a player. This class will hold the important
 * information about that player
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class Player implements Serializable {

    private String name;
    private String color;
    private String race;
    private int money;
    private int food;
    private int energy;
    private int ore;
    private List<Tile> ownedTiles = new ArrayList<>();
    private String mule;

    private String foodLiteral = "Food", energyLiteral = "Energy", oreLiteral =
            "Ore";

    public Player(String newName, String newColor, String newRace) {
        this.name = newName;
        this.color = newColor;
        this.race = newRace;
        if (race.equals("Humanoid")) {
            money = 600;
        } else if (race.equals("Flapper")) {
            money = 1600;
        } else {
            money = 1000;
        }
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

    public boolean spendMoney(int amount) {
        if (money >= amount) {
            money -= amount;
            return true;
        } else {
            return false;
        }
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

    public int getEnergy() {
        return energy;
    }

    public int getOre() {
        return ore;
    }

    public String getMule() {
        return mule;
    }

    public void setMule(String newMule) {
        this.mule = newMule;
    }

    //public void setFood(int food) { this.food += food; }

    //public void setOre(int ore) { this.ore += ore; }

    //public void setEnergy(int energy) { this.energy += energy; }


    /**
     * To decrease food pass in a negative amount
     * @param amount
     */
    public void addFood(int amount) { this.food += amount; }

    /**
     * To decrease ore pass in a negative amount
     * @param amount
     */
    public void addOre(int amount) { this.ore += amount; }

    /**
     * To decrease energy pass in a negative amount
     * @param amount
     */
    public void addEnergy(int amount) { this.energy += amount; }

    public int getResource(String type) {
        if (type.equals(foodLiteral)) {
            return food;
        } else if (type.equals(energyLiteral)) {
            return energy;
        } else if (type.equals(oreLiteral)) {
            return ore;
        } else if (type.equals("Money")) {
            return money;
        } else {
            return 0;
        }
    }

    public void addResource(String type, int amount) {
        switch (type) {
            case "Food": food += amount; break;
            case "Energy": energy += amount; break;
            case "Ore": ore += amount; break;
            case "Money": money += amount; break;
        }
    }

//    public int getScore() {
//        return score;
//    }

    public Map<String, Integer> getResources() {
        HashMap<String, Integer> amounts = new HashMap<>();
        amounts.put(foodLiteral, food);
        amounts.put(energyLiteral, energy);
        amounts.put(oreLiteral, ore);
        return amounts;
    }

    public boolean canAfford(int price) {
        return money >= price;
    }

    public boolean hasResource(String resource) {
        if (resource.equals(foodLiteral)) {
            return food > 0;
        } else if (resource.equals(energyLiteral)) {
            return energy > 0;
        } else if (resource.equals(oreLiteral)) {
            return ore > 0;
        } else {
            return false;
        }
    }

    public void calculateProduction() {
        for (Tile t : ownedTiles) {
            if (energy > 0 && !t.getMuleType().equals("")) {
                Map<String, Integer> tileThings = t.getTileProduction();
                String muleType = t.getMuleType();
                this.addResource(muleType, tileThings.get(muleType));
                energy--;
            }
        }
    }
}
