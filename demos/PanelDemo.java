package demos;
import drawpad.Circle;
import drawpad.Window;

import java.awt.*;

public class PanelDemo extends Window {
    Circle circle = new Circle(Color.BLUE, 50,50,50);

    @Override
    public void start() {
        addShape(circle);
    }

    @Override
    public void update() {
        circle.setRadius(circle.getRadius()+1);
        repaint();
    }

    public static void main(String[] args){
        PanelDemo panel = new PanelDemo();
        panel.invoke();
    }
}
