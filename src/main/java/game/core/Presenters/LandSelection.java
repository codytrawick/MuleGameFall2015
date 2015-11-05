package game.core.Presenters;

import game.core.GameLogic;
import game.core.Mule;
import game.model.GameMap;
import game.model.IModel;
import game.view.GameScreen;
import game.view.controllers.LandSelectionController;
import game.model.Player;
import game.view.interfaces.ILandSelection;
import game.view.interfaces.TileSelected;


import java.util.List;

/**
 * This class is a Presenter for the Land Selection Screen
 * @author The SpecialFX
 */
public final class LandSelection extends GameLogic {

    private List<Player> players ;
    private int roundNum = 0;
    private int playerNum = 0;
    private boolean passStreak = true;
    private ILandSelection view;

    public static final int LANDPRICE = 300;


//    public LandSelection(Engine gameEngine) {
//        this.gameEngine = gameEngine;
//        players = gameEngine.getGame().getPlayers();
//    }

    public LandSelection(ILandSelection newView, IModel model) {
        super(model);
        this.view = newView;

        this.view.setGameLogic(this);

    }

//    public void checkView(int row, int column) {
//        Tile clickedTile = gameEngine.getGame().getMyGameMap().getTile(row, column);
//        if (row == 2 && column == 4) {
//            nextPlayer();
//        } else if (roundNum < 2) {
//            if (clickedTile.getOwner() == null) {
//                passStreak = false;
//                clickedTile.setOwner(gameEngine.getGame().getCurPlayer());
//                view.addTileElement("Owner", gameEngine.getGame().getCurPlayer().getColor(), row, column);
//                nextPlayer();
//            }
//        } else {
//            if (clickedTile.getOwner() == null) {
//                if (gameEngine.getGame().getCurPlayer().getMoney() >= 300) {
//                    gameEngine.getGame().getCurPlayer().spendMoney(300);
//                    passStreak = false;
//                    clickedTile.setOwner(gameEngine.getGame().getCurPlayer());
//                    view.addTileElement("Owner", gameEngine.getGame().getCurPlayer().getColor(), row, column);
//                    nextPlayer();
//                }
//            }
//        }
//        view.initializeScreen();
//    }

    private void nextPlayer() {
        if (playerNum < getGameModel().getPlayerNumber() - 1) {
            ++playerNum;
//            gameEngine.getGame().setCurPlayer(players[playerNum]);
        } else {
            roundNum++;
            if (passStreak) {
                endLandSelectionPhase();
            }
            passStreak = true;
            playerNum = 0;
        }
        view.setPlayerText(String.format("%s : $%d", players.get(playerNum),
                players.get(playerNum).getMoney()));

    }

    public void setView(GameScreen newView) {
        this.view = (LandSelectionController) newView;
    }

    private void endLandSelectionPhase() {
//        gameEngine.setScreen(Mule.MAP2SCREEN);
//        gameEngine.setCurrentGameLogic(new RoundLogic(gameEngine, 1));
//        view.removePassButton();
        getGameModel().createRound(1);
        getGameEngine().setCurrentGameLogic(Mule.ROUNDSTART);
    }

    public void viewUpdated() {
        TileSelected target = view.lastTileClicked();
        String owner = getGameModel().getTileOwner(target.getX(), target.getY());
        if (owner.equals("None")) {
            if (roundNum < 2) {
                view.addTileElement("Owner", players.get(playerNum).getColor(),
                        target.getX(), target.getY());
                getGameModel().setTileOwner(target.getX(), target.getY(),
                        players.get(playerNum));
                passStreak = false;
                nextPlayer();
            } else if (players.get(playerNum).spendMoney(LANDPRICE)) {
                view.addTileElement("Owner", players.get(playerNum).getColor(),
                        target.getX(), target.getY());
                getGameModel().setTileOwner(target.getX(), target.getY(),
                        players.get(playerNum));
                passStreak = false;
                nextPlayer();
            }
        }
    }

    public void passButton() {
        nextPlayer();
    }

    public void primeScreen() {
        for (int row = 0, col = 0; row < GameMap.MAPHEIGHT; col++) {
            view.setTerrain(row, col, getGameModel().getTileTerrain(row, col));
            if (col == GameMap.MAPWIDTH - 1) {
                row++;
                col = -1;
            }
        }
        players = getGameModel().getPlayers();
        view.setPlayerText(String.format("%s : $%d", players.get(playerNum),
                players.get(playerNum).getMoney()));
    }
}
