package Game;

import Engin.Game;


public class Main {

    private final Game game;

    Main() {
        game = new Game(Reference.winX, Reference.winY, Reference.Title);
        game.getScreenFactory().showScreen(new playersDesissionScreen(game.getScreenFactory()));
    }

    public static void main(String[] args) {
        new Main();
    }
}
