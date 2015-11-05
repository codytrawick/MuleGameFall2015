package game.view.controllers;

import game.core.GameLogic;
import game.core.Presenters.RoundLogic;
import game.view.interfaces.ITurnStart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public final class TurnStartController implements ITurnStart {

    @FXML
    private Button saveButton;

    private RoundLogic listener;

    @FXML
    private Label roundNumberLabel, playerTurnLabel, randomEventText, pubMoneyText;

    @FXML
    void buttonClick(ActionEvent event) {
        listener.viewUpdated();
    }

    @FXML
    void saveButtonClick(ActionEvent event) {
        listener.saveGame();
    }

    public void setPlayerName(String name) {
        playerTurnLabel.setText(name);
    }

    public void setRandomEventText(String name) {
        randomEventText.setText(name);
    }

    public void setPubMoney(String amount) {
        pubMoneyText.setText(amount);
    }

    public void setRoundText(String newText) {
        roundNumberLabel.setText(newText);
    }

    public void setSaveButton(boolean status) {
        saveButton.setDisable(status);
    }

    public void initializeScreen() {

    }

    public void setGameLogic(GameLogic parent) {
        listener = (RoundLogic) parent;
    }

}
