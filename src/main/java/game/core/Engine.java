package game.core;

import game.core.Presenters.ConfigurationLogic;
import game.core.Presenters.MainScreenLogic;
import game.view.GameScreen;
import game.model.GameInfo;
import game.view.interfaces.IGameConfiguration;
import game.view.interfaces.IMainScreen;
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
    //The game Engine has a single game reference
    GameInfo game = new GameInfo();
    GameLogic currentGameLogic;

    //The Game Engine has references to the screens and their controllers
    private HashMap<String, Node> gameScreens = new HashMap<>();
    private HashMap<String, GameScreen> controllers = new HashMap<>();
    private HashMap<String, GameLogic> logic = new HashMap<>();

    /**
     * This method adds a loaded screen to our game.
     * @param name The name of the screen
     * @param screen The loaded screen
     */
    private void addScreen(String name, Node screen) {
        gameScreens.put(name, screen);
        if (name.equals(Mule.GAME_CONFIGURATION)) {
            logic.put(Mule.GAME_CONFIGURATION, new ConfigurationLogic((IGameConfiguration) screen, game));
        } else if (name.equals(Mule.WELCOME_PAGE)) {
            logic.put(Mule.WELCOME_PAGE, new MainScreenLogic((IMainScreen) screen, game));
        }
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
            Node loadedScreen = loader.load();
            GameScreen targetScene = loader.getController();
            targetScene.setEngine(this);

            controllers.put(name, targetScene);
            addScreen(name, loadedScreen);
        } catch (java.io.IOException e) {
            e.printStackTrace();
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
                controllers.get(name).initializeScreen();
            } else {
                getChildren().add(0, gameScreens.get(name));
                controllers.get(name).initializeScreen();
            }
        } else {
            System.out.print("Problem setting screen");
        }
    }

    /**
     * This method returns the engine's game
     * @return The game associated with the engine
     */
    public GameInfo getGame() {
        return game;
    }

    /**
     * This method sets the engine's game. Used for creating a new game
     * or loading an old game
     * @param game The new game for the engine
     */
    public void setGame(GameInfo game) {
        this.game = game;
    }

    public GameLogic getCurrentGameLogic() {
        return currentGameLogic;
    }

    public void setCurrentGameLogic(GameLogic newThing) {
        currentGameLogic = newThing;
    }

    public void setCurrentGameLogic(String newLogic) {
        currentGameLogic = logic.get(newLogic);
        setScreen(newLogic);
    }
}
