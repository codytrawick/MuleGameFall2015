package game.core.Presenters;
import game.core.Engine;
import game.core.GameLogic;
import game.model.IModel;
import game.view.GameScreen;
import game.view.controllers.LandSelectionController;
import game.model.Player;
import game.model.Tile;
import game.view.interfaces.ILandSelection;
import game.view.interfaces.TileSelected;

public class LandSelection extends GameLogic {

    private Player[] players ;
    private Player currentPlayer;
    private Engine gameEngine;
    private int roundNum = 0;
    private int playerNum = 0;
    private boolean passStreak = true;
    private ILandSelection view;


//    public LandSelection(Engine gameEngine) {
//        this.gameEngine = gameEngine;
//        players = gameEngine.getGame().getPlayers();
//    }

    public LandSelection(ILandSelection view, IModel model) {
        super(model);
        this.view = view;

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
        if (playerNum < gameModel.getPlayerNumber() - 1) {
            currentPlayer = players[++playerNum];
//            gameEngine.getGame().setCurPlayer(players[playerNum]);
        } else {
            roundNum++;
            if (passStreak) {
                endLandSelectionPhase();
            }
            passStreak = true;
            currentPlayer = players[0];
            playerNum = 0;
        }
        view.setPlayerText(String.format("%s : $%d", currentPlayer, currentPlayer.getMoney()));

    }

    public void setView(GameScreen view) {
        this.view = (LandSelectionController) view;
    }

    private void endLandSelectionPhase() {
//        gameEngine.setScreen(Mule.MAP2SCREEN);
//        gameEngine.setCurrentGameLogic(new RoundLogic(gameEngine, 1));
//        view.removePassButton();
        System.out.printf("End");
    }

    public void viewUpdated() {
        TileSelected target = view.playerClickMap();
        String owner = gameModel.getTileOwner(target.getX(), target.getY());
        if (owner.equals("None")) {
            if (roundNum < 2) {
                view.addTileElement("Owner", currentPlayer.getColor(), target.getX(), target.getY());
                gameModel.setTileOwner(target.getX(), target.getY(), currentPlayer);
                passStreak = false;
                nextPlayer();
            } else if (currentPlayer.getMoney() >= 300) {
                view.addTileElement("Owner", currentPlayer.getColor(), target.getX(), target.getY());
                gameModel.setTileOwner(target.getX(), target.getY(), currentPlayer);
                passStreak = false;
                nextPlayer();
                currentPlayer.spendMoney(300);
            }
        }
    }

    public void passButton() {
        nextPlayer();
    }

    public void primeScreen() {
        for (int row = 0, col = 0; row < 5; col++) {
            view.setTerrain(row, col, gameModel.getTileTerrain(row, col));
            if (col == 8) {
                row++;
                col = -1;
            }
        }
        players = gameModel.getPlayers();
        currentPlayer = players[0];
        view.setPlayerText(String.format("%s : $%d", currentPlayer, currentPlayer.getMoney()));
    }
}
