package game.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

/**
 * This class represents our Game Engine. The Game Engine manages screens in the
 * game and switches between them. Screens must be loaded before the game
 * can display them.
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class Engine extends StackPane {

    GameInfo game;

    private HashMap<String, Node> gameScreens = new HashMap<String, Node>();

    /**
     * This method adds a loaded screen to our game.
     * @param name The name of the screen
     * @param screen The loaded screen
     */
    private void addScreen(String name, Node screen) {
        gameScreens.put(name, screen);
    }

    /**
     * This method loads a screen to the game.
     * @param name The name of the target screen
     * @param fxlmresourceName The fxml file that controls the screen's layout
     */
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

    /**
     * This method displays a loaded screen and removes the old screen
     * @param name The target screen to display
     */
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

    public GameInfo getGame() {
        return game;
    }

    public void setGame(GameInfo game) {
        this.game = game;
    }
}
