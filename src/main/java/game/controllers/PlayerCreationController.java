package game.controllers;

import game.core.*;
import game.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

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

    private ArrayList<RadioButton> colorButtons = new ArrayList<RadioButton>();

    @FXML
    void checkValues(ActionEvent event) {
        String name = null;
        if (playerName.getText().trim().equals("")) {
            return;
        } else {
            name = playerName.getText().trim();
        }

        playerName.setText("");

        String color = ((RadioButton) colorChoice.getSelectedToggle()).getText();
        //disable selected color for next player

        colorButtons.remove(colorChoice.getSelectedToggle());
        ((RadioButton) colorChoice.getSelectedToggle()).setDisable(true);

        String race = ((RadioButton) raceChoice.getSelectedToggle()).getText();
        raceChoice.selectToggle(defaultRace);

        if (!colorButtons.isEmpty()) {
            colorChoice.selectToggle(colorButtons.get(0));
        }

        Player player = new Player(name, color, race);
        gameEngine.getGame().addPlayer(player);

        playerNumLabel.setText(Integer.toString(Integer.parseInt(playerNumLabel.getText()) + 1));

        //debug test
        if ((Integer.parseInt(playerNumLabel.getText())) > gameEngine.getGame().getNumOfPlayers()) {
            System.out.println(gameEngine.getGame());
            for (Player p: gameEngine.getGame().getPlayers()) {
                System.out.println(p);
            }

            gameEngine.setScreen(Mule.MAP_PAGE);
            gameEngine.setCurrentGameLogic(new LandSelection(gameEngine));
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

    public void initializeScreen() {
        colorButtons.add(redColor);
        colorButtons.add(yellowColor);
        colorButtons.add(greenColor);
        colorButtons.add(blueColor);
    }

    public void makePlayers() {
        numPlayers = gameEngine.getGame().getPlayers().length;
    }

}
