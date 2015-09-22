package game.controllers;

import game.core.Engine;
import game.core.GameScreen;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;

import javafx.scene.Group;


public class MapScreenController implements GameScreen {

    private Engine gameEngine;

    @FXML
    private GridPane tiles;

    @FXML
    private Button row0col1;

    @FXML
    void doThing(ActionEvent event) {
        System.out.print(((Button) event.getTarget()).toString());
    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
        row0col1.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/BlankTile.jpg"))));
        row0col1.setPadding(Insets.EMPTY);
    }

}
