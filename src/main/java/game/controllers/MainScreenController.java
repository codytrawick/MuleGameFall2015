package game.controllers;

import game.core.Engine;
import game.core.GameScreen;
import game.core.Mule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MainScreenController implements GameScreen {
    //GameScreen instance variables
    Engine gameEngine;

    //FXML Elements

    @FXML
    private Button startButton, quitButton;

    /**
     * This method changes the screen to the Game Configuration Screen
     * @param event The required event parameter
     */
    @FXML
    void startGame(ActionEvent event) {
        gameEngine.setScreen(Mule.GAME_CONFIGURATION);
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

    @Override
    public void setEngine(Engine parent) {
        gameEngine = parent;
    }
}
