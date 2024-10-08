package demos;
import drawpad.*;
import drawpad.Panel;

import java.awt.*;

public class PanelDemo extends Panel {

    Triangle triangle = new Triangle(Color.BLUE, 20,30,30);

    @Override
    public void start() {
        System.out.println("Window has started");
        setTitle("window2");
        setHeight(400);
        setWith(400);
        super.getPanel().addShape(triangle);
    }

    @Override
    public void update() {
        triangle.setPos_x(triangle.getPos_x() + 0.1);
        super.getPanel().repaint();
    }

    public static void main(String[] args){
        PanelDemo panel = new PanelDemo();
        panel.inwoke();
    }
}
