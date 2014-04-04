package EnginPongV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Haxer
 * Date: 23.11.13
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class GameThread extends JPanel implements Runnable {
    private static final long serialVersionUID = 2551158487608353974L;
    private final Game game;

    public GameThread(Game game) {
        this.game = game;
        setFocusable(true);
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                if (game.getScreenFactory().getCurrentScreen() != null) {
                    game.getScreenFactory().getCurrentScreen().onUpdate();
                }
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (game.getScreenFactory().getCurrentScreen() != null)
            game.getScreenFactory().getCurrentScreen().onDraw(g2d);
        repaint();
    }
}
