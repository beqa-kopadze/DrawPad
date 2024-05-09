package drawpad;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a custom JPanel that can display and manage a collection of shapes.
 * It provides methods to add and remove shapes from the panel, and automatically redraws the panel
 * when the collection of shapes changes.
 */
public class DrawPadPanel extends JPanel {
    private final List<Shape> shapes; // List to store the shapes to be drawn

    /**
     * Default constructor that initializes an empty list of shapes.
     */
    public DrawPadPanel() {
        shapes = new ArrayList<>();
    }

    /**
     * Adds a new shape to the list of shapes and redraws the panel.
     *
     * @param shape the shape to be added
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    /**
     * Removes a shape from the list of shapes and redraws the panel.
     *
     * @param shape the shape to be removed
     */
    public void removeShape(Shape shape) {
        shapes.remove(shape);
        repaint();
    }

    /**
     * Overrides the paintComponent method of JPanel to draw all the shapes in the list.
     *
     * @param g the Graphics object on which to draw the shapes
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}