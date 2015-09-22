package game.model;

import game.controllers.MapScreenController;
import game.model.GameMap;
import game.model.Player;

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
    private GameMap myGameMap;
    private Player curPlayer;

    public enum MapType {
        STANDARD, RANDOM
    }

    public enum Difficulty {
        BEGINNER, NORMAL, TOURNAMENT
    }

    public GameInfo(String mapType, String difficultyString, int numPlayers) {
        type = getMapType(mapType);
        difficulty = getDifficulty(difficultyString);
        this.numPlayers = numPlayers;
        players = new Player[numPlayers];
        myGameMap = new GameMap(type);
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
        } else if (difficultyString.equals("Standard")) {
            return Difficulty.NORMAL;
        } else if (difficultyString.equals("Tournament")) {
            return Difficulty.TOURNAMENT;
        }
        return null;
    }

    public void addPlayer(Player player) {
        if (players[0] == null) {
            players[0] = player;
            curPlayer = player;
        } else if (numPlayers > 1) {
            if (players[1] == null) {
                players[1] = player;
            } else if (numPlayers > 2) {
                if (players[2] == null) {
                    players[2] = player;
                } else if (numPlayers > 3) {
                    if (players[3] == null) {
                        players[3] = player;
                    }
                }
            }
        } 
    }

    public void resetSettings() {
        //for use if game is quit during setup
        numPlayers = 0;
        players = null;
        type = null;
        difficulty = null;
    }

    public int getNumOfPlayers() {
        return numPlayers;
    }

    public GameMap getMyGameMap() {
        return myGameMap;
    }

    public String toString() {
        String output = "";
        output += type.toString() + " " + difficulty.toString() + " " + numPlayers;
        return output;
    }

    public Player getCurPlayer() {
        return curPlayer;
    }

    public void setCurPlayer(Player newPlayer) {
        curPlayer = newPlayer;
    }
}
