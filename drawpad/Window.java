package drawpad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends AbstractWindow implements ActionListener {
    private InputManager input = new InputManager();
    private int with = 800;
    private int height = 800;
    private int fps = 16; // 60 frames per sec
    private String title = "New Panel";

    public void start() {

    }

    public void update(){

    }

    //this is a method which gets updated 60 times in a second
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }

    private void createAndShowGUI() {
        start();
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(with, height);
        frame.setVisible(true);
        // Set up key bindings for the DrawPadPanel
        input.setupKeyBindings(this);
        Timer timer = new Timer(fps, this); // 60 frames per second
        timer.start();
    }

    public void invoke(){
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
}