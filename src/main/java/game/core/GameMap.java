package game.core;

/**
 * Created by The SpecialFX on 9/21/2015.
 * @author The SpecialFX
 * @version 1.0
 */
public class GameMap {

    private Tile[][] gameMap;

    public GameMap() {
        generateMap(GameInfo.MapType.STANDARD);
    }

    public GameMap(GameInfo.MapType mapType) {
        generateMap(mapType);
    }

    public void generateMap(GameInfo.MapType mapType) {
        if (mapType.equals(GameInfo.MapType.STANDARD)) {
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
