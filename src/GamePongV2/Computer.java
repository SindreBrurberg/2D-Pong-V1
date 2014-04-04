package GamePongV2;

/**
 * Created by Haxer on 28.01.14.
 */
public class Computer extends Paddel{
    public Computer(int x, int y) {
        super(x, y);
    }

    public void update(Ball ball){
        if (ball.getY() >= getY() + ReferencePongV2.paddelHight - ball.getWidth())
            setY(getY() + ReferencePongV2.speedP2);
        else if (ball.getY() <= getY())
            setY(getY() - ReferencePongV2.speedP2);
        checkColition(ball);
    }

    @Override
    public void update() {

    }
}
