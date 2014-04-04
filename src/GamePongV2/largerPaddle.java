package GamePongV2;

import EnginPongV2.AbstractEntity;

import java.awt.*;

/**
 * Created by Haxer on 31.01.14.
 */
public class largerPaddle extends AbstractEntity {
    private static int x, y, WIDTH = 75, HEIGHT = 75, WIDTH2 = 25, HEIGHT2 = 25, power;

    private Ball ball;

    public largerPaddle(double x, double y) {
        super(x, y);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) getX(), (int) getY(), WIDTH, HEIGHT);
    }

    @Override
    public void update() {
        if (getBounds().intersects(ball.getBounds())){
            //powerUpHandler.usedPower();
            ball.incresSpeed();
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.red);
        g2d.fillOval((int) getX(), (int) getY(), WIDTH, HEIGHT);
        g2d.setColor(Color.orange);
        g2d.fillOval((int) getX() + WIDTH / 2 - WIDTH2 / 2, (int) getY() + HEIGHT / 2 - HEIGHT2 / 2, WIDTH2 , HEIGHT2);
        g2d.setColor(Color.black);
        g2d.drawOval((int) getX(), (int) getY(), WIDTH, HEIGHT);
        g2d.drawOval((int) getX() + WIDTH / 2 - WIDTH2 / 2, (int) getY() + HEIGHT / 2 - HEIGHT2 / 2, WIDTH2 , HEIGHT2);
    }
}
