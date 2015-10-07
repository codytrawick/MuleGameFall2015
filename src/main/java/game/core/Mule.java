package game.core;

import game.core.Presenters.*;
import game.view.GameScreen;
import game.view.interfaces.*;
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
    public static final String LAND_SELECTION = "GameMap";
    public static final String LAND_SELECTION_FXML = "/fxml/mapScreen.fxml";
    public static final String TOWN_SCREEN = "Town";
    public static final String TOWN_SCREEN_FXML = "/fxml/townScreen.fxml";
    public static final String MAP2SCREEN = "Map Screen", MAP2FXML = "/fxml/mapScreen2.fxml",
    ROUNDSTART = "Turn Screen", ROUNDSTARTFXML = "/fxml/turnStart.fxml";
    public static final String STORE_SCREEN = "/fxml/storeScreen.fxml";

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
        gameEngine.addGameLogic(PLAYER_CREATION_PAGE, new PlayerCreationLogic((IPlayerConfiguration) loadScreen(PLAYER_CREATION_PAGE, PLAYER_CREATION_PAGE_FXML), gameEngine.getGame()));
        gameEngine.addGameLogic(LAND_SELECTION, new LandSelection((ILandSelection) loadScreen(LAND_SELECTION, LAND_SELECTION_FXML), gameEngine.getGame()));
        gameEngine.addGameLogic(MAP2SCREEN, new MapSceenLogic((IMapScreen) loadScreen(MAP2SCREEN, MAP2FXML), gameEngine.getGame()));
        gameEngine.addGameLogic(TOWN_SCREEN, new TownLogic((ITownScreen) loadScreen(TOWN_SCREEN, TOWN_SCREEN_FXML), gameEngine.getGame()));
        gameEngine.addGameLogic(ROUNDSTART, new RoundLogic((ITurnStart) loadScreen(ROUNDSTART, ROUNDSTARTFXML), gameEngine.getGame()));
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
