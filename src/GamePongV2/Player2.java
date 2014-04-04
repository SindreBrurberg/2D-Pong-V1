package GamePongV2;



import EnginPongV2.Screen;

import java.awt.event.KeyEvent;

/**
 * Created by Haxer on 28.01.14.
 */
public class Player2 extends Paddel{
    public Player2(int x, int y) {
        super(x, y);
    }

    public void update(Ball ball, Screen screen){
        if (screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_UP)){
            setY(getY() - ReferencePongV2.speedP2);
        }
        else if (screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_DOWN)){
            setY(getY() + ReferencePongV2.speedP2);
        }
        checkColition(ball);
    }

    @Override
    public void update() {

    }
}
