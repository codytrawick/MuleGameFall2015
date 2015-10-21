package game.model;

import game.model.tile.Tile;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

import java.util.*;


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
        //RandomEvent.generateEvent(true, roundNumber);
    }

    public String currentPlayer() {
        return orderedPlayers[currentPlayer].toString();
    }

    public boolean hasResource(String resource) {
        return orderedPlayers[currentPlayer].hasResource(resource);
    }

    public void nextPlayer() {
        currentPlayer++;
        //RandomEvent.generateEvent(false, roundNumber);
    }

    public String performRandomEvent() {
        String randEvent = RandomEvent.generateEvent(currentPlayer == 0,
                ((roundNumber / 4) + 1) * 25);
        if (randEvent.equals("None")) {
            return "No events took place this turn.";
        } else {
            //System.out.println(randEvent.substring(randEvent.indexOf("&") + 1));
            String[] eventOutcomes = randEvent.substring(randEvent.indexOf('&') + 1).split("&");
            for (String event: eventOutcomes) {
                String[] instructions = event.split("~");
                int change;
                if (instructions[1].contains("/")) {
                    change = - orderedPlayers[currentPlayer]
                            .getResource(instructions[0]) / 2;
                } else {
                    change = Integer.parseInt(instructions[1]);
                }
                orderedPlayers[currentPlayer].addResource(instructions[0], change);
            }
            return randEvent.substring(0, randEvent.indexOf('&'));
        }
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
        return (int) timer.getKeyFrames().get(size - 1).getTime().toSeconds();
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

    /*
    public void performBuySellAction(BuySellAction action, Store store) {
        action.performAction(orderedPlayers[currentPlayer], store.getStorePrices(), store);
    }*/

    public Map<String, Integer> getCurPlayerResources() {
        return orderedPlayers[currentPlayer].getResources();
    }

    public Player getActualPlayerObjectRemoveLater() {
        return orderedPlayers[currentPlayer];
    }

    public String currentPlayerColor() {
        return orderedPlayers[currentPlayer].getColor();
    }

    public void consumeFood() {
        int foodReq = 3 + roundNumber / 4;
        for (Player p: orderedPlayers) {
            if (p.getFood() > foodReq) {
                p.addResource("Food", -foodReq);
            } else {
                p.addResource("Food", -p.getFood());
            }
        }
    }

    public void setMule(String target) {
        orderedPlayers[currentPlayer].setMule(target);
    }

    public boolean canAfford(int amount) {
        return orderedPlayers[currentPlayer].canAfford(amount);
    }

    public void addResource(String resource, int amount) {
        orderedPlayers[currentPlayer].addResource(resource, amount);
    }

    public void calculateProduction() {
        for (Player p : orderedPlayers) {
            p.calculateProduction();
        }
    }

    public void addPlayerTile(Tile target) {
        orderedPlayers[currentPlayer].purchaseTile(target);
    }
}
