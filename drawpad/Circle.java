package drawpad;

import java.awt.*;

public class Circle extends AbstractShape {

    private double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    public void resize(double factor) {
        this.radius = this.radius * factor;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(50, 50, (int) (2 * radius), (int) (2 * radius));
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
