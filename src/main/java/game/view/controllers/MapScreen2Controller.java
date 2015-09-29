package game.view.controllers;

import game.core.GameLogic;
import game.view.GameScreen;
import game.core.Engine;
import game.model.Tile;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

/**
 * This controller handles the information on the Game Map
 * It will gather information from the model to skin the tiles
 * and provide information to the presenter about what tile was clicked.
 */
public class MapScreen2Controller implements GameScreen {

    // GameScreen instance variables
    private Engine gameEngine;
    //This map will match the type of tiles to an image that corresponds to it
    HashMap<String, Image> tileArt = new HashMap<>();

    // FXML Elements
    @FXML
    private GridPane tiles;

    @FXML
    private Label currentPlayerName;

    @FXML
    private Label playerOneName;

    @FXML
    private Label playerOneMoney;

    @FXML
    private Label playerTwoName;

    @FXML
    private Label playerTwoMoney;

    @FXML
    private Label playerThreeName;

    @FXML
    private Label playerThreeMoney;

    @FXML
    private Label playerFourName;

    @FXML
    private Label playerFourMoney;

    @FXML
    private Label currentRoundNumber;

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
     * the model. Note, the town tile will act as a pass button
     * @param event The required event parameter
     */
    @FXML
    void onClickOnTile(ActionEvent event) {
        int row = event.getTarget().toString().charAt(13) - 48;
        int column = event.getTarget().toString().charAt(17) - 48;
        gameEngine.getCurrentGameLogic().viewUpdated();
    }

    /**
     * This button is the equivalent of clicking on the town. The player will
     * pass their turn
     * @param event The required event parameter
     */
    @FXML
    void onPassButton(ActionEvent event) {
        gameEngine.getCurrentGameLogic().viewUpdated();
    }

    /**
     * This method is called when this controller is instantiated.
     * The map of tile art is created from the resources
     */
    @FXML
    void initialize() {
        tileArt.put("R", new Image("/default/River.jpg"));
        tileArt.put("P", new Image("/default/Plains.jpg"));
        tileArt.put("Town", (new Image("/default/Town.jpg")));
        tileArt.put("M1", new Image("/default/Mountain1.jpg"));
        tileArt.put("M2", new Image("/default/Mountain2.jpg"));
        tileArt.put("M3", new Image("/default/Mountain3.jpg"));
        tileArt.put("Red", new Image("/default/redOwner.png"));
        tileArt.put("Yellow", new Image("/default/yellowOwner.png"));
        tileArt.put("Green", new Image("/default/greenOwner.png"));
        tileArt.put("Blue", new Image("/default/blueOwner.png"));

        for (int index = 0; index < 45; index++) {
            ((Button) tiles.getChildren().get(index)).setPadding(Insets.EMPTY);
            ((Button) tiles.getChildren().get(index)).setGraphic(new StackPane(new ImageView(new Image("BlankTile.jpg"))));
        }
    }

    public void setMap() {
        for (int index = 0; index < 45; index++) {
            Button indexedButton = (Button) tiles.getChildren().get(index);
            Tile clickedTile = gameEngine.getGame().getMyGameMap().getTile(
                    index / 9, index % 9);
            ((ImageView) ((StackPane) indexedButton.getGraphic()).getChildren().get(0)).setImage(
                    tileArt.get(clickedTile.toString()));
        }
    }

    public void addTileElement(String type, String color, int row, int column) {
        if (type.equals("Owner")) {
                    ((StackPane) ((Button)
                            tiles.getChildren().get(row * 9 + column)).getGraphic())
                    .getChildren().add(new ImageView(tileArt.get(color)));
        }
    }

    /**
     * This method goes through each button and sets the image to the
     * appropriate image from the model.
     *
     */
    public void initializeScreen() {
        currentPlayerName.setText(gameEngine.getGame().getCurPlayer().getName());
        currentRoundNumber.setText("??");
        playerOneName.setText(gameEngine.getGame().getPlayerName(1));
        playerOneMoney.setText("$" + String.valueOf(gameEngine.getGame().getPlayerMoney(1)));
        playerTwoName.setText(gameEngine.getGame().getPlayerName(2));
        playerTwoMoney.setText("$" + String.valueOf(gameEngine.getGame().getPlayerMoney(2)));
        playerThreeName.setText(gameEngine.getGame().getPlayerName(3));
        playerThreeMoney.setText("$" + String.valueOf(gameEngine.getGame().getPlayerMoney(3)));
        playerFourName.setText(gameEngine.getGame().getPlayerName(4));
        playerFourMoney.setText("$" + String.valueOf(gameEngine.getGame().getPlayerMoney(4)));
        setMap();
        /*
        for (int index = 0; index < 45; index++) {
            Button indexedButton = (Button) tiles.getChildren().get(index);
            Tile clickedTile = gameEngine.getGame().getMyGameMap().getTile(
                    index / 9, index % 9);
            Player tileOwner = clickedTile.getOwner();
            String ownerString = "default";
            if (tileOwner != null) {
                ownerString = tileOwner.getColor();
            }
            ((ImageView) ((StackPane) indexedButton.getGraphic()).getChildren().get(0)).setImage(
                    colorTiles.get(ownerString).get(clickedTile.toString()));
        } */
    }

    @Override
    public void setEngine(Engine parent) {
        gameEngine = parent;
    }

    public void setGameLogic(GameLogic parent) {
        //TODO
    }

}
