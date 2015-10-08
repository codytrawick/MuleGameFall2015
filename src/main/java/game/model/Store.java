package game.model;

import java.util.HashMap;

/**
 * Created by Andrew on 10/7/2015.
 */
public class Store {

    private int muleStock;
    private int foodStock;
    private int energyStock;
    private int oreStock;

    private int mulePrice = 100;
    private int foodPrice = 30;
    private int energyPrice = 25;
    private int orePrice = 50;
    private int crystitePrice = 100;


    public Store(String difficulty) {
        if (difficulty.equals("Beginner")) {
            muleStock = 25;
            foodStock = 16;
            energyStock = 16;
            oreStock = 0;
        } else if (difficulty.equals("Standard")) {
            muleStock = 14;
            foodStock = 8;
            energyStock = 8;
            oreStock = 8;
        } else {
            muleStock = 14;
            foodStock = 8;
            energyStock = 8;
            oreStock = 8;
        }
    }

    public void produceMules() {
        while (muleStock < 14 && oreStock > 1) {
            muleStock++;
            oreStock = oreStock - 2;
        }
    }

    public void addFood(int num) {
        foodStock = foodStock + num;
    }

    public void addEnergy(int num) {
        energyStock = energyStock + num;
    }

    public void addOre(int num) {
        oreStock = oreStock + num;
    }

    public int getMuleStock() {
        return muleStock;
    }

    public int getFoodStock() {
        return foodStock;
    }

    public int getEnergyStock() {
        return energyStock;
    }

    public int getOreStock() {
        return oreStock;
    }

    public HashMap<String, Integer> getStoreValues() {
        HashMap<String, Integer> output = new HashMap<>();
        output.put("Energy", getEnergyStock());
        output.put("Ore", getOreStock());
        output.put("Food", getFoodStock());
        output.put("Mules", getMuleStock());
        return output;
    }

    public HashMap<String, Integer> getStorePrices() {
         HashMap<String, Integer> prices = new HashMap<>();
        prices.put("mule", mulePrice);
        prices.put("food", foodPrice);
        prices.put("energy", energyPrice);
        prices.put("ore", orePrice);
        prices.put("crystite", crystitePrice);
        return prices;
    }
}
