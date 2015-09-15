package game;

import java.net.URL;
import java.util.ResourceBundle;

import game.core.Engine;
import game.core.GameScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.text.Text;


public class PlayerController implements GameScreen {

    Engine gameEngine;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text numPlayers;

    @FXML
    private Slider playerCount;


    @FXML
    void updatePlayerCount(DragEvent event) {
        numPlayers.setText("Test");
    }

    @FXML
    void initialize() {
        assert numPlayers != null : "fx:id=\"numPlayers\" was not injected: check your FXML file 'differentScreen.fxml'.";
        assert playerCount != null : "fx:id=\"playerCount\" was not injected: check your FXML file 'differentScreen.fxml'.";


    }

    @Override
    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

}
