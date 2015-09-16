package game.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import game.core.Engine;
import game.core.GameInfo;
import game.core.GameScreen;
import game.core.Mule;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;


public class GameConfigurationController implements GameScreen {

    Engine gameEngine;

    @FXML
    private ToggleGroup difficultyLevel;

    @FXML
    private ToggleGroup mapType;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button confirmButton;

    @FXML
    private Button quitButton;

    @FXML
    private Slider playerNum;

    @FXML
    void checkInputs(ActionEvent event) {
        gameEngine.setGame(new GameInfo(((int) playerNum.getValue())));
        gameEngine.setScreen(Mule.PLAYER_CREATION_PAGE);
    }

    @FXML
    void returnToTitle(ActionEvent event) {
        gameEngine.setScreen(Mule.WELCOME_PAGE);
    }

    @FXML
    void initialize() {
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'gameConfig.fxml'.";
        playerNum.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                playerNum.setValue((int)(newValue.doubleValue() + 0.5));
            }
        });

    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

}
