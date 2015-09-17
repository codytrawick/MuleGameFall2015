package game.controllers;


import game.core.Engine;
import game.core.GameScreen;

public class MapScreenController implements GameScreen {
    Engine gameEngine;

    public void setEngine(Engine parent) {
        gameEngine = parent;
    }
}
