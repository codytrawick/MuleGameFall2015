package game.model.tile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cody on 10/13/2015.
 */
public final class Mountain2 extends Tile {
    private static Map<String, Integer> production = new HashMap<>();
    static {
        production.put("Food", 1);
        production.put("Energy", 1);
        production.put("Ore", 3);
    }

    public String toString() {
        return "Mountain2";
    }

    public Map<String, Integer> getTileProduction() {
        return production;
    }
}
