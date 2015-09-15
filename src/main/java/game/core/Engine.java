package game.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

/**
 * Created by Cody on 9/13/2015.
 */
public class Engine extends StackPane {
    private HashMap<String, Node> gameScreens = new HashMap<String, Node>();

    private void addScreen(String name, Node screen) {
        gameScreens.put(name, screen);
    }

    public void loadScreen(String name, String fxlmresourceName) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(fxlmresourceName));
            Node loadedScreen = (Node) loader.load();
            GameScreen targetScene = loader.getController();
            targetScene.setEngine(this);
            addScreen(name, loadedScreen);
        } catch (java.io.IOException e) {
            System.out.println("Oops");
        }
    }

    public void setScreen(String name) {
        if (gameScreens.get(name) != null) {
            if (!getChildren().isEmpty()) {
                getChildren().remove(0);
                getChildren().add(0, gameScreens.get(name));
            } else {
                getChildren().add(0, gameScreens.get(name));
            }
        } else {
            System.out.print("Problem setting screen");
        }
    }
}
