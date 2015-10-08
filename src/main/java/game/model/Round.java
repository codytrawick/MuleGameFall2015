package game.model;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;


/**
 * This class represents a round
 * @author The SpecialFX
 */
public class Round {
    private Player[] orderedPlayers;
    private int currentPlayer;
    private int roundNumber;
    private Timeline timer;

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

    public String currentPlayer() {
        return orderedPlayers[currentPlayer].toString();
    }

    public void nextPlayer() {
        currentPlayer++;
    }

    public boolean isOver() {
        return currentPlayer == orderedPlayers.length;
    }

    public int getNumber() {
        return roundNumber;
    }

    public int getPlayerFood() {
        return orderedPlayers[currentPlayer].getFood();
    }

    public int getPlayerTime() {
        int playerFood = orderedPlayers[currentPlayer].getFood();
        int roundRequirement = 3 + (roundNumber / 4);
        int playTime;
        if (playerFood > roundRequirement) {
            playTime = 50;
        } else if (playerFood > 0) {
            playTime = 30;
        } else {
            playTime = 5;
        }
        return playTime;
    }

    public void giveMoney(int money) {
        orderedPlayers[currentPlayer].earnMoney(money);
    }

    public Timeline getTimeline() {
        return timer;
    }

    public void timerStart(int timeLeft) {
        IntegerProperty timeSeconds = new SimpleIntegerProperty(timeLeft);
        timeSeconds.set(timeLeft);
        timer = new Timeline();
        timer.getKeyFrames().add(
                new KeyFrame(Duration.seconds(timeLeft + 1),
                        new KeyValue(timeSeconds, 0)));
        timer.playFromStart();
    }

    public int getTimeElapsed() {

        int size = timer.getKeyFrames().size();
        int seconds = (int) timer.getKeyFrames().get(size - 1).getTime().toSeconds();
        System.out.println(seconds + " seconds have passed");
        return seconds;
    }

    public int getTimeRemaining() {
        int seconds = getTimeElapsed();
        if (seconds >= 50) {
            return 0;
        } else {
            return 50 - seconds;
        }

    }

    public String getPlayerMule() {
        String output = orderedPlayers[currentPlayer].getMule();
        orderedPlayers[currentPlayer].setMule("");
        return output;
    }
}
