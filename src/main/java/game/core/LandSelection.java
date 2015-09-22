package game.core;
import game.model.GameMap;
import game.model.Player;

public class LandSelection {

    private Player[] players;
    private GameMap gameMap;

    public LandSelection(GameMap gameMap, Player[] players) {
        this.gameMap = gameMap;
        this.players = players;
    }

    public void executeAuction() {
        boolean[] playerPassed = new boolean[players.length];
        for (int i = 0; i < players.length; i++) {
            playerPassed[i] = executeTurn(players[i]);
        }
    }

    //Need to fill this out to actually have the current player do stuff
    public boolean executeTurn(Player curPlayer) {
        return false;
    }
}
