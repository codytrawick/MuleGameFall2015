package game.controllers;

import game.core.Engine;
import game.core.GameScreen;
import game.core.Mule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

public class PlayerCreationController implements GameScreen {

    Engine gameEngine;

    @FXML
    private Label playerNumLabel;

    @FXML
    private TextField playerName;

    @FXML
    private ToggleGroup raceChoice;

    @FXML
    private ToggleGroup colorChoice;

    @FXML
    private Button confirmButton;

    @FXML
    private Button quitButton;

    @FXML
    private Toggle defaultRace;

    @FXML
    void checkValues(ActionEvent event) {
        System.out.println(playerName.getText());
        System.out.println(((RadioButton) raceChoice.getSelectedToggle()).getText());
        raceChoice.selectToggle(defaultRace);
        playerNumLabel.setText("2");
    }

    @FXML
    void returnToMain(ActionEvent event) {
        gameEngine.setScreen(Mule.WELCOME_PAGE);
    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

}