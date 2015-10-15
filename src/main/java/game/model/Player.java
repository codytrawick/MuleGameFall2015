package game.model;

import game.model.tile.Tile;
import game.model.tile.TileProductionTypes;

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

    public void setMule(String mule) {
        this.mule = mule;
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
        if (type.equals("Food")) {
            return food;
        } else if (type.equals("Energy")) {
            return energy;
        } else if (type.equals("Ore")) {
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

    public HashMap<String, Integer> getResources() {
        HashMap<String, Integer> amounts = new HashMap<>();
        amounts.put("Food", food);
        amounts.put("Energy", energy);
        amounts.put("Ore", ore);
        return amounts;
    }

    public boolean canAfford(int price) {
        return money >= price;
    }

    public boolean hasFood() {
        return (food > 0);
    }

    public boolean hasEnergy() {
        return (energy > 0);
    }

    public boolean hasOre() {
        return (ore > 0);
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
