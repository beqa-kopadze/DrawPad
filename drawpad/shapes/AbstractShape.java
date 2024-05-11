package drawpad.shapes;

import drawpad.math.Vector2D;
import java.awt.*;

/**
 * This abstract class represents a generic shape and serves as a base class for concrete shape implementations.
 * It defines common properties and behavior for all shapes, such as color, position, and methods for resizing
 * and calculating the area. Concrete subclasses must implement the abstract methods.
 */
public abstract class AbstractShape implements Shape {
    private Color color; // The color of the shape
    private double pos_x; // The x-coordinate of the shape's position
    private double pos_y; // The y-coordinate of the shape's position
    private double position; // The 2D vector for the shape's position

    /**
     * Constructor to create an AbstractShape object with a specified color and position.
     *
     * @param color the color of the shape
     * @param pos_x the x-coordinate of the shape's position
     * @param pos_y the y-coordinate of the shape's position
     */
    public AbstractShape(Color color, double pos_x, double pos_y) {
        this.color = color;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    /**
     * Constructor to create an AbstractShape object with a specified color and position.
     *
     * @param color the color of the shape
     * @param position the x-coordinate of the shape's position
     */
    public AbstractShape(Color color, Vector2D position) {
        this.color = color;
        this.pos_x = position.x;
        this.pos_y = position.y;
    }

    /**
     * Constructor to create an AbstractShape object with a default color (black) and a specified position.
     *
     * @param pos_x the x-coordinate of the shape's position
     * @param pos_y the y-coordinate of the shape's position
     */
    public AbstractShape(double pos_x, double pos_y){
        this.color = Color.BLACK;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    /**
     * Constructor to create an AbstractShape object with a default color (black) and a specified position.
     *
     * @param position the y-coordinate of the shape's position
     */
    public AbstractShape(Vector2D position){
        this.pos_x = position.x;
        this.pos_y = position.y;
    }

    /**
     * Default constructor to create an AbstractShape object with a default color (black) and position (0, 0).
     */
    public AbstractShape(){
        this.color = Color.BLACK;
        this.pos_x = 0;
        this.pos_y = 0;
    }

    /**
     * Returns the shape's position.
     *
     * @return Vector2D
     */
    public Vector2D getPosition(){
        return new Vector2D(pos_x, pos_y);
    }

    /**
     * Returns the x-coordinate of the shape's position.
     *
     * @return the x-coordinate of the shape's position
     */
    public double getPos_x() {
        return pos_x;
    }

    /**
     * Returns the y-coordinate of the shape's position.
     *
     * @return the y-coordinate of the shape's position
     */
    public double getPos_y() {
        return pos_y;
    }

    /**
     * Sets the color of the shape.
     *
     * @param color the new color of the shape
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Sets the position of the shape using a Vector2D instance.
     *
     * @param position the new position of the shape
     */
    public void setPosition(Vector2D position) {
        this.pos_x = position.x;
        this.pos_y = position.y;
    }

    /**
     * Sets the x-coordinate of the shape's position.
     *
     * @param pos_x the new x-coordinate of the shape's position
     */
    public void setPos_x(double pos_x) {
        this.pos_x = pos_x;
    }

    /**
     * Sets the y-coordinate of the shape's position.
     *
     * @param pos_y the new y-coordinate of the shape's position
     */
    public void setPos_y(double pos_y) {
        this.pos_y = pos_y;
    }

    /**
     * Abstract method to resize the shape by a given factor.
     * Concrete subclasses must implement this method.
     *
     * @param factor the factor by which to resize the shape
     */
    public abstract void resize(double factor);

    /**
     * Abstract method to calculate and return the area of the shape.
     * Concrete subclasses must implement this method.
     *
     * @return the area of the shape
     */
    public abstract double getArea();

    /**
     * Returns the color of the shape.
     *
     * @return the color of the shape
     */
    public Color getColor() {
        return this.color;
    }
}
