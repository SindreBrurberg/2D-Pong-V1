package GamePongV2;

import EnginPongV2.AbstractEntity;
import EnginPongV2.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Haxer on 10.01.14.
 */
public class DebugSquer extends AbstractEntity {
    public DebugSquer(int x, int y) {
        super(x, y);
    }

    private int X = ReferencePongV2.winX / 2;
    private int Y = ReferencePongV2.winY / 2;

    @Override
    public void update() {
        if (Screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_J))
            X--;
        if (Screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_I))
            Y--;
        if (Screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_L))
            X++;
        if (Screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_K))
            Y++;
        System.out.println(ReferencePongV2.debug + " X: " + X + " Y: " + Y);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.CYAN);
        g2d.drawRect(X, Y, (int) getX(), (int) getY());
    }
}
