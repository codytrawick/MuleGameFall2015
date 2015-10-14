package game.view.controllers;

import game.core.GameLogic;
import game.model.BuySellAction;
import game.view.interfaces.IStoreScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.HashMap;
import java.util.Map;


public class StoreScreenController implements IStoreScreen {

    private GameLogic listener;
    private String target;
    private BuySellAction action;

    @FXML
    private Label energyRemaining, foodRemaining, muleRemaining, smithoreRemaining,
            crystiteRemaining, foodPrice, energyPrice, mulePrice, orePrice, crystitePrice,
            playerFood, playerEnergy, playerOre;

    @FXML
    private Button buySmithoreButton, buyMuleButton, buyEnergyButton, buyCrystiteButton,
            buyFoodButton;

    @FXML
    private Button sellCrystiteButton, sellEnergyButton, sellFoodButton, sellSmithoreButton;

    @FXML
    private Button returnToTown;

    @FXML
    private ToggleGroup muleType;

    @FXML
    private RadioButton defaultMule;




    @FXML
    void clickBack(ActionEvent event) {
        listener.passButton();
    }

    @FXML
    void purchaseFood(ActionEvent event) {
        action = new BuySellAction("Food", true);
        listener.viewUpdated();
    }

    @FXML
    void sellFood(ActionEvent event) {
        action = new BuySellAction("Food", false);
        listener.viewUpdated();
    }

    @FXML
    void purchaseEnergy(ActionEvent event) {
        action = new BuySellAction("Energy", true);
        listener.viewUpdated();
    }

    @FXML
    void sellEnergy(ActionEvent event) {
        action = new BuySellAction("Energy", false);
        listener.viewUpdated();
    }

    @FXML
    void purchaseSmithore(ActionEvent event) {
        action = new BuySellAction("Ore", true);
        listener.viewUpdated();
    }

    @FXML
    void sellSmithore(ActionEvent event) {
        action = new BuySellAction("Ore", false);
        listener.viewUpdated();
    }

    @FXML
    void purchaseCrystite(ActionEvent event) {

    }

    @FXML
    void sellCrystite(ActionEvent event) {

    }

    @FXML
    void purchaseMULE(ActionEvent event) {
        RadioButton choice = (RadioButton) muleType.getSelectedToggle();
        String type = choice.getText().split(" ")[2];
        action = new BuySellAction("Mule:" + type, true);
        muleType.selectToggle(defaultMule);
        listener.viewUpdated();
    }

    @FXML
    void sellMULE(ActionEvent event) {

    }

    public void initializeScreen() {
        muleType.selectToggle(defaultMule);
    }

    public void setGameLogic(GameLogic parent) {
        listener = parent;
    }

    public void setStoreAmounts(Map<String, Integer> amounts) {
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

    public void setStorePrices(Map<String, Integer> prices) {
        foodPrice.setText("$" + prices.get("Food").toString());
        energyPrice.setText("$" + prices.get("Energy").toString());
        mulePrice.setText("$" + prices.get("Mule").toString());
        orePrice.setText("$" + prices.get("Ore").toString());
//        crystitePrice.setText(prices.get("Crystite").toString());
    }

    public BuySellAction getBuySellAction() {
        return action;
    }

    public void setPlayerAmounts(Map<String, Integer> amounts) {
        playerFood.setText(amounts.get("Food").toString());
        playerEnergy.setText(amounts.get("Energy").toString());
        playerOre.setText(amounts.get("Ore").toString());
    }
}
