package drawpad.shapes;

import drawpad.math.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * This class represents a rectangular shape, extending the AbstractShape class.
 * It contains methods to draw, calculate the area, resize, and access/modify
 * the width, height, color, and position of the rectangle.
 */
public class Rectangle extends AbstractShape{
    private double width;  // Width of the rectangle
    private double height; // Height of the rectangle

    /**
     * Constructor to create a Rectangle object with a specified color, width, height, position, and rotation.
     *
     * @param color    the color of the rectangle
     * @param width    the width of the rectangle
     * @param height   the height of the rectangle
     * @param pos_x    the x-coordinate of the rectangle's position
     * @param pos_y    the y-coordinate of the rectangle's position
     * @param rotation the rotation angle of the rectangle in radians
     */
    public Rectangle(Color color, double width, double height, double pos_x, double pos_y, double rotation) {
        super(color, pos_x, pos_y, rotation);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to create a Rectangle object with a specified color, width, height, and position.
     *
     * @param color the color of the rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param pos_x the x-coordinate of the rectangle's position
     * @param pos_y the y-coordinate of the rectangle's position
     */
    public Rectangle(Color color, double width, double height, double pos_x, double pos_y) {
        super(color, pos_x, pos_y);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to create a Rectangle object with a specified color, width, height, and position.
     *
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param pos_x the x-coordinate of the rectangle's position
     * @param pos_y the y-coordinate of the rectangle's position
     * @param rotation the rotation of the rectangle
     */
    public Rectangle(double width, double height, double pos_x, double pos_y, double rotation) {
        super(pos_x, pos_y, rotation);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to create a Rectangle object with a specified color, width, height, and position.
     *
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param pos_x the x-coordinate of the rectangle's position
     * @param pos_y the y-coordinate of the rectangle's position
     */
    public Rectangle(double width, double height, double pos_x, double pos_y) {
        super(pos_x, pos_y);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to create a Rectangle object with a specified color, width, height, and position.
     *
     * @param color the color of the rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param position the position of the rectangle
     * @param rotation the rotation of the rectangle
     */
    public Rectangle(Color color,double width, double height, Vector2D position, double rotation){
        super(color, position.x, position.y, rotation);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to create a Rectangle object with a specified color, width, height, and position.
     *
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param position the position of the rectangle
     * @param rotation the rotation of the rectangle
     */
    public Rectangle(double width, double height, Vector2D position, double rotation){
        super(position.x, position.y, rotation);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to create a Rectangle object with a specified color, width, height, and position.
     *
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param position the position of the rectangle
     */
    public Rectangle(double width, double height, Vector2D position){
        super(position.x, position.y);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to create a Rectangle object with a specified width and height.
     *
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param rotation the rotation of the rectangle
     */
    public Rectangle(double width, double height, double rotation) {
        super(rotation);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to create a Rectangle object with a specified width and height.
     *
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Draws the rectangle on the provided Graphics object using the stored color, position, width, height, and rotation.
     *
     * @param g the Graphics object on which to draw the rectangle
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Save the current transformation state of the graphics context
        AffineTransform oldTransform = g2d.getTransform();

        // Translate the graphics context to the center of the rectangle
        g2d.translate(getPos_x() + width / 2, getPos_y() + height / 2);

        // Rotate the graphics context by the specified rotation angle
        g2d.rotate(getRotation());

        // Translate back to the top-left corner of the rectangle
        g2d.translate(-width / 2, -height / 2);

        // Draw the rotated rectangle
        g2d.setColor(getColor());
        g2d.fillRect(0, 0, (int) width, (int) height);

        // Restore the original transformation state of the graphics context
        g2d.setTransform(oldTransform);
    }

    /**
     * Calculates and returns the area of the rectangle using the formula: area = width * height.
     *
     * @return the area of the rectangle
     */
    public double getArea() {
        return width * height;
    }

    /**
     * Resizes the rectangle by multiplying its width and height with the given factor.
     *
     * @param factor the factor by which to resize the rectangle
     */
    public void resize(double factor) {
        this.width = this.width * factor;
        this.height = this.height * factor;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the rectangle to the given value.
     *
     * @param height the new height of the rectangle
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the rectangle to the given value.
     *
     * @param width the new width of the rectangle
     */
    public void setWidth(double width) {
        this.width = width;
    }


    @Override
    public double getPos_x() {
        return super.getPos_x();
    }
    @Override
    public void setPos_x(double pos_x) {
        super.setPos_x(pos_x);
    }
    @Override
    public double getPos_y() {
        return super.getPos_y();
    }
    @Override
    public void setPos_y(double pos_y) {
        super.setPos_y(pos_y);
    }
    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }
    @Override
    public Color getColor() {
        return super.getColor();
    }
}
