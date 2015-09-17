package game.controllers;

import game.core.Engine;
import game.core.GameInfo;
import game.core.GameScreen;
import game.core.Mule;
import game.core.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

public class PlayerCreationController implements GameScreen {

    Engine gameEngine;
    private int numPlayers;
    private int currentPlayer = 1;

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
    private RadioButton redColor;

    @FXML
    private RadioButton blueColor;

    @FXML
    private RadioButton greenColor;

    @FXML
    private RadioButton yellowColor;

    @FXML
    void checkValues(ActionEvent event) {
        String name = null;
        if (playerName.getText() == "") {
            return;
        } else {
            name = playerName.getText();
        }

        String color = ((RadioButton) colorChoice.getSelectedToggle()).getText();
        //disable selected color for next player

        String race = ((RadioButton) raceChoice.getSelectedToggle()).getText();
        raceChoice.selectToggle(defaultRace);

        Player player = new Player(name, color, race);
        gameEngine.getGame().addPlayer(player);

        playerNumLabel.setText(Integer.toString(Integer.parseInt(playerNumLabel.getText()) + 1));

        //debug test
        if ((Integer.parseInt(playerNumLabel.getText())) >= gameEngine.getGame().getNumOfPlayers()) {
            System.out.println(gameEngine.getGame());
            for (Player p: gameEngine.getGame().getPlayers()) {
                System.out.println(p);
            }
        }
    }

    @FXML
    void returnToMain(ActionEvent event) {
        gameEngine.getGame().resetSettings();
        gameEngine.setScreen(Mule.WELCOME_PAGE);
    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

    public void makePlayers() {
        numPlayers = gameEngine.getGame().getPlayers().length;
    }

}
