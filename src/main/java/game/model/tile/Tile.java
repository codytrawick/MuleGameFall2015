package game.model.tile;

import game.model.Player;

import java.io.Serializable;
import java.util.Map;

/**
 * This class represents a Tile. Tiles are abstract
 * Created by The SpecialFX on 9/21/2015.
 */
public abstract class Tile implements Serializable {

    private String prodType;
    private String muleType = "";
    private boolean ownedStatus;
    private String ownerColor;
    private int production;

    public Tile() {
        ownedStatus = false;
        production = 0;
    }

    public final String getProdType() {
        return prodType;
    }

    public final int getProduction() {
        return production;
    }

    public final void setOwner(Player owner) {
        ownedStatus = true;
        this.ownerColor = owner.getColor();
    }

    public final void setMule(String mule) {
        muleType = mule;
    }

    public final String getMuleType() {
        return muleType;
    }

    public final String getOwner() {
        return ownerColor;
    }

    public final boolean isOwned() {
        return ownedStatus;
    }

    public abstract Map<String, Integer> getTileProduction();

}
