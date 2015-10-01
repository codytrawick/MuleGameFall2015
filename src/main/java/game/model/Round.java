package game.model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Cody on 9/30/2015.
 */
public class Round {
    private Player[] orderedPlayers;
    private int currentPlayer;
    private int roundNumber;

    public Round(int roundNumber, ArrayList<Player> players) {
        this.roundNumber = roundNumber;
        orderedPlayers = new Player[players.size()];
        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getScore() - o2.getScore();
            }
        });
        for (int i = 0; i < players.size(); i++) {
            orderedPlayers[i] = players.get(i);
        }
    }

    public int getCurrentRound() {
        return roundNumber;
    }
}
