package game.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import game.core.Engine;
import game.core.GameScreen;
import game.core.Mule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class PlayerCreationController implements GameScreen {

    Engine gameEngine;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button confirmButton;

    @FXML
    private Button quitButton;

    @FXML
    void checkValues(ActionEvent event) {
        System.out.print("Cookie time");
    }

    @FXML
    void returnToMain(ActionEvent event) {
        gameEngine.setScreen(Mule.WELCOME_PAGE);
    }

    @FXML
    void initialize() {
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'playerOneConfig.fxml'.";


    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

}
