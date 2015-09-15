package game.core;
/**
 * This is the  main class for our Game.
 * This class will load all known screens and set the screen to the welcome
 * screen.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mule extends Application {

    public static final String WELCOME_PAGE = "Start";
    public static final String WELCOME_PAGE_FXML = "/startScreen.fxml";
    public static final String PLAYER_CREATION_PAGE = "Players";
    public static final String PLAYER_CREATION_PAGE_FXML = "/playerConfig.fxml";
    public static final String GAME_CONFIGURATION = "Configuration Menu";
    public static final String GAME_CONFIGURATION_FXML = "/gameConfig.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Engine gameEngine = new Engine();
        gameEngine.loadScreen(WELCOME_PAGE, WELCOME_PAGE_FXML);
        gameEngine.loadScreen(PLAYER_CREATION_PAGE, PLAYER_CREATION_PAGE_FXML);
        gameEngine.loadScreen(GAME_CONFIGURATION, GAME_CONFIGURATION_FXML);

        gameEngine.setScreen(WELCOME_PAGE);
        primaryStage.setTitle("Mule");
        primaryStage.setScene(new Scene(gameEngine));
        primaryStage.show();
    }

}
