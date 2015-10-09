package game.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by The SpecialFX on 9/21/2015.
 * @author The SpecialFX
 * @version 1.0
 */
public class GameMap {

    private Tile[][] gameMap;

//    public GameMap() {
//        this("Standard");
//    }

    public GameMap(String mapType) {
        generateMap(mapType);
    }

    private void generateMap(String mapType) {
        if (mapType.equals("Standard")) {
            gameMap = new Tile[][]{
                    {new Tile("P"), new Tile("P"), new Tile("M1"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("M3"), new Tile("P"), new Tile("P")},
                    {new Tile("P"), new Tile("M1"), new Tile("P"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("M3")},
                    {new Tile("M3"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("Town"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("M1")},
                    {new Tile("P"), new Tile("M2"), new Tile("P"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("M2"), new Tile("P"), new Tile("P")},
                    {new Tile("P"), new Tile("P"), new Tile("M2"), new Tile("P"), new Tile("R"), new Tile("P"), new Tile("P"), new Tile("P"), new Tile("M2")}
            };
        } else {
            Random mapGen = new Random();
            gameMap = new Tile[5][9];
            for (int i = 0; i < gameMap.length; i++) {
                for (int j = 0; j < gameMap[i].length; j++) {
                    if (j == 4) {
                        if (i == 2) {
                            gameMap[i][j] = new Tile("Town");
                        } else {
                            gameMap[i][j] = new Tile("R");
                        }
                    } else {
                        gameMap[i][j] = new Tile("P");
                    }
                }
            }
            gameMap[0][0].setMule("Energy");

            ArrayList<Tile> leftHills = new ArrayList<>(5);
            leftHills.add(new Tile("M1"));
            leftHills.add(new Tile("M1"));
            leftHills.add(new Tile("M2"));
            leftHills.add(new Tile("M2"));
            leftHills.add(new Tile("M3"));
            ArrayList<Tile> rightHills = new ArrayList<>(5);
            rightHills.addAll(leftHills);
            int leftTile;
            int leftType;
            int rightTile;
            int rightType;
            for (int i = 0; i < gameMap.length; i++) {
                leftTile = mapGen.nextInt(4);
                leftType = mapGen.nextInt(leftHills.size());
                rightTile = mapGen.nextInt(4);
                rightType = mapGen.nextInt(rightHills.size());
                gameMap[i][leftTile] = leftHills.remove(leftType);
                gameMap[i][rightTile + 5] = rightHills.remove(rightType);
            }
        }
    }

    public void placeMule(int x, int y, String mule) {
        gameMap[x][y].setMule(mule);
    }

    public Tile getTile(int x, int y) {
        return gameMap[x][y];
    }
}
