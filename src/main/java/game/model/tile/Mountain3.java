package game.model.tile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cody on 10/13/2015.
 */
public final class Mountain3 extends Tile {
    private static Map<String, Integer> production = new HashMap<>();
    static {
        production.put("Food", 1);
        production.put("Energy", 1);
        production.put("Ore", 4);
    }
    public String toString() {
        return "Mountain3";
    }

    public Map<String, Integer> getTileProduction() {
        return production;
    }
}
