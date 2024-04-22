package drawpad;

import java.awt.*;

public interface Shape {
    void draw(Graphics g);

    void resize(double factor);

    double getArea();
}
