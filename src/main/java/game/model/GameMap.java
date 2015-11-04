package game.model;

import game.model.tile.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by The SpecialFX on 9/21/2015.
 * @author The SpecialFX
 * @version 1.0
 */
public class GameMap implements Serializable {

    private Tile[][] gameMap;

    public static final int MAPWIDTH = 9;
    public static final int MAPHEIGHT = 5;

//    public GameMap() {
//        this("Standard");
//    }

    public GameMap(String mapType) {
        generateMap(mapType);
    }

    private void generateMap(String mapType) {
        if (mapType.equals("Standard")) {
            gameMap = new Tile[][]{
                    {new Plain(), new Plain(), new Mountain1(), new Plain(), new River(), new Plain(), new Mountain3(), new Plain(), new Plain()},
                    {new Plain(), new Mountain1(), new Plain(), new Plain(), new River(), new Plain(), new Plain(), new Plain(), new Mountain3()},
                    {new Mountain3(), new Plain(), new Plain(), new Plain(), new Town(), new Plain(), new Plain(), new Plain(), new Mountain1()},
                    {new Plain(), new Mountain2(), new Plain(), new Plain(), new River(), new Plain(), new Mountain2(), new Plain(), new Plain()},
                    {new Plain(), new Plain(), new Mountain2(), new Plain(), new River(), new Plain(), new Plain(), new Plain(), new Mountain2()}
            };
        } else {
            Random mapGen = new Random();
            gameMap = new Tile[MAPHEIGHT][MAPWIDTH];
            for (int i = 0; i < gameMap.length; i++) {
                for (int j = 0; j < gameMap[i].length; j++) {
                    if (j == 4) { //Town Location
                        if (i == 2) { //Town location
                            gameMap[i][j] = new Town();
                        } else {
                            gameMap[i][j] = new River();
                        }
                    } else {
                        gameMap[i][j] = new Plain();
                    }
                }
            }

            ArrayList<Tile> leftHills = new ArrayList<>(MAPHEIGHT);
            leftHills.add(new Mountain1());
            leftHills.add(new Mountain1());
            leftHills.add(new Mountain2());
            leftHills.add(new Mountain2());
            leftHills.add(new Mountain3());
            ArrayList<Tile> rightHills = new ArrayList<>(MAPHEIGHT);
            rightHills.addAll(leftHills);
            int leftTile;
            int leftType;
            int rightTile;
            int rightType;
            for (int i = 0; i < gameMap.length; i++) {
                leftTile = mapGen.nextInt(MAPWIDTH / 2);
                leftType = mapGen.nextInt(leftHills.size());
                rightTile = mapGen.nextInt(MAPWIDTH / 2);
                rightType = mapGen.nextInt(rightHills.size());
                gameMap[i][leftTile] = leftHills.remove(leftType);
                gameMap[i][rightTile + MAPWIDTH / 2 + 1] = rightHills.remove(rightType);
            }
        }
    }

    public void placeMule(int x, int y, String mule) {
        gameMap[x][y].setMule(mule);
    }

    public Tile getTile(int x, int y) {
        return gameMap[x][y];
    }

    /*public void produceStuff() {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                if (gameMap[i][j].isOwned()) {
                    gameMap[i][j].produceStuff();
                }
            }
        }
    } */
}
