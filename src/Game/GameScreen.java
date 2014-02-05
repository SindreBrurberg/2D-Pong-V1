package Game;

import Engin.Screen;
import Engin.ScreenFactory;

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
        Reference.isGameRunning = true;
        if (Reference.debugMode)
            debugSquer = new DebugSquer(64, 64);
        else
            ball = new Ball(Reference.winX / 2 - 16, Reference.winY / 2 - 16);
        player1 = new Player1(50, Reference.winY / 2);
        if (Reference.gameMode == 1)
            player2 = new Player2(Reference.winX - paddle2X, Reference.winY / 2);
        else
            computer = new Computer(Reference.winX - paddle2X, Reference.winY / 2);
        scoreP1 = new Score(Reference.scoreP1X / 2, Reference.scoreP1Y / 2, Reference.scoreP1) {
            @Override
            public void update() {
                z = Reference.scoreP1;
            }
        };
        scoreP2 = new Score(Reference.scoreP2X / 2, Reference.scoreP2Y / 2, Reference.scoreP2) {
            @Override
            public void update() {
                z = Reference.scoreP2;
            }
        };
        powerUpHandler = new powerUpHandler();
        time timer = new time(Reference.winX / 4, Reference.winY / 2 - 20);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onUpdate() {
        if (Reference.debugMode)
            debugSquer.update();
        else
            ball.update();
        player1.update(ball, this);
        if (Reference.gameMode == 1)
            player2.update(ball, this);
        else
            computer.update(ball);
        scoreP1.update();
        scoreP2.update();
        if (getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_ESCAPE)) {
            System.out.println(Reference.Pause);
            getScreenFactory().showScreen(new PauseScreen(getScreenFactory()));
        }
        time.update();
        powerUpHandler.update(ball, player1, player2, computer);
    }

    @Override
    public void onDraw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, Reference.winX, Reference.winY);
        if (Reference.debugMode)
            debugSquer.draw(g2d);
        else ball.draw(g2d);
        player1.draw(g2d);
        if (Reference.gameMode == 1)
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
