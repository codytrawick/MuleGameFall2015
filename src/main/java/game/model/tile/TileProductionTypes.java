package game.model.tile;

/**
 * This class represents the production capacity of a tile
 * @author The SpecialFX
 */
public class TileProductionTypes {
    int foodProduction;
    int oreProduction;
    int energyProduction;

    public TileProductionTypes(int foodProduction, int energyProduction,
                               int oreProduction) {
        this.foodProduction = foodProduction;
        this.energyProduction = energyProduction;
        this.oreProduction = oreProduction;
    }

    public int getFoodProduction() {
        return foodProduction;
    }

    public int getOreProduction() {
        return oreProduction;
    }

    public int getEnergyProduction() {
        return energyProduction;
    }
}
