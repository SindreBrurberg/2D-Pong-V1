package EnginPongV2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created with IntelliJ IDEA.
 * User: Haxer
 * Date: 23.11.13
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public class KeyboardListener implements KeyListener {

    private boolean[] keys = new boolean[256];

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public boolean isKeyPressed(int key) {
        return keys[key];
    }

    public boolean isKeyReleased(int key) {
        return !keys[key];
    }
}
