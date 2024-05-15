package drawpad.demos;

import drawpad.shapes.Circle;
import drawpad.draw.DrawPadPanel;
import drawpad.shapes.Rectangle;
import drawpad.shapes.Triangle;
import drawpad.input.InputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class DrawPadDemo implements ActionListener {
    private DrawPadPanel drawPadPanel;
    private InputManager input;

    private Circle circle;
    private Rectangle rectangle;
    private Rectangle rectangle2;
    private Triangle triangle;
    private Triangle triangle2;
    private int count;

    public DrawPadDemo() {
        SwingUtilities.invokeLater(this::createAndShowGUI);
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Draw Pad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPadPanel = new DrawPadPanel();
        input = new InputManager();
        // Set up key bindings for the DrawPadPanel
        input.setupKeyBindings(drawPadPanel);

        start();

        frame.add(drawPadPanel);
        frame.setSize(400, 300);
        frame.setVisible(true);

        Timer timer = new Timer(1000 / 60, this); // 60 frames per second
        timer.start();
    }

    private void start() {
        circle = new Circle(Color.RED, 50, 5, 5);
        rectangle = new drawpad.shapes.Rectangle(Color.BLUE, 100, 50, 100, 50);
        rectangle2 = new Rectangle(12, 5);
        triangle = new Triangle(Color.RED, 100, 80, 50, 0);
        triangle2 = new Triangle(Color.BLUE, 80, 100, 100, Math.PI / 3); // Equilateral triangle with side length 80, positioned at (100, 100), rotated by 60 degrees

        drawPadPanel.addShape(triangle2);
        drawPadPanel.addShape(triangle);
        drawPadPanel.addShape(rectangle);
        drawPadPanel.addShape(rectangle2);
        drawPadPanel.addShape(circle);

        count = 0;
    }

    private void update(){
        circle.setPos_x(circle.getPos_x() + 1);
        rectangle.setRotation(rectangle.getRotation() + 0.05d);
        drawPadPanel.repaint();
    }

    private void checkInputs(){
        // Check if the "W" key is pressed
        if (input.isKeyDown(KeyEvent.VK_W)) {
            System.out.println("W key is pressed");
            count++;
        } else {
            System.out.println(count);
        }

        if (input.isKeyDown(KeyEvent.VK_A)){
            triangle.setRotation(triangle.getRotation() + 2 * Math.PI / 120); // Increment rotation angle by 2π/60 radians

            if (triangle.getRotation() >= 2 * Math.PI) {
                triangle.setRotation(0);
            }
        }else if(input.isKeyDown(KeyEvent.VK_D)){
            triangle.setRotation(triangle.getRotation() - 2 * Math.PI / 120); // Increment rotation angle by 2π/60 radians

            if (triangle.getRotation() >= 2 * Math.PI) {
                triangle.setRotation(0);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkInputs();
        update();
    }

    public static void main(String[] args) {
        new DrawPadDemo();
    }
}
