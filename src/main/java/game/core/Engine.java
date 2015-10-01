package game.core;

import game.core.Presenters.ConfigurationLogic;
import game.core.Presenters.MainScreenLogic;
import game.core.Presenters.MapSceenLogic;
import game.core.Presenters.PlayerCreationLogic;
import game.view.GameScreen;
import game.model.GameInfo;
import game.view.interfaces.IGameConfiguration;
import game.view.interfaces.IMainScreen;
import game.view.interfaces.IPlayerConfiguration;
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
//    private HashMap<String, GameScreen> controllers = new HashMap<>();
    private HashMap<String, GameLogic> logic = new HashMap<>();

    /**
     * This method adds a loaded screen to our game.
     * @param name The name of the screen
     * @param screen The loaded screen
     */
    public void addScreen(String name, Node screen) {
        gameScreens.put(name, screen);

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
                gameScreens.get(name);
            } else {
                getChildren().add(0, gameScreens.get(name));
                gameScreens.get(name);
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

    public void addGameLogic(String name, GameLogic newThing) {
        logic.put(name, newThing);
        newThing.setEngine(this);
    }

    public void startMapTimer(int time) {
        ((MapSceenLogic) logic.get(Mule.MAP2SCREEN)).timerStart(time);
    }

    public int turnTimeLeft() {
        return ((MapSceenLogic) logic.get(Mule.MAP2SCREEN)).getTimeLeft();
    }

    public void setCurrentGameLogic(String newLogic) {
        currentGameLogic = logic.get(newLogic);
        currentGameLogic.primeScreen();
        setScreen(newLogic);
    }
}
