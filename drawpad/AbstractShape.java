package drawpad;

import java.awt.*;

public abstract class AbstractShape implements Shape {
    private Color color;

    public AbstractShape(Color color) {
        this.color = color;
    }

    public abstract void resize(double factor);

    public abstract double getArea();

    public Color getColor() {
        return this.color;
    }


}
