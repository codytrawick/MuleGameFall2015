package game.model.tile;

/**
 * Created by Cody on 10/13/2015.
 */
public class Mountain1 extends Tile {
    public String toString() {
        return "Mountain1";
    }

    public TileProductionTypes getTileProduction() {
        return new TileProductionTypes(4, 2, 1);
    }
}
