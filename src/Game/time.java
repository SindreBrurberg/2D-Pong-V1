package Game;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Haxer on 29.01.14.
 */
public class time {
    private PrintWriter writer;
    private static int milli = 0, sec = 0, min = 0;
    private static double x, y;

    public time(int x, int y) {
        time.x = x;
        time.y = y;
        try {
            writer = new PrintWriter("pongConfig.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static double getX() {
        return x;
    }

    public static double getY() {
        return y;
    }

    public static double getMilli() {
        return milli;
    }

    public static double getSec() {
        return sec;
    }

    public static double getMin() {
        return min;
    }

    public void setX(double x) {
        time.x = x;
    }

    public void setY(double y) {
        time.y = y;
    }

    public static void reset() {
        milli = 0;
        sec = 0;
        min = 0;
    }

    public static void update() {
        if (Reference.isGameRunning) {
            milli++;
            if (milli == 100) {
                sec++;
                milli = 0;
            }
            if (sec == 60) {
                min++;
                sec = 0;
            }
        }
    }

    public static void draw(Graphics2D g2d) {
        g2d.drawString(String.valueOf(min) + ":" + String.valueOf(sec), (int) getX(), (int) getY());
    }
}
