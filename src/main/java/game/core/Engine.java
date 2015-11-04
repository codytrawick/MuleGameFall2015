package game.core;

import game.core.Presenters.*;
import game.model.GameInfo;
import game.model.IModel;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
    private IModel game = new GameInfo();
    private GameLogic currentGameLogic;

    //The Game Engine has references to the screens and their controllers
    private Map<String, Node> gameScreens = new HashMap<>();
//    private HashMap<String, GameScreen> controllers = new HashMap<>();
    private Map<String, GameLogic> logic = new HashMap<>();

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
        }
    }

    /**
     * This method returns the engine's game
     * @return The game associated with the engine
     */
    public IModel getGame() {
        return game;
    }

    /**
     * This method sets the engine's game. Used for creating a new game
     * or loading an old game
     * @param newGame The new game for the engine
     */
    public void setGame(GameInfo newGame) {
        this.game = newGame;
        for (GameLogic gameLogic : logic.values()) {
            gameLogic.setModel(newGame);
        }
    }

    public void addGameLogic(String name, GameLogic newThing) {
        logic.put(name, newThing);
        newThing.setEngine(this);
    }

    public void startMapTimer(int time) {
        IntegerProperty timeSeconds = new SimpleIntegerProperty(time);
//        mapView.setTimerBind(timeSeconds);
        timeSeconds.set(time);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(time + 1),
                        new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
        ((MapSceenLogic) logic.get(Mule.MAP2SCREEN)).timerStart(timeSeconds);
        ((TownLogic) logic.get(Mule.TOWN_SCREEN)).timerStart(timeSeconds);
    }

    public int turnTimeLeft() {
        return ((MapSceenLogic) logic.get(Mule.MAP2SCREEN)).getTimeLeft();
    }

    public void setCurrentGameLogic(String newLogic) {
        currentGameLogic = logic.get(newLogic);
        currentGameLogic.primeScreen();
        setScreen(newLogic);
    }

    public boolean betweenTurns() {
        return currentGameLogic instanceof RoundLogic;
    }

    public void saveGame() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(SAVENAME));
            objectOutputStream.writeObject(game);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String SAVENAME = "gameSave.bin";

    public boolean loadGame() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SAVENAME));
            setGame((GameInfo) inputStream.readObject());
            inputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
