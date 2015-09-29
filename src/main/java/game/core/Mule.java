package game.core;

import game.core.Presenters.ConfigurationLogic;
import game.core.Presenters.MainScreenLogic;
import game.core.Presenters.PlayerCreationLogic;
import game.view.GameScreen;
import game.view.interfaces.IGameConfiguration;
import game.view.interfaces.IMainScreen;
import game.view.interfaces.IPlayerConfiguration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the  main class for our Game.
 * This class will load all known screens and set the screen to the welcome
 * screen.
 *
 * @author The SpecialFX
 * @version 1.0
 */
public class Mule extends Application {

    //GameScreen names. Used to refer to other game screens
    public static final String WELCOME_PAGE = "Start";
    public static final String WELCOME_PAGE_FXML = "/fxml/startScreen.fxml";
    public static final String PLAYER_CREATION_PAGE = "Players";
    public static final String PLAYER_CREATION_PAGE_FXML = "/fxml/playerConfig.fxml";
    public static final String GAME_CONFIGURATION = "Configuration Menu";
    public static final String GAME_CONFIGURATION_FXML = "/fxml/gameConfig.fxml";
    public static final String MAP_PAGE = "GameMap";
    public static final String MAP_PAGE_FXML = "/fxml/mapScreen.fxml";
    public static final String TOWN_SCREEN = "Town";
    public static final String TOWN_SCREEN_FXML = "/fxml/townScreen.fxml";
    public static final String MAP2SCREEN = "Map Screen", MAP2FXML = "/fxml/mapScreen2.fxml";

    Engine gameEngine = new Engine();

    /**
     * Main method for our game. This is the main class in the jar file
     * @param args The required args parameter. Not used
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method starts the JavaFX application
     * @param primaryStage The required primary stage parameter
     */
    @Override
    public void start(Stage primaryStage) {
        gameEngine.addGameLogic(WELCOME_PAGE, new MainScreenLogic((IMainScreen) loadScreen(WELCOME_PAGE, WELCOME_PAGE_FXML), gameEngine.getGame()));
        gameEngine.addGameLogic(GAME_CONFIGURATION, new ConfigurationLogic((IGameConfiguration) loadScreen(GAME_CONFIGURATION, GAME_CONFIGURATION_FXML), gameEngine.getGame()));
//        loadScreen(WELCOME_PAGE, WELCOME_PAGE_FXML);
//        loadScreen(PLAYER_CREATION_PAGE, PLAYER_CREATION_PAGE_FXML);
//        loadScreen(GAME_CONFIGURATION, GAME_CONFIGURATION_FXML);
//        loadScreen(MAP_PAGE, MAP_PAGE_FXML);
//        loadScreen(TOWN_SCREEN, TOWN_SCREEN_FXML);
//        loadScreen(MAP2SCREEN, MAP2FXML);

        gameEngine.setCurrentGameLogic(WELCOME_PAGE);
        primaryStage.setTitle("Mule");
        primaryStage.setScene(new Scene(gameEngine));
        primaryStage.show();
    }

    private GameScreen loadScreen(String name, String resource) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(resource));
            Node loadedScreen = loader.load();
            gameEngine.addScreen(name, loadedScreen);
            return loader.getController();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public void loadScreen(GameScreen screen, String fxlmresourceName) {
//        try {
//            FXMLLoader loader = new FXMLLoader(
//                    getClass().getResource(fxlmresourceName));
//            Node loadedScreen = loader.load();
//            GameScreen targetScene = loader.getController();
////            targetScene.setEngine(this);
//            if (name.equals(Mule.GAME_CONFIGURATION)) {
//                logic.put(Mule.GAME_CONFIGURATION, new ConfigurationLogic((IGameConfiguration) targetScene, game));
//            } else if (name.equals(Mule.WELCOME_PAGE)) {
//                logic.put(Mule.WELCOME_PAGE, new MainScreenLogic((IMainScreen) targetScene, game));
//            } else if (name.equals(Mule.PLAYER_CREATION_PAGE)) {
//                logic.put(Mule.PLAYER_CREATION_PAGE, new PlayerCreationLogic((IPlayerConfiguration) targetScene, game));
//            }
//
//            controllers.put(name, targetScene);
//            addScreen(name, loadedScreen);
//        } catch (java.io.IOException e) {
//            e.printStackTrace();
//        }
//    }

}
