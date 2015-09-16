package game.core;

/**
 * This class holds the information that's important for the game to run
 * It should take in the game information from the Configuration screen
 * then help players create their Player information
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class GameInfo {

    private int numPlayers;
    private Player[] players;
    private MapType type;
    private Difficulty difficulty;

    private enum MapType {
        STANDARD, RANDOM
    }

    private enum Difficulty {
        BEGINNER, NORMAL, TOURNAMENT
    }

    public GameInfo(int numPlayers) {
        this.numPlayers = numPlayers;
        players = new Player[numPlayers];
    }

    public Player[] getPlayers() {
        return players;
    }
}
