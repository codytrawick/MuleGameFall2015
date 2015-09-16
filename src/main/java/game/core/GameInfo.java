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

    public GameInfo(String mapType, String difficultyString, int numPlayers) {
        type = getMapType(mapType);
        difficulty = getDifficulty(difficultyString);
        this.numPlayers = numPlayers;
        players = new Player[numPlayers];
    }

    public Player[] getPlayers() {
        return players;
    }

    private MapType getMapType(String mapTypeString) {
        if (mapTypeString.equals("Standard")) {
            return MapType.STANDARD;
        } else if (mapTypeString.equals("Random Hills")) {
            return MapType.RANDOM;
        } else {
            return null;
        }
    }

    private Difficulty getDifficulty(String difficultyString) {
        if (difficultyString.equals("Beginner")) {
            return Difficulty.BEGINNER;
        } else if (difficultyString.equals("Normal")) {
            return Difficulty.NORMAL;
        } else if (difficultyString.equals("Tournament")) {
            return Difficulty.TOURNAMENT;
        }
        return null;
    }

    public String toString() {
        String output = "";
        output += type.toString() + " " + difficulty.toString() + " " + numPlayers;
        return output;
    }
}
