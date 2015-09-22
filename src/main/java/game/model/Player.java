package game.model;

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
    private String race;

    public Player(String name, String color, String race) {
        this.name = name;
        this.color = color;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getRace() {
        return race;
    }

    public String toString() {
        String output = "";
        output += name + " " + color + " " + race;
        return output;
    }

}
