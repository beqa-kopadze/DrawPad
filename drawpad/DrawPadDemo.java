package drawpad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPadDemo implements ActionListener {
    private DrawPadPanel drawPadPanel;

    private Circle circle;
    private Rectangle rectangle;
    private Rectangle rectangle2;

    public DrawPadDemo() {
        SwingUtilities.invokeLater(this::createAndShowGUI);
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Draw Pad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPadPanel = new DrawPadPanel();

        circle = new Circle(Color.RED, 50, 5, 5);
        rectangle = new Rectangle(Color.BLUE, 100, 50, 100, 50);
        rectangle2 = new Rectangle(12, 5);

        drawPadPanel.addShape(rectangle);
        drawPadPanel.addShape(rectangle2);
        drawPadPanel.addShape(circle);

        frame.add(drawPadPanel);
        frame.setSize(400, 300);
        frame.setVisible(true);

        Timer timer = new Timer(1000 / 60, this); // 60 frames per second
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update objects here
        // Example: Move the circle horizontally
        circle.setPos_x(circle.getPos_x() + 1);
        rectangle.setPos_x(rectangle.getPos_x()+2);
        rectangle.resize(1.01d);
        drawPadPanel.repaint();
    }

    public static void main(String[] args) {
        new DrawPadDemo();
    }
}
