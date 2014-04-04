package EnginPongV2;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Haxer
 * Date: 23.11.13
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private final JFrame window = new JFrame();
    private final ScreenFactory screenFactory;
    private final KeyboardListener keyboardListener;
    private final MousepadListener mousepadListener;

    public Game(int windowX, int windowY, String title) {
        window.setSize(windowX + 6, windowY + 29);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setFocusable(true);
        window.setLocationRelativeTo(null);
        window.setTitle(title);
        window.setVisible(true);
        screenFactory = new ScreenFactory(this);
        GameThread gameThread = new GameThread(this);
        keyboardListener = new KeyboardListener();
        mousepadListener = new MousepadListener();
        window.add(gameThread);
        window.addKeyListener(keyboardListener);
        window.addMouseListener(mousepadListener);
        new Thread(gameThread).start();
    }

    public KeyboardListener getKeyboardListener() {
        return keyboardListener;
    }

    public MousepadListener getMousepadListener() {
        return mousepadListener;
    }

    public ScreenFactory getScreenFactory() {
        return screenFactory;
    }

    public JFrame getWindow() {
        return window;
    }
}
