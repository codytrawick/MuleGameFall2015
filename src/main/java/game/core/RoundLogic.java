package game.core;

/**
 * This controls the logic for a round
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class RoundLogic implements GameLogic {

    GameScreen view;

    public void tileWasClicked(int row, int column) {

        if(row==2 && column==4) {
            
        }

    }

    public void setView(GameScreen view) {
        this.view = view;
    }
}
