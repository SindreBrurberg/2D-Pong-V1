package GamePongV2;

import EnginPongV2.Screen;
import EnginPongV2.ScreenFactory;

import java.awt.*;

/**
 * Created by Haxer on 24.12.13.
 */
public class PauseScreen extends Screen {
    private string string;
    private butten butten, butten2, butten3;

    private double Width = ReferencePongV2.winX - 100, Height = 150;

    public PauseScreen(ScreenFactory screenFactory) {
        super(screenFactory);
        ReferencePongV2.isGameRunning = false;
        string = new string(50, 25,Width, Height, ReferencePongV2.Pause);
        butten = new butten(50, 225, Width, Height, "Resume!") {
            @Override
            public void update() {
                if (isActive())
                    getScreenFactory().showScreen(new GameScreen(getScreenFactory()));
            }
        };
        butten2 = new butten(50 , 425, Width, Height, "Restart!") {
            @Override
            public void update() {
                if (isActive()){
                    ReferencePongV2.scoreP1 = 0;
                    ReferencePongV2.scoreP2 = 0;
                    time.reset();
                    getScreenFactory().showScreen(new GameScreen(getScreenFactory()));
                }
            }
        };
        butten3 = new butten(50, 625, Width, Height, "Main Menu!") {
            @Override
            public void update() {
                if (isActive()){
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
        g2d.fillRect(0, 0, ReferencePongV2.winX, ReferencePongV2.winY);
        string.draw(g2d);
        butten.draw(g2d);
        butten2.draw(g2d);
        butten3.draw(g2d);
    }
}
