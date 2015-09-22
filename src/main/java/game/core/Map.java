package game.core;

/**
 * Created by temp on 9/21/2015.
 */
public class Map {

    private Tile[][] gameMap;

    public void generateMap(String mapType) {
        if (mapType.equals("Standard")) {
            gameMap = new Tile[][]{
                    {new Tile("P"), new Tile("P"), new Tile("M1"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("M3"), new Tile("P"), new Tile("P")},
                    {new Tile("P"), new Tile("M1"), new Tile("P"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("M3")},
                    {new Tile("M3"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("Town"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("M1")},
                    {new Tile("P"), new Tile("M2"), new Tile("P"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("M2"), new Tile("P"), new Tile("P")},
                    {new Tile("P"), new Tile("P"), new Tile("M2"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("M2")}
            };
        } else {
            //If we do randomized hills, it'll go in this block
            gameMap = new Tile[][]{
                    {new Tile("P"), new Tile("P"), new Tile("M1"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("M3"), new Tile("P"), new Tile("P")},
                    {new Tile("P"), new Tile("M1"), new Tile("P"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("M3")},
                    {new Tile("M3"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("Town"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("M1")},
                    {new Tile("P"), new Tile("M2"), new Tile("P"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("M2"), new Tile("P"), new Tile("P")},
                    {new Tile("P"), new Tile("P"), new Tile("M2"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("M2")}
            };
        }
    }

    public Tile getTile(int x, int y) {
        return gameMap[x][y];
    }
}
