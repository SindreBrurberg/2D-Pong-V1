package Game;

import Engin.AbstractEntity;
import Engin.Screen;

import java.awt.*;
import java.util.Random;

public class Ball extends AbstractEntity {
    private final int WIDTH = 32, HIGHT = 32;
    private int lastHit;

    private Random random = new Random();
    private float velX;
    private float velY;
    public boolean rest = random.nextInt() % 2 == 1;

    public Ball(int x, int y) {
        super(x, y);
        velX = Reference.speedBall;
        velY = Reference.speedBall;
        if (rest)
            velX = -velX;
    }

    @Override
    public void update() {
        setX(getX() + velX);
        setY(getY() + velY);
        checkColition();

    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.fillOval((int) getX() + (WIDTH / 2), (int) getY() + (HIGHT / 2), WIDTH, HIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) getX() + (WIDTH / 2), (int) getY() + (HIGHT / 2), WIDTH, HIGHT);
    }

    public void checkColition() {
        if (getY() + 8 <= 0) {
            velY = -velY;
        } else if (getY() + HIGHT + 30 >= Reference.winY) {
            velY = -velY;
        }
        if (getX() <= 0) {
            Reference.scoreP1++;
            Screen.getScreenFactory().showScreen(new GameScreen(Screen.getScreenFactory()));
        } else if (getX() + WIDTH >= Reference.winX) {
            Reference.scoreP2++;
            Screen.getScreenFactory().showScreen(new GameScreen(Screen.getScreenFactory()));
        }
    }

    public void negateX() {
        velX = -velX;
    }

    public int getLastHit() {
        if (velX < 0)
            lastHit = 2;
        else lastHit = 1;
        return lastHit;
    }

    public void incresSpeed() {
        if (velX < 0) {
            velX = velX - Reference.speedBallIncreas;
        } else
            velX = velX + Reference.speedBallIncreas;
    }

    public void incresVel() {
        if (velY < 0) {
            velY = velY - Reference.speedBallIncreas;
        } else
            velY = velY + Reference.speedBallIncreas;
    }

    public double getWidth() {
        return WIDTH;
    }
}
