package game.view.controllers;


import game.core.GameLogic;
import game.view.interfaces.ITownScreen;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public final class TownScreenController implements ITownScreen {

    private GameLogic listener;
    private String target;

    @FXML
    private Label timeLeft;

    @FXML
    void clickBack(ActionEvent event) {

        listener.passButton();

    }

    @FXML
    void clickPub(ActionEvent event) {
        target = "Pub";
        listener.viewUpdated();
    }

    @FXML
    void clickLandOffice(ActionEvent event) {
        target = "Land Office";
        listener.viewUpdated();
    }

    @FXML
    void clickAssay(ActionEvent event) {
        target = "Assay"; //??
        listener.viewUpdated();
    }

    @FXML
    void clickStore(ActionEvent event) {
        target = "Store";
        listener.viewUpdated();
    }

    public void initializeScreen() {

    }

    public void setGameLogic(GameLogic parent) {
        listener = parent;
    }

    public String getTargetLocation() {
        return target;
    }

    public void setTimerBind(IntegerProperty timeSeconds) {
        timeLeft.textProperty().bind(timeSeconds.asString());
    }


}
