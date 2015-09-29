package game.core;

import javafx.application.Application;
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
        Engine gameEngine = new Engine();
        gameEngine.loadScreen(WELCOME_PAGE, WELCOME_PAGE_FXML);
        gameEngine.loadScreen(PLAYER_CREATION_PAGE, PLAYER_CREATION_PAGE_FXML);
        gameEngine.loadScreen(GAME_CONFIGURATION, GAME_CONFIGURATION_FXML);
        gameEngine.loadScreen(MAP_PAGE, MAP_PAGE_FXML);
        gameEngine.loadScreen(TOWN_SCREEN, TOWN_SCREEN_FXML);
        gameEngine.loadScreen(MAP2SCREEN, MAP2FXML);

        gameEngine.setScreen(WELCOME_PAGE);
        primaryStage.setTitle("Mule");
        primaryStage.setScene(new Scene(gameEngine));
        primaryStage.show();
    }

}
