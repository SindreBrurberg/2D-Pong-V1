package Game;

import Engin.AbstractEntity;

import java.awt.*;

/**
 * Created by Haxer on 23.12.13.
 */
public abstract class Score extends AbstractEntity {

    protected int z;

    public Score(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawString(String.valueOf(z), (int) getX(), (int) getY());
    }
}
