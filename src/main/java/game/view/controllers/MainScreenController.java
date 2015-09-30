package game.view.controllers;

import game.core.GameLogic;
import game.core.Engine;
import game.core.Mule;
import game.core.Presenters.MainScreenLogic;
import game.view.interfaces.IMainScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MainScreenController implements IMainScreen {
    //GameScreen instance variables
    Engine gameEngine;
    MainScreenLogic logic;

    //FXML Elements

    @FXML
    private Button startButton, quitButton;

    /**
     * This method changes the screen to the Game Configuration Screen
     * @param event The required event parameter
     */
    @FXML
    void startGame(ActionEvent event) {
        logic.viewUpdated();
    }

    /**
     * This method quits the game and closes the window
     * @param event The required event parameter
     */
    @FXML
    public void quitGame(ActionEvent event) {
        System.exit(0);
    }

    //GameScreen methods

    @Override
    public void initializeScreen() {
        //Nothing to initialize
    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

    public void setGameLogic(GameLogic parent) {
        logic = (MainScreenLogic) parent;
    }
}
