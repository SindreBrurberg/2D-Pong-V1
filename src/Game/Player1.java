package Game;

import Engin.Screen;

import java.awt.event.KeyEvent;

/**
 * Created by Haxer on 28.01.14.
 */
public class Player1 extends Paddel {
    private boolean computer = false;

    public Player1(int x, int y) {
        super(x, y);
    }

    public void update(Ball ball, Screen screen) {
        if (screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_W)) {
            setY(getY() - Reference.speedP1);
        } else if (screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_S)) {
            setY(getY() + Reference.speedP1);
        } else if (screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_C)) {
            computer = true;
        }
        if (computer) {
            setY(ball.getY() - getHeight() / 2);
        }
        checkColition(ball);
    }

    @Override
    public void update() {

    }
}
