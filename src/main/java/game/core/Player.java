package game.core;

/**
 * This class represents a player. This class will hold the important
 * information about that player
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class Player {

<<<<<<< HEAD
    private String name;
    private String color;
    private Race race;

    public Player(String name, String color, Race race) {
        this.name = name;
        this.color = color;
        this.race = race;
    }

=======
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


>>>>>>> master
    public String getName() {
        return name;
    }

<<<<<<< HEAD
    public String getColor() {
        return color;
=======
    public void setName(String newName) {
        name = newName;
>>>>>>> master
    }

    public Race getRace() {
        return race;
    }

<<<<<<< HEAD
=======
    public Color getColor() {
        return color;
    }

    public void setColor(Color c) {
        color = c;
    }


>>>>>>> master

}
