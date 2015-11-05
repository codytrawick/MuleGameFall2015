package game.view.controllers;

import game.core.GameLogic;
import game.core.Presenters.MainScreenLogic;
import game.view.interfaces.IMainScreen;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public final class MainScreenController implements IMainScreen {
    //GameScreen instance variables
    private MainScreenLogic logic;

    //FXML Elements

    /**
     * This method changes the screen to the Game Configuration Screen
     * @param event The required event parameter
     */
    @FXML
    void startGame(ActionEvent event) {
        logic.viewUpdated();
    }

    @FXML
    void loadGame(ActionEvent event) {
        logic.loadGame();
    }

    /**
     * This method quits the game and closes the window
     * @param event The required event parameter
     */
    @FXML
    public void quitGame(ActionEvent event) {
        Platform.exit();
    }

    //GameScreen methods

    @Override
    public void initializeScreen() {
        //Nothing to initialize
    }

//    public void setEngine(Engine parent) {
//        gameEngine = parent;
//    }

    public void setGameLogic(GameLogic parent) {
        logic = (MainScreenLogic) parent;
    }
}
