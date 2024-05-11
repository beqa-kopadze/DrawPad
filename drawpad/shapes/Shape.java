package drawpad.shapes;

import java.awt.*;

/**
 * This interface defines the common behavior and methods that all concrete shape implementations should have.
 * It serves as a contract for any class that wants to represent a shape.
 */
public interface Shape {
    /**
     * Draws the shape on the provided Graphics object.
     *
     * @param g the Graphics object on which to draw the shape
     */
    void draw(Graphics g);

    /**
     * Resizes the shape by a given factor.
     *
     * @param factor the factor by which to resize the shape
     */
    void resize(double factor);

    /**
     * Calculates and returns the area of the shape.
     *
     * @return the area of the shape
     */
    double getArea();
}
