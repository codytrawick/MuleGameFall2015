package game.model.tile;

/**
 * This class represents a river tile
 * @author The SpecialFX
 */
public class River extends Tile {
    public String toString() {
        return "River";
    }

    public TileProductionTypes getTileProduction() {
        return new TileProductionTypes(4, 2, 1);
    }
}
