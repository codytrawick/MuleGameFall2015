package game.model.tile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cody on 10/13/2015.
 */
public final class Town extends Tile {
    private static Map<String, Integer> production = new HashMap<>();
    static {
        production.put("Food", 0);
        production.put("Energy", 0);
        production.put("Ore", 0);
    }
    public String toString() {
        return "Town";
    }

    public Map<String, Integer> getTileProduction() {
        return production;
    }
}
