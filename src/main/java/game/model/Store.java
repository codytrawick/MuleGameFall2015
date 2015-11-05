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

    private static final int MULE_PRICE = 100;
    private static final int FOOD_PRICE = 30;
    private static final int ENERGY_PRICE = 25;
    private static final int ORE_PRICE = 50;
    private static final int CRYSTITE_PRICE = 100;

    public static final String ORE = "Ore";
    public static final String FOOD = "Food";
    public static final String MULES = "Mules";
    public static final String MULE = "Mule";
    public static final String ENERGY = "Energy";
    public static final String CRYSTITE = "Crystite";


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
        output.put(ENERGY, getEnergyStock());
        output.put(ORE, getOreStock());
        output.put(FOOD, getFoodStock());
        output.put(MULES, getMuleStock());
        return output;
    }

    public Map<String, Integer> getStorePrices() {
         HashMap<String, Integer> prices = new HashMap<>();
        prices.put(MULE, MULE_PRICE);
        prices.put(FOOD, FOOD_PRICE);
        prices.put(ENERGY, ENERGY_PRICE);
        prices.put(ORE, ORE_PRICE);
        prices.put(CRYSTITE, CRYSTITE_PRICE);
        return prices;
    }

    public boolean hasResource(String resource) {
        if (resource.equals(FOOD)) {
            return foodStock > 0;
        } else if (resource.equals(ENERGY)) {
            return energyStock > 0;
        } else if (resource.equals(ORE)) {
            return oreStock > 0;
        } else if (resource.equals(MULE)) {
            return muleStock > 0;
        } else {
            return false;
        }
    }

    public void removeResource(String resource) {
        if (resource.equals(FOOD)) {
            foodStock--;
        } else if (resource.equals(ENERGY)) {
            energyStock--;
        } else if (resource.equals(ORE)) {
            oreStock--;
        } else if (resource.equals(MULE)) {
            muleStock--;
        }
    }

    public void addResource(String resource) {
        if (resource.equals(FOOD)) {
            foodStock++;
        } else if (resource.equals(ENERGY)) {
            energyStock++;
        } else if (resource.equals(ORE)) {
            oreStock++;
        } else if (resource.equals(MULE)) {
            muleStock++;
        }
    }

    public int resourcePrice(String resource) {
        switch (resource) {
            case FOOD: return FOOD_PRICE;
            case ENERGY: return ENERGY_PRICE;
            case ORE: return ORE_PRICE;
        }

        if (resource.substring(0, 5).equals("Mule:")) { //Size of "Mule:"
            switch (resource.substring(5)) {
                case FOOD: return MULE_PRICE + 25;
                case ENERGY: return MULE_PRICE + 50;
                case ORE: return MULE_PRICE + 75;
            }
        }
        return 0;
    }
}
