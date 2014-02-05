package Game;

import Engin.AbstractEntity;

import java.awt.*;

/**
 * Created by Haxer on 31.01.14.
 */
public class speedUp extends AbstractEntity {
    private static int x, y, WIDTH = 75, HEIGHT = 75, WIDTH2 = 25, HEIGHT2 = 25, power;

    private Ball ball;

    public speedUp(double x, double y) {
        super(x, y);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) getX(), (int) getY(), WIDTH, HEIGHT);
    }

    @Override
    public void update() {
        if (getBounds().intersects(ball.getBounds())) {
            //Game.powerUpHandler.usedPower();
            ball.incresSpeed();
        }
    }

    @Override
    public void draw(Graphics2D g2d) {

    }
}
