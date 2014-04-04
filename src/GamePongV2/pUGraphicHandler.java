package GamePongV2;

import java.awt.*;

/**
 * Created by Haxer on 01.02.14.
 */
public class pUGraphicHandler extends powerUpHandler{
    private static int x, y, WIDTH = 75, HEIGHT = 75, WIDTH2 = 25, HEIGHT2 = 25, power;

    public pUGraphicHandler(double x, double y, int power) {
        pUGraphicHandler.x = (int)x;
        pUGraphicHandler.y = (int)y;
        pUGraphicHandler.power = power;
    }

    public static void loadPowerGraphic(Graphics2D g2d){
        // speed up
        if (power == 1){
            g2d.setColor(Color.cyan);
            g2d.fillOval(x, y, WIDTH, HEIGHT);
            g2d.setColor(Color.red);
            g2d.fillOval(x + WIDTH / 2 - WIDTH2 / 2, y + HEIGHT / 2 - HEIGHT2 / 2, WIDTH2 , HEIGHT2);
            g2d.setColor(Color.black);
            g2d.drawOval(x, y, WIDTH, HEIGHT);
            g2d.drawOval(x + WIDTH / 2 - WIDTH2 / 2, y + HEIGHT / 2 - HEIGHT2 / 2, WIDTH2 , HEIGHT2);
        }
        //
        else if (power == 2){
            g2d.setColor(Color.cyan);
            g2d.fillOval(x, y, WIDTH, HEIGHT);
            g2d.setColor(Color.orange);
            g2d.fillOval(x + WIDTH / 2 - WIDTH2 / 2, y + HEIGHT / 2 - HEIGHT2 / 2, WIDTH2 , HEIGHT2);
            g2d.setColor(Color.black);
            g2d.drawOval(x, y, WIDTH, HEIGHT);
            g2d.drawOval(x + WIDTH / 2 - WIDTH2 / 2, y + HEIGHT / 2 - HEIGHT2 / 2, WIDTH2 , HEIGHT2);
        }
        // smaler Paddle
        else if (power == 3){
            g2d.setColor(Color.red);
            g2d.fillOval(x, y, WIDTH, HEIGHT);
            g2d.setColor(Color.orange);
            g2d.fillOval(x + WIDTH / 2 - WIDTH2 / 2, y + HEIGHT / 2 - HEIGHT2 / 2, WIDTH2 , HEIGHT2);
            g2d.setColor(Color.black);
            g2d.drawOval(x, y, WIDTH, HEIGHT);
            g2d.drawOval(x + WIDTH / 2 - WIDTH2 / 2, y + HEIGHT / 2 - HEIGHT2 / 2, WIDTH2 , HEIGHT2);
        }
        // larger paddle
        else if (power == 4){
            g2d.setColor(Color.blue);
            g2d.fillOval(x, y, WIDTH, HEIGHT);
            g2d.setColor(Color.green);
            g2d.fillOval(x + WIDTH / 2 - WIDTH2 / 2, y + HEIGHT / 2 - HEIGHT2 / 2, WIDTH2 , HEIGHT2);
            g2d.setColor(Color.black);
            g2d.drawOval(x, y, WIDTH, HEIGHT);
            g2d.drawOval(x + WIDTH / 2 - WIDTH2 / 2, y + HEIGHT / 2 - HEIGHT2 / 2, WIDTH2 , HEIGHT2);
        }
    }
}
