package game.view.controllers;

import game.core.Presenters.LandSelection;
import game.core.Presenters.PlayerCreationLogic;
import game.core.*;
import game.model.Player;
import game.view.interfaces.IPlayerConfiguration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class PlayerCreationController implements IPlayerConfiguration {

    Engine gameEngine;
    private int currentPlayer = 1;
    private PlayerCreationLogic listener;

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

    private List<RadioButton> colorButtons = new ArrayList<>();

    @FXML
    void checkValues(ActionEvent event) {
        if (playerName.getText().trim().equals("")) {
            return;
        } else {
            listener.viewUpdated();
        }

        playerName.setText("");
        playerName.requestFocus();
//
//        String color = ((RadioButton) colorChoice.getSelectedToggle()).getText();
        //disable selected color for next player

        colorButtons.remove((RadioButton) colorChoice.getSelectedToggle());
        ((RadioButton) colorChoice.getSelectedToggle()).setDisable(true);

        raceChoice.selectToggle(defaultRace);

        if (!colorButtons.isEmpty()) {
            colorChoice.selectToggle(colorButtons.get(0));
        }

        playerNumLabel.setText(Integer.toString(Integer.parseInt(playerNumLabel.getText()) + 1));

//        //debug test
//        if ((Integer.parseInt(playerNumLabel.getText())) > gameEngine.getGame().getPlayerNumber()) {
//            System.out.println(gameEngine.getGame());
//            for (Player p: gameEngine.getGame().getPlayers()) {
//                System.out.println(p);
//            }
//
//            gameEngine.setScreen(Mule.MAP_PAGE);
//            gameEngine.setCurrentGameLogic(new LandSelection(gameEngine));
//        }
    }

    @FXML
    void returnToMain(ActionEvent event) {
        listener.passButton();
    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

    public void initializeScreen() {
        colorButtons.add(redColor);
        colorButtons.add(yellowColor);
        colorButtons.add(greenColor);
        colorButtons.add(blueColor);
        playerName.requestFocus();
    }

    public void setGameLogic(GameLogic parent) {
        listener = (PlayerCreationLogic) parent;
    }

    public String getPlayerName() {
        return playerName.getText().trim();
    }

    public String getPlayerRace() {
        return ((RadioButton) raceChoice.getSelectedToggle()).getText();
    }

    public String getPlayerColor() {
        return ((RadioButton) colorChoice.getSelectedToggle()).getText();
    }
}
