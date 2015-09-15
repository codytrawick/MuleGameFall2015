package game.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import game.core.Engine;
import game.core.GameScreen;
import game.core.Mule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MainScreenController implements GameScreen {
    Engine gameEngine;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button startButton;

    @FXML
    private Button quitButton;

    @FXML
    public void quitGame(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    void testWhip(ActionEvent event) {
        System.out.println("Test");
        gameEngine.setScreen(Mule.GAME_CONFIGURATION);
    }

    @FXML
    void initialize() {
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'startScreen.fxml'.";


    }

    @Override
    public void setEngine(Engine parent) {
        gameEngine = parent;
    }
}
