package game.view.controllers;


import game.core.Presenters.ConfigurationLogic;
import game.core.GameLogic;
import game.core.Engine;
import game.view.interfaces.IGameConfiguration;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;

/**
 * This controller handles the game configuration screen.
 * The game configuration will gain important information about the game
 * then create the game and start the player configuration process.
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class GameConfigurationController implements IGameConfiguration {

    //GameScreen instance variables
    private ConfigurationLogic listener;

    //FXML Elements
    @FXML
    private ToggleGroup difficultyLevel, mapType;

    @FXML
    private Button confirmButton;

    @FXML
    private Slider playerNum;

    /**
     * This methods will check the inputs on the screen and make the game
     * Then the screen is change to the player configuration screen
     * @param event The required event parameter
     */
    @FXML
    void checkInputs(ActionEvent event) {
        listener.viewUpdated();

        //System.out.println(gameEngine.getGame());
    }

    /**
     * This method is called when the quit button is pressed. It will return
     * the player to the main menu
     * @param event The required event parameter
     */
    @FXML
    void returnToTitle(ActionEvent event) {
        //gameEngine.getGame().resetSettings(); Not needed. Game is already null!!!
        listener.passButton();
    }

    /**
     * This method will modify the slider to affix itself to integer values
     */
    @FXML
    void initialize() {
        playerNum.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                playerNum.setValue((int) (newValue.doubleValue() + 0.5));
            }
        });

    }

    /**
     * The Game Configuration Screen has default values for the map type and
     * level
     */
    public void initializeScreen() {
        difficultyLevel.selectToggle(difficultyLevel.getToggles().get(0));
        mapType.selectToggle(mapType.getToggles().get(0));
        playerNum.adjustValue(1);
        confirmButton.requestFocus();
    }

    @Override
    public void setGameLogic(GameLogic presenter) {
        listener = (ConfigurationLogic) presenter;
    }

    /*
     public void setEngine(Engine parent) {
     gameEngine = parent;
     }
     */

    public String getDifficulty() {
        return ((RadioButton) difficultyLevel.getSelectedToggle()).getText();
    }

    public String getMapType() {
        return ((RadioButton) mapType.getSelectedToggle()).getText();

    }

    public int getPlayerNumber() {
        return (int) playerNum.getValue();
    }

}
