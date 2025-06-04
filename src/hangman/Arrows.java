package hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Arrows extends JFrame implements KeyListener {

    JLabel label;

    public Arrows() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);
        label = new JLabel();
        label.setBounds(0, 0, 100, 100);
        label.setBackground(Color.red);
        label.setOpaque(true);


        this.add(label);
    }

    public static void main(String[] args) {
        new Arrows().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JLabel footprint = new JLabel();
        footprint.setBounds(label.getX(), label.getY(), 20, 20);
        footprint.setBackground(Color.black);
        footprint.setOpaque(true);

        switch (e.getKeyChar()) {
            case 'a':
                label.setLocation(label.getX() - 10, label.getY());
                break;
            case 'w':
                label.setLocation(label.getX(), label.getY() - 10);
                break;
            case 's':
                label.setLocation(label.getX(), label.getY() + 10);
                break;
            case 'd':
                label.setLocation(label.getX() + 10, label.getY());
                break;
        }
        this.add(footprint);
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyChar());
//        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("zmacknuto: " + e.getKeyChar() + " a ma code: " + e.getKeyCode());
    }
}
