package drawpad;

import javax.swing.*;
import java.awt.*;

public class DrawPadDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Draw Pad");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DrawPadPanel drawPadPanel = new DrawPadPanel();

            Shape circle = new Circle(Color.RED, 50);
//            Shape rectangle = new Rectangle(Color.blue, 100, 50);

            drawPadPanel.addShape(circle);
//            drawPadPanel.addShape(rectangle);

            frame.add(drawPadPanel);
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}
