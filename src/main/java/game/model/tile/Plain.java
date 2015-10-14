package game.model.tile;

/**
 * Created by Cody on 10/13/2015.
 */
public class Plain extends Tile {
    public String toString() {
        return "Plains";
    }

    public TileProductionTypes getTileProduction() {
        return new TileProductionTypes(4, 2, 1);
    }

}
