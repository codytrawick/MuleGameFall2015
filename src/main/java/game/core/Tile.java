package game.core;

/**
 * Created by temp on 9/21/2015.
 */
public class Tile {

    private String terrain;
    private String prodType;
    private boolean hasMule;
    private boolean ownedStatus;
    private Player owner;
    private int production;

    public Tile(String terrain) {
        this.terrain = terrain;
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
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isOwned() {
        return ownedStatus;
    }

    public String toString() {
        return terrain;
    }
}
