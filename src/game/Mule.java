package game;/**
 * Created by Cody on 9/13/2015.
 */

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.security.acl.Group;

public class Mule extends Application {

    public static final String WELCOME_PAGE = "Start";
    public static final String WELCOME_PAGE_FXML = "startScreen.fxml";
    public static final String PLAYER_CREATION_PAGE = "Players";
    public static final String PLAYER_CREATION_PAGE_FXML = "differentScreen.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Engine gameEngine = new Engine();
        gameEngine.loadScreen(WELCOME_PAGE, WELCOME_PAGE_FXML);
        gameEngine.loadScreen(PLAYER_CREATION_PAGE, PLAYER_CREATION_PAGE_FXML);

        gameEngine.setScreen(WELCOME_PAGE);
        primaryStage.setTitle("Mule");
        primaryStage.setScene(new Scene(gameEngine));
        primaryStage.show();
    }

}
