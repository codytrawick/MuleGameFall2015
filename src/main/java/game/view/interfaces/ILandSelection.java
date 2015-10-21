package game.view.interfaces;

import game.view.GameScreen;
import javafx.geometry.Point2D;


/**
 * Created by Cody on 9/29/2015.
 */
public interface ILandSelection extends GameScreen {
    TileSelected lastTileClicked();
    void setTerrain(int row, int column, String terrain);
    void setPlayerText(String newText);
    void addTileElement(String type, String color, int row, int column);
}
