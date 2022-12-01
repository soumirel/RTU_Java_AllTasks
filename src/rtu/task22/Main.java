package rtu.task22;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        new ImageAnimation();
    }
}

class ImageAnimation extends JPanel {

    private JFrame frame;
    private Timer timer;
    private Image image;

    private String rawPath = "C:\\Users\\soumireL\\Pictures\\Aseprite\\flower_animation_by_shots\\flower";
    private int shotNumber = 1;

    public ImageAnimation() {
        frame = new JFrame("Application name");
        frame.setSize(320, 320);
        frame.add(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        image = new ImageIcon(rawPath + Integer.toString(shotNumber) + ".png").getImage();
        timer = new Timer();
        timer.schedule(animate, 1,100);
    }

    TimerTask animate = new TimerTask() {

        @Override
        public void run() {
            shotNumber++;
            if (shotNumber > 110) {
                shotNumber = 1;
            }
            image = new ImageIcon(rawPath + Integer.toString(shotNumber) + ".png").getImage();
            repaint();
        }
    };

    public void paint(Graphics canvas) {
        canvas.drawImage(image, 0, 0,  null);
    }
}