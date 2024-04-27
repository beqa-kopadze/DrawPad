package drawpad;

import java.awt.*;

/**
 * This class represents a rectangular shape, extending the AbstractShape class.
 * It contains methods to draw, calculate the area, resize, and access/modify
 * the width, height, color, and position of the rectangle.
 */
public class Rectangle extends AbstractShape{
    private double width;  // Width of the rectangle
    private double height; // Height of the rectangle

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
     * Draws the rectangle on the provided Graphics object using the stored color, position, width, and height.
     *
     * @param g the Graphics object on which to draw the rectangle
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect((int)getPos_x(), (int)getPos_y(), (int)width, (int)height);
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
