package GamePongV2;

import EnginPongV2.AbstractEntity;
import EnginPongV2.Screen;

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
        velX = ReferencePongV2.speedBall;
        velY = ReferencePongV2.speedBall;
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
        } else if (getY() + HIGHT + 30 >= ReferencePongV2.winY) {
            velY = -velY;
        }
        if (getX() <= 0){
            ReferencePongV2.scoreP1++;
            Screen.getScreenFactory().showScreen(new GameScreen(Screen.getScreenFactory()));
        } else if (getX() + WIDTH >= ReferencePongV2.winX){
            ReferencePongV2.scoreP2++;
            Screen.getScreenFactory().showScreen(new GameScreen(Screen.getScreenFactory()));
        }
    }
    public void negateX(){
        velX = -velX;
    }

    public int getLastHit(){
        if (velX < 0)
            lastHit = 2;
        else lastHit = 1;
        return lastHit;
    }

    public void incresSpeed() {
        if (velX < 0) {
            velX = velX - ReferencePongV2.speedBallIncreas;
        }
        else
            velX = velX + ReferencePongV2.speedBallIncreas;
    }
    public void incresVel() {
        if (velY < 0) {
            velY = velY - ReferencePongV2.speedBallIncreas;
        }
        else
            velY = velY + ReferencePongV2.speedBallIncreas;
    }

    public double getWidth(){
        return WIDTH;
    }
}
