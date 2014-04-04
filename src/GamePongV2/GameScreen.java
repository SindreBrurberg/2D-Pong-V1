package GamePongV2;

import EnginPongV2.Screen;
import EnginPongV2.ScreenFactory;

import java.awt.*;
import java.awt.event.KeyEvent;


public class GameScreen extends Screen {
    private Ball ball;
    private Player1 player1;
    private Player2 player2;
    private Score scoreP1, scoreP2;
    private DebugSquer debugSquer;
    private Computer computer;
    private powerUpHandler powerUpHandler;

    private int paddle2X = 75;

    public GameScreen(ScreenFactory screenFactory) {
        super(screenFactory);
        ReferencePongV2.isGameRunning = true;
        if (ReferencePongV2.debugMode)
            debugSquer = new DebugSquer(64, 64);
        else
            ball = new Ball(ReferencePongV2.winX / 2 - 16, ReferencePongV2.winY / 2 - 16);
        player1 = new Player1(50, ReferencePongV2.winY / 2);
        if (ReferencePongV2.gameMode == 1)
            player2 = new Player2(ReferencePongV2.winX - paddle2X, ReferencePongV2.winY / 2);
        else
            computer = new Computer(ReferencePongV2.winX - paddle2X, ReferencePongV2.winY / 2);
        scoreP1 = new Score(ReferencePongV2.scoreP1X / 2, ReferencePongV2.scoreP1Y / 2, ReferencePongV2.scoreP1) {
            @Override
            public void update() {
                z = ReferencePongV2.scoreP1;
            }
        };
        scoreP2 = new Score(ReferencePongV2.scoreP2X / 2, ReferencePongV2.scoreP2Y / 2, ReferencePongV2.scoreP2) {
            @Override
            public void update() {
                z = ReferencePongV2.scoreP2;
            }
        };
        powerUpHandler = new powerUpHandler();
        time timer = new time(ReferencePongV2.winX / 4, ReferencePongV2.winY / 2 - 20);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onUpdate() {
        if (ReferencePongV2.debugMode)
            debugSquer.update();
        else
            ball.update();
        player1.update(ball, this);
        if (ReferencePongV2.gameMode == 1)
            player2.update(ball, this);
        else
            computer.update(ball);
        scoreP1.update();
        scoreP2.update();
        if (getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_ESCAPE)) {
            System.out.println(ReferencePongV2.Pause);
            getScreenFactory().showScreen(new PauseScreen(getScreenFactory()));
        }
        time.update();
        powerUpHandler.update(ball, player1, player2, computer);
    }

    @Override
    public void onDraw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, ReferencePongV2.winX, ReferencePongV2.winY);
        if (ReferencePongV2.debugMode)
            debugSquer.draw(g2d);
        else ball.draw(g2d);
        player1.draw(g2d);
        if (ReferencePongV2.gameMode == 1)
            player2.draw(g2d);
        else
            computer.draw(g2d);
        g2d.scale(2, 2);
        scoreP1.draw(g2d);
        scoreP2.draw(g2d);
        time.draw(g2d);
        g2d.scale(0.5, 0.5);
        powerUpHandler.draw(g2d);
    }
}
