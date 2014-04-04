package GamePongV2;

import EnginPongV2.Screen;
import EnginPongV2.ScreenFactory;

import java.awt.*;

/**
 * Created by Haxer on 28.01.14.
 */
public class computerDesissionScreen extends Screen {
    private butten butten, butten2, butten3;
    private string string;
    private double Width = ReferencePongV2.winX - 100, Hight = 150;

    public computerDesissionScreen(ScreenFactory screenFactory) {
        super(screenFactory);
        string = new string(50, 15, Width, Hight, "Select Computer Difficulity!");
        butten = new butten(50, 225, Width, Hight, "Easy Difficulity!") {
            @Override
            public void update() {
                if (isActive())
                    ReferencePongV2.speedP2 = ReferencePongV2.speedSlowComputer;
            }
        };
        butten2 = new butten(50, 425, Width, Hight, "Medium Difficulity!") {
            @Override
            public void update() {
                if (isActive())
                    ReferencePongV2.speedP2 = ReferencePongV2.speedMediumComputer;
            }
        };
        butten3 = new butten(50, 625, Width, Hight, "Hard Difficulity!") {
            @Override
            public void update() {
                if (isActive())
                    ReferencePongV2.speedP2 = ReferencePongV2.speedFastComputer;
            }
        };
    }

    @Override
    public void onCreate() {

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
