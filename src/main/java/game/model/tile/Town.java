package game.model.tile;

/**
 * Created by Cody on 10/13/2015.
 */
public class Town extends Tile {
    public String toString() {
        return "Town";
    }

    public TileProductionTypes getTileProduction() {
        return new TileProductionTypes(0, 0, 0);
    }
}
