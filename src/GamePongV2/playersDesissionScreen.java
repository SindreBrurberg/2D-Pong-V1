package GamePongV2;

import EnginPongV2.Screen;
import EnginPongV2.ScreenFactory;

import java.awt.*;

/**
 * Created by Haxer on 28.01.14.
 */
public class playersDesissionScreen extends Screen {
    private butten butten1, butten2, butten3, butten4, butten5;
    private string string;

    private double Width = ReferencePongV2.winX - 100, Hight = 150;

    public playersDesissionScreen(ScreenFactory screenFactory) {
        super(screenFactory);
        time.reset();
        ReferencePongV2.gameMode = 0;
        ReferencePongV2.speedP1 = 0;
        ReferencePongV2.speedP2 = 0;
        string = new string(50, 15, Width, Hight, "Select Gamemode And P1 Speed!");
        butten1 = new butten(50, 225, Width, Hight, "2 Player Without Computer!") {
            @Override
            public void update() {
                if (isActive())
                    ReferencePongV2.gameMode = 1;
            }
        };
        butten2 = new butten(50, 425, Width, Hight, "1 Player With Computer!") {
            @Override
            public void update() {
                if (isActive())
                    ReferencePongV2.gameMode = 2;
            }
        };
        butten3 = new butten(50, 625, 325, Hight, "Slow Speed P1") {
            @Override
            public void update() {
                if (isActive())
                    ReferencePongV2.speedP1 = ReferencePongV2.speedSlow;
            }
        };
        butten4 = new butten(440, 625, 325, Hight, "Medium Speed P1") {
            @Override
            public void update() {
                if (isActive())
                    ReferencePongV2.speedP1 = ReferencePongV2.speedMedium;
            }
        };
        butten5 = new butten(825, 625, 325, Hight, "Fast Speed P1") {
            @Override
            public void update() {
                if (isActive())
                    ReferencePongV2.speedP1 = ReferencePongV2.speedFast;
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
        if (ReferencePongV2.speedP1 != 0 && !Screen.getScreenFactory().getGame().getMousepadListener().isMousePressed()){
            if (ReferencePongV2.gameMode == 1){
                getScreenFactory().showScreen(new player2DesissionScreen(getScreenFactory()));
            }else if (ReferencePongV2.gameMode == 2){
                getScreenFactory().showScreen(new computerDesissionScreen(getScreenFactory()));
            }
        }
    }

    @Override
    public void onDraw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, ReferencePongV2.winX, ReferencePongV2.winY);
        butten1.draw(g2d);
        butten2.draw(g2d);
        butten3.draw(g2d);
        butten4.draw(g2d);
        butten5.draw(g2d);
        string.draw(g2d);
    }
}
