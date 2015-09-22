package game.controllers;

import game.core.Engine;
import game.core.GameScreen;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;

import javafx.scene.Group;

import java.util.HashMap;


public class MapScreenController implements GameScreen {

    HashMap<String, Image> tileArt = new HashMap<>();
    private Engine gameEngine;

    @FXML
    private GridPane tiles;

    @FXML
    private Button row0col0, row0col1, row0col2, row0col3, row0col4, row0col5,
            row0col6, row0col7, row0col8, row1col0, row1col1, row1col2,
            row1col3, row1col4, row1col5, row1col6, row1col7, row1col8,
            row2col0, row2col1, row2col2, row2col3, row2col4, row2col5,
            row2col6, row2col7, row2col8, row3col0, row3col1, row3col2,
            row3col3, row3col4, row3col5, row3col6, row3col7, row3col8,
            row4col0, row4col1, row4col2, row4col3, row4col4, row4col5,
            row4col6, row4col7, row4col8;

    @FXML
    void doThing(ActionEvent event) {
        System.out.print(event.getTarget().toString().charAt(13));
        System.out.print(event.getTarget().toString().charAt(17));
        System.out.println(gameEngine.getGame().getMyGameMap().getTile(
                event.getTarget().toString().charAt(13) - 48,
                event.getTarget().toString().charAt(17) - 48));
    }

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }



    public void initializeScreen() {
        tileArt.put("R", new Image("/default/River.jpg"));
        tileArt.put("P", new Image("/default/Plains.jpg"));
        tileArt.put("Town", new Image("/default/Town.jpg"));
        tileArt.put("M1", new Image("/default/Mountain.jpg"));
        tileArt.put("M2", new Image("/default/Mountain.jpg"));
        tileArt.put("M3", new Image("/default/Mountain.jpg"));
        for (int index = 0; index < 45; index++) {
            ((Button) tiles.getChildren().get(index)).setPadding(Insets.EMPTY);
            ((Button) tiles.getChildren().get(index)).setGraphic(new ImageView(
                    tileArt.get(gameEngine.getGame().getMyGameMap().getTile(index / 9, index % 9).toString())));
        }
    }

}
