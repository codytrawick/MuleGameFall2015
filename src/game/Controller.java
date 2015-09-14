package game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Controller implements GameScreen {
    Engine gameEngine;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button startButton;


    @FXML
    void testWhip(ActionEvent event) {
        System.out.println("Test");
        gameEngine.setScreen(Mule.PLAYER_CREATION_PAGE);
    }

    @FXML
    void initialize() {
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'startScreen.fxml'.";


    }

    @Override
    public void setEngine(Engine parent) {
        gameEngine = parent;
    }
}
