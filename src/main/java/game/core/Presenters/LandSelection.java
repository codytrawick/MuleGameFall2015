package game.core.Presenters;
import game.core.Engine;
import game.core.GameLogic;
import game.core.Mule;
import game.core.RoundLogic;
import game.model.IModel;
import game.view.GameScreen;
import game.view.controllers.MapScreenController;
import game.model.Player;
import game.model.Tile;

public class LandSelection extends GameLogic {

    private Player[] players ;
    private Engine gameEngine;
    private int roundNum = 0;
    private int playerNum = 0;
    private boolean passStreak = true;
    private MapScreenController view;


//    public LandSelection(Engine gameEngine) {
//        this.gameEngine = gameEngine;
//        players = gameEngine.getGame().getPlayers();
//    }

    public LandSelection(GameScreen view, IModel model) {
        super(model);

    }

    public void executeAuction() {
        boolean[] playerPassed = new boolean[gameEngine.getGame().getPlayers().length];
        for (int i = 0; i < gameEngine.getGame().getPlayers().length; i++) {
            //playerPassed[i] = executeTurn(players[i]);
        }
    }

    //Need to fill this out to actually have the current player do stuff
    public boolean executeTurn(Player curPlayer) {
        return false;
    }

    public void checkView(int row, int column) {
        Tile clickedTile = gameEngine.getGame().getMyGameMap().getTile(row, column);
        if (row == 2 && column == 4) {
            nextPlayer();
        } else if (roundNum < 2) {
            if (clickedTile.getOwner() == null) {
                passStreak = false;
                clickedTile.setOwner(gameEngine.getGame().getCurPlayer());
                view.addTileElement("Owner", gameEngine.getGame().getCurPlayer().getColor(), row, column);
                nextPlayer();
            }
        } else {
            if (clickedTile.getOwner() == null) {
                if (gameEngine.getGame().getCurPlayer().getMoney() >= 300) {
                    gameEngine.getGame().getCurPlayer().spendMoney(300);
                    passStreak = false;
                    clickedTile.setOwner(gameEngine.getGame().getCurPlayer());
                    view.addTileElement("Owner", gameEngine.getGame().getCurPlayer().getColor(), row, column);
                    nextPlayer();
                }
            }
        }
        view.initializeScreen();
    }

    private void nextPlayer() {
        if (playerNum < gameEngine.getGame().getPlayerNumber() - 1) {
            playerNum++;
            gameEngine.getGame().setCurPlayer(players[playerNum]);
        } else {
            roundNum++;
            if (passStreak) {
                endLandSelectionPhase();
            }
            passStreak = true;
            playerNum = 0;
            gameEngine.getGame().setCurPlayer(players[playerNum]);
        }
    }

    public void setView(GameScreen view) {
        this.view = (MapScreenController) view;
    }

    private void endLandSelectionPhase() {
//        gameEngine.setScreen(Mule.MAP2SCREEN);
//        gameEngine.setCurrentGameLogic(new RoundLogic(gameEngine, 1));
        view.removePassButton();
    }

    public void viewUpdated() {

    }

    public void passButton() {

    }

    public void primeScreen() {
//        la.initializeScreen();
    }
}
