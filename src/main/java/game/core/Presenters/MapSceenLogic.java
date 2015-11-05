package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.IModel;
import game.view.interfaces.IMapScreen;
import game.view.interfaces.TileSelected;
import javafx.beans.property.IntegerProperty;

/**
 * This class is the presenter for the  Map Screen
 * @author The SpecialFX
 */
public class MapSceenLogic extends GameLogic {

    private IMapScreen mapView;

    public MapSceenLogic(IMapScreen mapView, IModel model) {
        super(model);
        this.mapView = mapView;

        this.mapView.setGameLogic(this);
    }

    public void passButton() {

    }

    public void primeScreen() {
        for (int row = 0, col = 0; row < 5; col++) {
            mapView.setTile(getGameModel().getTileTerrain(row, col),
                    getGameModel().getTileOwner(row, col),
                    getGameModel().getTileMule(row, col), row, col);
            if (col == 8) {
                row++;
                col = -1;
            }
        }
        mapView.setPlayerInfo(getGameModel().getPlayers());

        mapView.setCurrentPlayer(getGameModel().currentPlayer());

        mapView.setRoundNumber(getGameModel().getCurrentRound());
    }

    public void viewUpdated() {
        TileSelected playerClick = mapView.lastTileClicked();
        if (playerClick.getX() == 2 && playerClick.getY() == 4) {
            getGameEngine().setCurrentGameLogic(Mule.TOWN_SCREEN);
        } else {
            getGameModel().placeMule(playerClick.getX(), playerClick.getY());
            primeScreen();
        }
    }

    public int getTimeLeft() {
        return mapView.timeLeft();
    }

    public void timerStart(IntegerProperty timeSeconds) {
//        IntegerProperty timeSeconds = new SimpleIntegerProperty(timeLeft);
        mapView.setTimerBind(timeSeconds);
//        timeSeconds.set(timeLeft);
//        Timeline timeline = new Timeline();
//        timeline.getKeyFrames().add(
//                new KeyFrame(Duration.seconds(timeLeft + 1),
//                new KeyValue(timeSeconds, 0)));
//        timeline.playFromStart();
    }

    public void timeExpired() {
        if (!(getGameEngine().betweenTurns())) {
            getGameEngine().setCurrentGameLogic(Mule.ROUNDSTART);
        }
    }

}
