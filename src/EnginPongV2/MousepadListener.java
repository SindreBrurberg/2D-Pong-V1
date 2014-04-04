package EnginPongV2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: Haxer
 * Date: 23.11.13
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public class MousepadListener implements MouseListener {

    private int mouseX, mouseY;
    private boolean clicked;

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        clicked = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseClicked(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean isMousePressed() {
        return clicked;
    }

    public int getX() {
        return mouseX;
    }

    public int getY() {
        return mouseY;
    }

    public void setX(int x) {
        mouseX = x;
    }

    public void setY(int y) {
        mouseY = y;
    }

    public Rectangle getMouse(){
        return new Rectangle(mouseX, mouseY, 1, 1);
    }

    public void resetMouse(){
        mouseX = 0;
        mouseY = 0;
    }
}
