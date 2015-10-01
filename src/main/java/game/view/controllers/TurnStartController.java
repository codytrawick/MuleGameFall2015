package game.view.controllers;

import game.core.GameLogic;
import game.core.Presenters.RoundLogic;
import game.view.interfaces.ITurnStart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TurnStartController implements ITurnStart {

    private RoundLogic listener;

    @FXML
    private Label roundNumberLabel, playerTurnLabel;

    @FXML
    private Button startButton;

    @FXML
    void buttonClick(ActionEvent event) {
        listener.viewUpdated();
    }

    public void setPlayerName(String name) {
        playerTurnLabel.setText(name);
    }

    public void setRoundText(String newText) {
        roundNumberLabel.setText(newText);
    }

    public void initializeScreen() {

    }

    public void setGameLogic(GameLogic parent) {
        listener = (RoundLogic) parent;
    }

}
