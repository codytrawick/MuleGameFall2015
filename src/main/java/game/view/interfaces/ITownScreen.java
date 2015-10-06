package game.view.interfaces;

import game.view.GameScreen;
import javafx.beans.property.IntegerProperty;

/**
 * Created by Cody on 9/29/2015.
 */
public interface ITownScreen extends GameScreen {
    String getTargetLocation();
    void setTimerBind(IntegerProperty timeSeconds);

}
