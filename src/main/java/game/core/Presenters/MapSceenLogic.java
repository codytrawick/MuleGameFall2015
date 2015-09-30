package game.core.Presenters;

import game.core.GameLogic;
import game.model.IModel;
import game.model.Player;
import game.view.interfaces.IMapScreen;

import java.util.ArrayList;

/**
 * Created by Cody on 9/30/2015.
 */
public class MapSceenLogic extends GameLogic {

    IMapScreen mapView;
    private ArrayList<Player> players;

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
    }

    public void viewUpdated() {

    }
}
