package game.controllers;

import game.core.Engine;
import game.core.GameScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MapScreenController implements GameScreen {

    private Engine gameEngine;

    @FXML
    private ImageView row0col0;

    @FXML
    void setImage(ActionEvent event) {
        row0col0.setImage(new Image("/BlankTile.jpg"));
    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

}
