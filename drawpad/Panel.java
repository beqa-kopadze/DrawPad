package drawpad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Panel implements ActionListener {
    private DrawPadPanel drawPadPanel = new DrawPadPanel();
    private InputManager input = new InputManager();
    private int with = 400;
    private int height = 800;
    private int fps = 16; // 60 frames per sec
    private String title;


    public abstract void start();

    public abstract void update();

    //this is a method which gets updated 60 times in a second
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }

    private void createAndShowGUI() {
        start();
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drawPadPanel);
        frame.setSize(with, height);
        frame.setVisible(true);
        // Set up key bindings for the DrawPadPanel
        input.setupKeyBindings(drawPadPanel);
        Timer timer = new Timer(fps, this); // 60 frames per second
        timer.start();
    }

    public void inwoke(){
        SwingUtilities.invokeLater(this::createAndShowGUI);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getWith() {
        return with;
    }

    public void setWith(int with) {
        this.with = with;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public void setPanel(DrawPadPanel drawPadPanel) {
        this.drawPadPanel = drawPadPanel;
    }

    public DrawPadPanel getPanel() {
        return drawPadPanel;
    }
}
