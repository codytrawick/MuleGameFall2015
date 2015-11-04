package game.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrew on 10/7/2015.
 */
public class Store implements Serializable {

    private int muleStock;
    private int foodStock;
    private int energyStock;
    private int oreStock;

    private static final int mulePrice = 100;
    private static final int foodPrice = 30;
    private static final int energyPrice = 25;
    private static final int orePrice = 50;
    private static final int crystitePrice = 100;


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
            oreStock = oreStock - 2; //convert 2 ore into a mule
        }
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

    public Map<String, Integer> getStoreValues() {
        HashMap<String, Integer> output = new HashMap<>();
        output.put("Energy", getEnergyStock());
        output.put("Ore", getOreStock());
        output.put("Food", getFoodStock());
        output.put("Mules", getMuleStock());
        return output;
    }

    public Map<String, Integer> getStorePrices() {
         HashMap<String, Integer> prices = new HashMap<>();
        prices.put("Mule", mulePrice);
        prices.put("Food", foodPrice);
        prices.put("Energy", energyPrice);
        prices.put("Ore", orePrice);
        prices.put("Crystite", crystitePrice);
        return prices;
    }

    public boolean hasResource(String resource) {
        if (resource.equals("Food")) {
            return foodStock > 0;
        } else if (resource.equals("Energy")) {
            return energyStock > 0;
        } else if (resource.equals("Ore")) {
            return oreStock > 0;
        } else if (resource.equals("Mule")) {
            return muleStock > 0;
        } else {
            return false;
        }
    }

    public void removeResource(String resource) {
        if (resource.equals("Food")) {
            foodStock--;
        } else if (resource.equals("Energy")) {
            energyStock--;
        } else if (resource.equals("Ore")) {
            oreStock--;
        } else if (resource.equals("Mule")) {
            muleStock--;
        }
    }

    public void addResource(String resource) {
        if (resource.equals("Food")) {
            foodStock++;
        } else if (resource.equals("Energy")) {
            energyStock++;
        } else if (resource.equals("Ore")) {
            oreStock++;
        } else if (resource.equals("Mule")) {
            muleStock++;
        }
    }

    public int resourcePrice(String resource) {
        switch (resource) {
            case "Food": return foodPrice;
            case "Energy": return energyPrice;
            case "Ore": return orePrice;
        }

        if (resource.substring(0, 5).equals("Mule:")) { //Size of "Mule:"
            switch (resource.substring(5)) {
                case "Food": return mulePrice + 25;
                case "Energy": return mulePrice + 50;
                case "Ore": return mulePrice + 75;
            }
        }
        return 0;
    }
}
