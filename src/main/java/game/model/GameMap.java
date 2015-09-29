package game.model;

/**
 * Created by The SpecialFX on 9/21/2015.
 * @author The SpecialFX
 * @version 1.0
 */
public class GameMap {

    private Tile[][] gameMap;

    public GameMap() {
        this("Standard");
    }

    public GameMap(String mapType) {
        generateMap(mapType);
    }

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
