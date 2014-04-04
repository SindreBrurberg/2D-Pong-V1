package GamePongV2;

import EnginPongV2.Screen;
import EnginPongV2.ScreenFactory;

import java.awt.*;

/**
 * Created by Haxer on 28.01.14.
 */
public class player2DesissionScreen extends Screen {
    private string string;
    private butten butten, butten2, butten3;

    private double Width = ReferencePongV2.winX - 100, Hight = 150;

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
                    ReferencePongV2.speedP2 = ReferencePongV2.speedSlow;
            }
        };
        butten2 = new butten(50, 425, Width, Hight, "Medium Speed P2!") {
            @Override
            public void update() {
                if (isActive())
                    ReferencePongV2.speedP2 = ReferencePongV2.speedMedium;
            }
        };
        butten3 = new butten(50, 625, Width, Hight, "Fast Speed P2!") {
            @Override
            public void update() {
                if (isActive())
                    ReferencePongV2.speedP2 = ReferencePongV2.speedFast;
            }
        };
    }

    @Override
    public void onUpdate() {
        butten.update();
        butten2.update();
        butten3.update();
        if (ReferencePongV2.speedP2 != 0)
            getScreenFactory().showScreen(new GameScreen(getScreenFactory()));
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
