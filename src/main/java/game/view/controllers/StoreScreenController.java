package game.view.controllers;

import game.core.GameLogic;
import game.model.BuySellAction;
import game.model.Store;
import game.view.interfaces.IStoreScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.Map;


public final class StoreScreenController implements IStoreScreen {

    private GameLogic listener;
    private BuySellAction action;

    @FXML
    private Label energyRemaining, foodRemaining, muleRemaining, smithoreRemaining,
            crystiteRemaining, foodPrice, energyPrice, mulePrice, orePrice,
            playerFood, playerEnergy, playerOre;

    @FXML
    private Button buyCrystiteButton;

    @FXML
    private Button sellCrystiteButton;

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
        action = new BuySellAction(Store.FOOD, true);
        listener.viewUpdated();
    }

    @FXML
    void sellFood(ActionEvent event) {
        action = new BuySellAction(Store.FOOD, false);
        listener.viewUpdated();
    }

    @FXML
    void purchaseEnergy(ActionEvent event) {
        action = new BuySellAction(Store.ENERGY, true);
        listener.viewUpdated();
    }

    @FXML
    void sellEnergy(ActionEvent event) {
        action = new BuySellAction(Store.ENERGY, false);
        listener.viewUpdated();
    }

    @FXML
    void purchaseSmithore(ActionEvent event) {
        action = new BuySellAction(Store.ORE, true);
        listener.viewUpdated();
    }

    @FXML
    void sellSmithore(ActionEvent event) {
        action = new BuySellAction(Store.ORE, false);
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
        muleRemaining.setText(amounts.get(Store.MULES).toString());
        energyRemaining.setText(amounts.get(Store.ENERGY).toString());
        foodRemaining.setText(amounts.get(Store.FOOD).toString());
        smithoreRemaining.setText(amounts.get(Store.ORE).toString());
        if (amounts.get(Store.CRYSTITE) != null) {
            crystiteRemaining.setText(amounts.get(Store.CRYSTITE).toString());
        } else {
            crystiteRemaining.setText("0");
            buyCrystiteButton.setDisable(true);
            sellCrystiteButton.setDisable(true);
        }
    }

    public void setStorePrices(Map<String, Integer> prices) {
        foodPrice.setText("$" + prices.get(Store.FOOD).toString());
        energyPrice.setText("$" + prices.get(Store.ENERGY).toString());
        mulePrice.setText("$" + prices.get(Store.MULE).toString());
        orePrice.setText("$" + prices.get(Store.ORE).toString());
//        crystitePrice.setText(prices.get("Crystite").toString());
    }

    public BuySellAction getBuySellAction() {
        return action;
    }

    public void setPlayerAmounts(Map<String, Integer> amounts) {
        playerFood.setText(amounts.get(Store.FOOD).toString());
        playerEnergy.setText(amounts.get(Store.ENERGY).toString());
        playerOre.setText(amounts.get(Store.ORE).toString());
    }
}
