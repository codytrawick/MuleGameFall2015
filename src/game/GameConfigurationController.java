package game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class GameConfigurationController implements GameScreen {

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
    void checkInputs(ActionEvent event) {
        gameEngine.setScreen(Mule.PLAYER_CREATION_PAGE);
    }

    @FXML
    void returnToTitle(ActionEvent event) {
        gameEngine.setScreen(Mule.WELCOME_PAGE);
    }

    @FXML
    void initialize() {
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'gameConfig.fxml'.";


    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

}
