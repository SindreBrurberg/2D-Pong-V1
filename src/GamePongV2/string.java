package GamePongV2;

import EnginPongV2.AbstractEntity;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.AffineTransform;

/**
 * Created by Haxer on 28.01.14.
 */
public class string extends AbstractEntity {
    private String TXT;
    private double Width, Height;

    public string(double x, double y, double Width, double Height, String TXT) {
        super(x, y);
        this.Width = Width;
        this.Height = Height;
        this.TXT = TXT;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)getX(), (int)getY(), (int)Width, (int)Height);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g2d) {
        Graphics2D g2 = (Graphics2D) g2d.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        FontRenderContext frc = g2.getFontRenderContext();
        Font font = g2.getFont().deriveFont(16f);
        g2.setFont(font);
        double sw = font.getStringBounds(TXT, frc).getWidth();
        LineMetrics lm = font.getLineMetrics(TXT, frc);
        double sh = lm.getAscent() + lm.getDescent();
        Rectangle r = getBounds();
        g2.setPaint(Color.WHITE);
        double xScale = (r.width - 15)/sw;
        double yScale = r.height/sh;
        double x = r.x + xScale*(r.width - 15 - xScale*sw)/2;
        double y = r.getMaxY() - yScale*lm.getDescent();
        AffineTransform at =
                AffineTransform.getTranslateInstance(x, y);
        if (xScale != yScale) {
            if (xScale > yScale)
                xScale = yScale;
            else if (yScale > xScale)
                yScale = xScale;
        }
        at.scale(xScale, yScale);
        g2.setFont(font.deriveFont(at));
        g2.drawString(TXT, 0, 0);
    }
}
