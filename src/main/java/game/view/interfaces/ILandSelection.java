package game.view.interfaces;

import game.view.GameScreen;
import javafx.geometry.Point2D;


/**
 * Created by Cody on 9/29/2015.
 */
public interface ILandSelection extends GameScreen {
    public TileSelected playerClickMap();
    public void setTerrain(int row, int column, String terrain);
    public void setPlayerText(String newText);
    public void addTileElement(String type, String color, int row, int column);
}
