package game.core;

/**
 * This class represents a player. This class will hold the important
 * information about that player
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class Player {

    private String name;
    private String color;
    private Race race;

    public Player(String name, String color, Race race) {
        this.name = name;
        this.color = color;
        this.race = race;
    }

    public enum Race {
        MECHTRON, GOLLUMER, PACKER, BONZOID,
        SPHEROID, FLAPPER, LEGGITE, HUMANOID
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Race getRace() {
        return race;
    }

}
