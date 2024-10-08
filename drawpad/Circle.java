package drawpad;

import java.awt.*;

/**
 * This class represents a Circle shape, extending the AbstractShape class.
 * It contains methods to draw, calculate the area, resize, and access/modify
 * the radius, color, and position of the circle.
 */
public class Circle extends AbstractShape {

    private double radius;
    /**
     * Constructor to create a Circle object with a specified color, radius, and position.
     *
     * @param color the color of the circle
     * @param radius the radius of the circle
     * @param pos_x the x-coordinate of the circle's position
     * @param pos_y the y-coordinate of the circle's position
     */
    public Circle(Color color, double radius, double pos_x, double pos_y) {
        super(color, pos_x, pos_y);
        this.radius = radius;
    }

    /**
     * Constructor to create a Circle object with a specified radius and position.
     *
     * @param radius the radius of the circle
     * @param pos_x the x-coordinate of the circle's position
     * @param pos_y the y-coordinate of the circle's position
     */
    public Circle(double radius, double pos_x, double pos_y){
        super(pos_x, pos_y);
        this.radius = radius;
    }

    /**
     * Constructor to create a Circle object with a specified radius and position.
     *
     * @param radius the radius of the circle
     * @param position the position of the circle
     */
    public Circle(double radius, Vector2D position){
        super(position.x, position.y);
        this.radius = radius;
    }

    /**
     * Constructor to create a Circle object with a specified radius.
     *
     * @param radius the radius of the circle
     */
    public Circle(double radius){
        this.radius = radius;
    }


    /**
     * Draws the circle on the provided Graphics object using the stored color, position, and radius.
     *
     * @param g the Graphics object on which to draw the circle
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval((int)getPos_x(), (int)getPos_y(), (int) (2 * radius), (int) (2 * radius));
    }

    /**
     * Calculates and returns the area of the circle using the formula: area = π * radius^2.
     *
     * @return the area of the circle
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Resizes the circle by multiplying its radius with the given factor.
     *
     * @param factor the factor by which to resize the circle
     */
    public void resize(double factor) {
        this.radius = this.radius * factor;
    }

    /**
     * Returns the radius of the circle.
     *
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle to the given value.
     *
     * @param radius the new radius of the circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }
    @Override
    public void setColor(Color color) {
        super.setColor(color);
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
}
