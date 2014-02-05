package Game;

import Engin.Screen;
import Engin.ScreenFactory;

import java.awt.*;

/**
 * Created by Haxer on 28.01.14.
 */
public class player2DesissionScreen extends Screen {
    private string string;
    private butten butten, butten2, butten3;

    private double Width = Reference.winX - 100, Hight = 150;

    public player2DesissionScreen(ScreenFactory screenFactory) {
        super(screenFactory);
    }

    @Override
    public void onCreate() {
        string = new string(50, 25, Width, Hight, "Select P2 Speed!");
        butten = new butten(50, 225, Width, Hight, "Slow Speed P2!") {
            @Override
            public void update() {
                if (isActive())
                    Reference.speedP2 = Reference.speedSlow;
            }
        };
        butten2 = new butten(50, 425, Width, Hight, "Medium Speed P2!") {
            @Override
            public void update() {
                if (isActive())
                    Reference.speedP2 = Reference.speedMedium;
            }
        };
        butten3 = new butten(50, 625, Width, Hight, "Fast Speed P2!") {
            @Override
            public void update() {
                if (isActive())
                    Reference.speedP2 = Reference.speedFast;
            }
        };
    }

    @Override
    public void onUpdate() {
        butten.update();
        butten2.update();
        butten3.update();
        if (Reference.speedP2 != 0)
            getScreenFactory().showScreen(new GameScreen(getScreenFactory()));
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
