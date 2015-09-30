package game.view.interfaces;

/**
 * Created by Cody on 9/29/2015.
 */
public class TileSelected {
    int x;
    int y;

    public TileSelected(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
