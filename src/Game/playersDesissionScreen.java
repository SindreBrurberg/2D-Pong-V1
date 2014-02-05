package Game;

import Engin.Screen;
import Engin.ScreenFactory;
import sun.tools.jar.resources.jar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Haxer on 28.01.14.
 */
public class playersDesissionScreen extends Screen {
    private butten butten1, butten2, butten3, butten4, butten5;
    private string string;

    private double Width = Reference.winX - 100, Hight = 150;

    public playersDesissionScreen(ScreenFactory screenFactory) {
        super(screenFactory);
        time.reset();
        Reference.gameMode = 0;
        Reference.speedP1 = 0;
        Reference.speedP2 = 0;
        string = new string(50, 15, Width, Hight, "Select Gamemode And P1 Speed!");
        butten1 = new butten(50, 225, Width, Hight, "2 Player Without Game.Computer!") {
            @Override
            public void update() {
                if (isActive())
                    Reference.gameMode = 1;
            }
        };
        butten2 = new butten(50, 425, Width, Hight, "1 Player With Game.Computer!") {
            @Override
            public void update() {
                if (isActive())
                    Reference.gameMode = 2;
            }
        };
        butten3 = new butten(50, 625, 325, Hight, "Slow Speed P1") {
            @Override
            public void update() {
                if (isActive())
                    Reference.speedP1 = Reference.speedSlow;
            }
        };
        butten4 = new butten(440, 625, 325, Hight, "Medium Speed P1") {
            @Override
            public void update() {
                if (isActive())
                    Reference.speedP1 = Reference.speedMedium;
            }
        };
        butten5 = new butten(825, 625, 325, Hight, "Fast Speed P1") {
            @Override
            public void update() {
                if (isActive())
                    Reference.speedP1 = Reference.speedFast;
            }
        };
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onUpdate() {
        butten1.update();
        butten2.update();
        butten3.update();
        butten4.update();
        butten5.update();
        if (Reference.speedP1 != 0 && !Screen.getScreenFactory().getGame().getMousepadListener().isMousePressed()) {
            if (Reference.gameMode == 1) {
                getScreenFactory().showScreen(new player2DesissionScreen(getScreenFactory()));
            } else if (Reference.gameMode == 2) {
                getScreenFactory().showScreen(new computerDesissionScreen(getScreenFactory()));
            }
        }
    }

    @Override
    public void onDraw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, Reference.winX, Reference.winY);
        butten1.draw(g2d);
        butten2.draw(g2d);
        butten3.draw(g2d);
        butten4.draw(g2d);
        butten5.draw(g2d);
        string.draw(g2d);
    }
}
