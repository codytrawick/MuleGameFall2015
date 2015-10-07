package game.view.controllers;

import game.core.GameLogic;
import game.core.Presenters.TownLogic;
import game.view.GameScreen;
import game.core.Engine;
import game.core.Mule;
import game.view.interfaces.IStoreScreen;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class StoreScreenController implements IStoreScreen {

    @FXML
    private Label energyRemaining, foodRemaining, muleRemaining, smithoreRemaining,
            crystiteRemaining;

    @FXML
    private Button buySmithoreButton, buyMuleButton, buyEnergyButton, buyCrystiteButton,
            buyFoodButton;

    @FXML
    private Button sellCrystiteButton, sellEnergyButton, sellFoodButton, sellMuleButton,
            sellSmithoreButton;

    @FXML
    private Button returnToTown;




    @FXML
    void clickBack(ActionEvent event) {

    }

    @FXML
    void purchaseFood(ActionEvent event) {

    }

    @FXML
    void sellFood(ActionEvent event) {

    }

    @FXML
    void purchaseEnergy(ActionEvent event) {

    }

    @FXML
    void sellEnergy(ActionEvent event) {

    }

    @FXML
    void purchaseSmithore(ActionEvent event) {

    }

    @FXML
    void sellSmithore(ActionEvent event) {

    }

    @FXML
    void purchaseCrystite(ActionEvent event) {

    }

    @FXML
    void sellCrystite(ActionEvent event) {

    }

    @FXML
    void purchaseMULE(ActionEvent event) {

    }

    @FXML
    void sellMULE(ActionEvent event) {

    }

    public void initializeScreen() {

    }

    public void setGameLogic(GameLogic parent) {

    }

}
