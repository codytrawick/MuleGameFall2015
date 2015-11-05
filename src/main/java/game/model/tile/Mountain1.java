package game.model.tile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author The SpecialFX
 */
public final class Mountain1 extends Tile {
    private static Map<String, Integer> production = new HashMap<>();
    static {
        production.put("Food", 1);
        production.put("Energy", 1);
        production.put("Ore", 2);
    }

    public String toString() {
        return "Mountain1";
    }

    public Map<String, Integer> getTileProduction() {
        return production;
    }
}
