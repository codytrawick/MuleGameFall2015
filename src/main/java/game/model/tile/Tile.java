package game.model.tile;

import game.model.Player;

import java.util.Map;

/**
 * Created by temp on 9/21/2015.
 */
public abstract class Tile {

    private String prodType;
    private String muleType = "";
    private boolean ownedStatus;
    private String ownerColor;
    private int production;

    public Tile() {
        ownedStatus = false;
        production = 0;
    }

    public String getProdType() {
        return prodType;
    }

    public int getProduction() {
        return production;
    }

    public void setOwner(Player owner) {
        ownedStatus = true;
        this.ownerColor = owner.getColor();
    }

    public abstract Map<String, Integer> getTileProduction();

    public void setMule(String mule) {
        muleType = mule;
    }

    public String getMuleType() {
        return muleType;
    }

    public String getOwner() {
        return ownerColor;
    }

    public boolean isOwned() {
        return ownedStatus;
    }

    /**
     * Does production, updating model as necessary, for this tile
     * Caller must make sure that this tile is owned
     *
    public void produceStuff() {
        //make Tile abstract, make new terrain types that implement Tile?
        if (owner.hasEnergy()) {
            if (terrain.equals("R")) {
                if (muleType.equals("Food")) {
                    owner.addFood(4);
                    owner.addEnergy(-1);
                } else if (muleType.equals("Energy")) {
                    owner.addEnergy(2);
                    owner.addEnergy(-1);
                }
            } else if (terrain.equals("P")) {
                if (muleType.equals("Food")) {
                    owner.addFood(2);
                    owner.addEnergy(-1);
                } else if (muleType.equals("Energy")) {
                    owner.addEnergy(3);
                    owner.addEnergy(-1);
                } else if (muleType.equals("Ore")) {
                    owner.addOre(1);
                    owner.addEnergy(-1);
                }
            } else if (terrain.equals("M1")) {
                if (muleType.equals("Food")) {
                    owner.addFood(1);
                    owner.addEnergy(-1);
                } else if (muleType.equals("Energy")) {
                    owner.addEnergy(1);
                    owner.addEnergy(-1);
                } else if (muleType.equals("Ore")) {
                    owner.addOre(2);
                    owner.addEnergy(-1);
                }
            } else if (terrain.equals("M2")) {
                if (muleType.equals("Food")) {
                    owner.addFood(1);
                    owner.addEnergy(-1);
                } else if (muleType.equals("Energy")) {
                    owner.addEnergy(1);
                    owner.addEnergy(-1);
                } else if (muleType.equals("Ore")) {
                    owner.addOre(3);
                    owner.addEnergy(-1);
                }
            } else if (terrain.equals("M3")) {
                if (muleType.equals("Food")) {
                    owner.addFood(1);
                    owner.addEnergy(-1);
                } else if (muleType.equals("Energy")) {
                    owner.addEnergy(1);
                    owner.addEnergy(-1);
                } else if (muleType.equals("Ore")) {
                    owner.addOre(4);
                    owner.addEnergy(-1);
                }
            }
        }
    } */
}
