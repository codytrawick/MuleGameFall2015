package game.controllers;

import game.core.Engine;
import game.core.GameScreen;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;



public class MapScreenController implements GameScreen {

    private Engine gameEngine;

    @FXML
    private GridPane tiles;

    @FXML
    private ImageView row0col1;

    @FXML
    void doThing(ActionEvent event) {
        System.out.println("Test");
    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

}
