package game.core.Presenters;

import game.core.GameLogic;
import game.model.IModel;
import game.model.Player;
import game.view.interfaces.IMapScreen;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import javafx.scene.control.Label;
import java.util.ArrayList;

/**
 * Created by Cody on 9/30/2015.
 */
public class MapSceenLogic extends GameLogic {

    IMapScreen mapView;
    private ArrayList<Player> players;
    private Timeline timeline;

    public MapSceenLogic(IMapScreen mapView, IModel gameModel) {
        super(gameModel);
        this.mapView = mapView;

        this.mapView.setGameLogic(this);
    }

    public void passButton() {

    }

    public void primeScreen() {
        for (int row = 0, col = 0; row < 5; col++) {
            mapView.setTile(gameModel.getTileTerrain(row, col),
                    gameModel.getTileOwner(row, col), row, col);
            if (col == 8) {
                row++;
                col = -1;
            }
        }
        mapView.setPlayerInfo(gameModel.getPlayers());

        players = gameModel.getPlayers();
        mapView.setCurrentPlayer(players.get(0).getName());
        timerStart(50);
    }

    public void viewUpdated() {

    }

    public void timerStart(int timeLeft) {
        Label timeLabel = mapView.getTimeLabel();
        IntegerProperty timeSeconds = new SimpleIntegerProperty(timeLeft);
        timeLabel.textProperty().bind(timeSeconds.asString());
        timeSeconds.set(timeLeft);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(timeLeft + 1),
                new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
    }
}
