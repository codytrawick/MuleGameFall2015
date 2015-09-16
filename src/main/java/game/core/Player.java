package game.core;

/**
 * This class represents a player. This class will hold the important
 * information about that player
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class Player {

    //Player Variables

    private int numPlayers;
    private String name;
    private Race race;
    private Color color;


    public enum Race{MECTRON, GOLLUMER, PACKER, BONZOID, SPHEROID, FLAPPER, LEGGITE, HUMANOID}
    public enum Color{RED, YELLOW, GREEN, BLUE}

    public Player() {

        name = null;
        race = null;
        color = null;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int num) {
        numPlayers = num;
    }


    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public Race getRace() {
        return race;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color c) {
        color = c;
    }



}
