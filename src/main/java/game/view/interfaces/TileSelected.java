package game.view.interfaces;

/**
 * Created by Cody on 9/29/2015.
 */
public final class TileSelected {
    private int x;
    private int y;

    public TileSelected(int xInput, int yInput) {
        this.x = xInput;
        this.y = yInput;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
