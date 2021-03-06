package game.view.controllers;

import game.core.GameLogic;
import game.core.Presenters.MapScreenLogic;
import game.model.GameMap;
import game.model.Player;
import game.view.interfaces.IMapScreen;
import game.view.interfaces.TileSelected;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This controller handles the information on the Game Map
 * It will gather information from the model to skin the tiles
 * and provide information to the presenter about what tile was clicked.
 */
public final class MapScreenController implements IMapScreen {

    // GameScreen instance variables
//    private Engine gameEngine;
    //This map will match the type of tiles to an image that corresponds to it
    private MapScreenLogic listener;
    private TileSelected lastClick;
    private Map<String, Image> tileArt = new HashMap<>();

    // FXML Elements
    @FXML
    private GridPane tiles;

    @FXML
    private Label currentPlayerName;

    @FXML
    private Label playerOneName, playerOneMoney, playerTwoName, playerTwoMoney,
            playerThreeName, playerThreeMoney, playerFourName, playerFourMoney,
            playerOneFood, playerTwoFood, playerThreeFood, playerFourFood;

    private List<Label> nameLabels = new ArrayList<>();
    private List<Label> money = new ArrayList<>();
    private List<Label> food = new ArrayList<>();


    @FXML
    private Label currentRoundNumber, timeRemaining;

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
        lastClick = new TileSelected(row, column);
        listener.viewUpdated();

    }

    /**
     * This button is the equivalent of clicking on the town. The player will
     * pass their turn
     * @param event The required event parameter
     */
    @FXML
    void onPassButton(ActionEvent event) {
        listener.passButton();
    }

    /**
     * This method is called when this controller is instantiated.
     * The map of tile art is created from the resources
     */
    @FXML
    void initialize() {
        tileArt.put("River", new Image("/default/River.jpg"));
        tileArt.put("Plains", new Image("/default/Plains.jpg"));
        tileArt.put("Town", (new Image("/default/Town.jpg")));
        tileArt.put("Mountain1", new Image("/default/Mountain1.jpg"));
        tileArt.put("Mountain2", new Image("/default/Mountain2.jpg"));
        tileArt.put("Mountain3", new Image("/default/Mountain3.jpg"));
        tileArt.put("Red", new Image("/default/redOwner.png"));
        tileArt.put("Yellow", new Image("/default/yellowOwner.png"));
        tileArt.put("Green", new Image("/default/greenOwner.png"));
        tileArt.put("Blue", new Image("/default/blueOwner.png"));
        tileArt.put("Energy", new Image("/default/Energy.png"));
        tileArt.put("Food", new Image("/default/Food.png"));
        tileArt.put("Ore", new Image("/default/Ore.png"));

        for (int index = 0; index < tiles.getChildren().size(); index++) {
            ((Button) tiles.getChildren().get(index)).setPadding(Insets.EMPTY);
            ((Button) tiles.getChildren().get(index)).setGraphic(new StackPane(new ImageView(new Image("BlankTile.jpg"))));
        }
        money.add(playerOneMoney);
        money.add(playerTwoMoney);
        money.add(playerThreeMoney);
        money.add(playerFourMoney);

        nameLabels.add(playerOneName);
        nameLabels.add(playerTwoName);
        nameLabels.add(playerThreeName);
        nameLabels.add(playerFourName);

        food.add(playerOneFood);
        food.add(playerTwoFood);
        food.add(playerThreeFood);
        food.add(playerFourFood);

        for (Label names: nameLabels) {
            names.setText("");
        }

        for (Label moneyLabel: money) {
            moneyLabel.setText("");
        }

        timeRemaining.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                if (Integer.parseInt(timeRemaining.getText()) == 0) {
                    listener.timeExpired();
                }
            }
        });
    }

//    public void setMap() {
//        for (int index = 0; index < 45; index++) {
//            Button indexedButton = (Button) tiles.getChildren().get(index);
//            Tile clickedTile = gameEngine.getGame().getMyGameMap().getTile(
//                    index / 9, index % 9);
//            ((ImageView) ((StackPane) indexedButton.getGraphic()).getChildren().get(0)).setImage(
//                    tileArt.get(clickedTile.toString()));
//        }
//    }

    public void addTileElement(String type, String color, int row, int column) {
        if (type.equals("Owner")) {
                    ((StackPane) ((Button)
                            tiles.getChildren().get(row * GameMap.MAPWIDTH + column)).getGraphic())
                    .getChildren().add(new ImageView(tileArt.get(color)));
        }
    }

    /**
     * This method goes through each button and sets the image to the
     * appropriate image from the model.
     *
     */
    public void initializeScreen() {
//        setPlayerInfo();
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

    public void setPlayerInfo(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            nameLabels.get(i).setText(players.get(i).getName());
            money.get(i).setText(String.format("$%d", players.get(i).getMoney()));
            food.get(i).setText(String.format("Food: %d", players.get(i).getFood()));
        }
    }

//    public void setEngine(Engine parent) {
//        gameEngine = parent;
//    }

    public void setGameLogic(GameLogic parent) {
        listener = (MapScreenLogic) parent;
    }

    public TileSelected lastTileClicked() {
        return lastClick;
    }

    public void setTile(String terrain, String owner, String mule, int row, int column) {
        Button target = (Button) tiles.getChildren().get(row * GameMap.MAPWIDTH + column);
        StackPane buttonGraphic = (StackPane) target.getGraphic();
        ((ImageView) buttonGraphic.getChildren().get(0)).setImage(tileArt.get(terrain));
        if (!owner.equals("None")) {
            buttonGraphic.getChildren().add(new ImageView(tileArt.get(owner)));
        }
        if (!mule.equals("")) {
            buttonGraphic.getChildren().add(new ImageView(tileArt.get(mule)));
        }
    }

    public void setRoundNumber(int number) {
        currentRoundNumber.setText(Integer.toString(number));
    }

    public void setCurrentPlayer(String player) {
        currentPlayerName.setText(player);
    }

    public void setTimerBind(IntegerProperty timeSeconds) {
        timeRemaining.textProperty().bind(timeSeconds.asString());
    }

    public void setTimerText(String timeLeft) {
        timeRemaining.setText(timeLeft);
    }

    public int timeLeft() {
        return Integer.parseInt(timeRemaining.getText());
    }
}
