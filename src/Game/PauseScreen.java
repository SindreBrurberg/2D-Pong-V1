package Game;

import Engin.Screen;
import Engin.ScreenFactory;

import java.awt.*;

/**
 * Created by Haxer on 24.12.13.
 */
public class PauseScreen extends Screen {
    private string string;
    private butten butten, butten2, butten3;

    private double Width = Reference.winX - 100, Height = 150;

    public PauseScreen(ScreenFactory screenFactory) {
        super(screenFactory);
        Reference.isGameRunning = false;
        string = new string(50, 25, Width, Height, Reference.Pause);
        butten = new butten(50, 225, Width, Height, "Resume!") {
            @Override
            public void update() {
                if (isActive())
                    getScreenFactory().showScreen(new GameScreen(getScreenFactory()));
            }
        };
        butten2 = new butten(50, 425, Width, Height, "Restart!") {
            @Override
            public void update() {
                if (isActive()) {
                    Reference.scoreP1 = 0;
                    Reference.scoreP2 = 0;
                    time.reset();
                    getScreenFactory().showScreen(new GameScreen(getScreenFactory()));
                }
            }
        };
        butten3 = new butten(50, 625, Width, Height, "Game.Main Menu!") {
            @Override
            public void update() {
                if (isActive()) {
                    getScreenFactory().showScreen(new playersDesissionScreen(getScreenFactory()));
                }
            }
        };
        Screen.getScreenFactory().getGame().getMousepadListener().resetMouse();
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onUpdate() {
        butten.update();
        butten2.update();
        butten3.update();
    }

    @Override
    public void onDraw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, Reference.winX, Reference.winY);
        string.draw(g2d);
        butten.draw(g2d);
        butten2.draw(g2d);
        butten3.draw(g2d);
    }
}
