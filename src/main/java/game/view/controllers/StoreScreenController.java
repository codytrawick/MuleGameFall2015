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

import java.util.HashMap;


public class StoreScreenController implements IStoreScreen {

    GameLogic listener;

    @FXML
    private Label energyRemaining, foodRemaining, muleRemaining, smithoreRemaining,
            crystiteRemaining, foodPrice, energyPrice, mulePrice, orePrice, crystitePrice;

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
        listener.passButton();
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
        listener = parent;
    }

    public void setStoreAmounts(HashMap<String, Integer> amounts) {
        muleRemaining.setText(amounts.get("Mules").toString());
        energyRemaining.setText(amounts.get("Energy").toString());
        foodRemaining.setText(amounts.get("Food").toString());
        smithoreRemaining.setText(amounts.get("Ore").toString());
        try {
            crystiteRemaining.setText(amounts.get("Crystie").toString());
        } catch (NullPointerException e) {
            crystiteRemaining.setText("0");
            buyCrystiteButton.setDisable(true);
            sellCrystiteButton.setDisable(true);
        }
    }

    public void setStorePrices(HashMap<String, Integer> prices) {
        foodPrice.setText(prices.get("Food").toString());
        energyPrice.setText(prices.get("Energy").toString());
        mulePrice.setText(prices.get("Mule").toString());
        orePrice.setText(prices.get("Ore").toString());
        crystitePrice.setText(prices.get("Crystite").toString());
    }

}
