package game.view.controllers;


import game.core.GameLogic;
import game.view.GameScreen;
import game.core.Engine;
import game.core.Mule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TownScreenController implements GameScreen {

    private Engine gameEngine;

    @FXML
    private Button landOffice;

    @FXML
    private Button assayOffice;

    @FXML
    private Button store;

    @FXML
    private Button returnButton;

    @FXML
    private Button pub;

    @FXML
    void clickBack(ActionEvent event) {

        gameEngine.setScreen(Mule.MAP2SCREEN);

    }

    @FXML
    void clickPub(ActionEvent event) {

    }

    @FXML
    void clickLandOffice(ActionEvent event) {

    }

    @FXML
    void clickAssay(ActionEvent event) {

    }

    @FXML
    void clickStore(ActionEvent event) {

    }

    public void setEngine(Engine newEngine) {
        gameEngine = newEngine;
    }

    public void initializeScreen() {

    }

    public void setGameLogic(GameLogic parent) {
        //TODO
    }

}
