package drawpad;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Triangle extends AbstractShape {
    private double base;

    public Triangle(Color color, double base, double pos_x, double pos_y, double rotation) {
        super(color, pos_x, pos_y, rotation);
        this.base = base;
    }

    public Triangle(Color color, double base, double pos_x, double pos_y) {
        super(color, pos_x, pos_y);
        this.base = base;
    }

    public Triangle(double base, Vector2D position, double rotation) {
        super(position.x, position.y, rotation);
        this.base = base;
    }

    public Triangle(double base, Vector2D position) {
        super(position.x, position.y);
        this.base = base;
    }

    public Triangle(double base){
        this.base = base;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor());

        AffineTransform oldTransform = g2d.getTransform();

        // Calculate the center of the triangle
        double centerX = getPos_x() + base / 2;
        double centerY = getPos_y() + (Math.sqrt(3) * base) / 4; // Height of an equilateral triangle = (sqrt(3) * sideLength) / 2

        // Translate to the center, rotate, and translate back
        g2d.translate(centerX, centerY);
        g2d.rotate(super.getRotation());
        g2d.translate(-base / 2, -(Math.sqrt(3) * base) / 4);

        // Draw the rotated equilateral triangle
        int[] xPoints = {0, (int) base, (int) base / 2};
        int[] yPoints = {0, 0, (int) (Math.sqrt(3) * base) / 2};
        g2d.fillPolygon(xPoints, yPoints, 3);

        g2d.setTransform(oldTransform);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public void resize(double factor) {
        base *= factor;
    }

    @Override
    public double getArea() {
        return (base*base)*0.43301270189f;
    }
}
