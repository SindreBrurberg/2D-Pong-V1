package Game;

/**
 * Created by Haxer on 28.01.14.
 */
public class Computer extends Paddel {
    public Computer(int x, int y) {
        super(x, y);
    }

    public void update(Ball ball) {
        if (ball.getY() >= getY() + Reference.paddelHight - ball.getWidth())
            setY(getY() + Reference.speedP2);
        else if (ball.getY() <= getY())
            setY(getY() - Reference.speedP2);
        checkColition(ball);
    }

    @Override
    public void update() {

    }
}
