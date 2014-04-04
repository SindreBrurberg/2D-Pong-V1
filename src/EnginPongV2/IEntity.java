package EnginPongV2;

import java.awt.*;


public interface IEntity {

    public double getX();

    public double getY();

    public void setX(double x);

    public void setY(double y);

    public void update();

    public void draw(Graphics2D g2d);
}
