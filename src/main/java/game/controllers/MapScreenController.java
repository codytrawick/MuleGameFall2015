package game.controllers;

import game.core.Engine;
import game.core.GameScreen;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import java.util.HashMap;

/**
 * This controller handles the information on the Game Map
 * It will gather information from the model to skin the tiles
 * and provide information to the presenter about what tile was clicked.
 */
public class MapScreenController implements GameScreen {

    // GameScreen instance variables
    private Engine gameEngine;
    //This map will match the type of tiles to an image that corresponds to it
    HashMap<String, Image> tileArt = new HashMap<>();

    // FXML Elements
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

    /**
     * This method is called whenever a tile is clicked.
     * Currently it prints out the tile's coordinates and the Tile Type from
     * the model
     * @param event The required event parameter
     */
    @FXML
    void onClickOnTile(ActionEvent event) {
        System.out.print(event.getTarget().toString().charAt(13));
        System.out.print(event.getTarget().toString().charAt(17));
        System.out.println(gameEngine.getGame().getMyGameMap().getTile(
                event.getTarget().toString().charAt(13) - 48,
                event.getTarget().toString().charAt(17) - 48));
    }

    /**
     * This method is called when this controller is instantiated.
     * The map of tile art is created from the resources
     */
    @FXML
    void initialize() {
        tileArt.put("R", new Image("/default/River.jpg"));
        tileArt.put("P", new Image("/default/Plains.jpg"));
        tileArt.put("Town", new Image("/default/Town.jpg"));
        tileArt.put("M1", new Image("/default/Mountain.jpg"));
        tileArt.put("M2", new Image("/default/Mountain.jpg"));
        tileArt.put("M3", new Image("/default/Mountain.jpg"));
    }

    /**
     * This method goes through each button and sets the image to the
     * appropriate image from the model.
     *
     */
    public void initializeScreen() {

        for (int index = 0; index < 45; index++) {
            ((Button) tiles.getChildren().get(index)).setPadding(Insets.EMPTY);
            ((Button) tiles.getChildren().get(index)).setGraphic(new ImageView(
                    tileArt.get(gameEngine.getGame().getMyGameMap().getTile(
                            index / 9, index % 9).toString())));
        }
    }


    @Override
    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

}
