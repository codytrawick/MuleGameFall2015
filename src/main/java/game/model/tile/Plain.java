package game.model.tile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cody on 10/13/2015.
 */
public final class Plain extends Tile {
    private static Map<String, Integer> production = new HashMap<>();
    static {
        production.put("Food", 2);
        production.put("Energy", 3);
        production.put("Ore", 1);
    }
    public String toString() {
        return "Plains";
    }

    public Map<String, Integer> getTileProduction() {
        return production;
    }

}
