package game.model.tile;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a river tile
 * @author The SpecialFX
 */
public class River extends Tile {
    private static Map<String, Integer> production = new HashMap<>();
    static {
        production.put("Food", 4);
        production.put("Energy", 2);
        production.put("Ore", 0);
    }
    public String toString() {
        return "River";
    }

    public Map<String, Integer> getTileProduction() {
        return production;
    }
}
