package OOP.HUB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyHub extends JFrame implements ActionListener {
    JLabel hublabel;
    JPanel multiplePanel;
    JButton ex1, ex2, ex3, ex4, ex5;

    public MyHub() {
        this.setLayout(new GridLayout(2, 1));
        this.setSize(700, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("KFC HUB");
        this.setIconImage(new ImageIcon("files/kfc_logo.jpg").getImage());
//        design();

        hublabel = new JLabel();
        hublabel.setText("KFC Hub");
        hublabel.setHorizontalAlignment(SwingConstants.CENTER);
        hublabel.setFont(new Font("Arial", Font.BOLD, 50));
        hublabel.setBackground(new Color(0x1e1e1e));
        hublabel.setForeground(Color.white);
        hublabel.setOpaque(true);
        this.add(hublabel);
        multiplePanel = new JPanel();
        multiplePanel.setLayout(new GridLayout(1, 5, 5, 0));
        multiplePanel.setBackground(new Color(0x1e1e1e));
        multiplePanel.setOpaque(true);
        this.add(multiplePanel);
        ex1 = new JButton("Parsing");
        buttonDesign(ex1, new Color(0xA3080B), new Font("Aptos", Font.BOLD, 20), true, false);
        ex1.addActionListener(this);

        ex2 = new JButton("Interface");
        buttonDesign(ex2, new Color(0x000000), new Font("Aptos", Font.BOLD, 20), true, false);
        ex2.addActionListener(this);

        ex3 = new JButton("Exception");
        buttonDesign(ex3, new Color(0xFFFFFF), new Font("Aptos", Font.BOLD, 20), true, false);
        ex3.addActionListener(this);

        ex4 = new JButton("Files");
        buttonDesign(ex4, new Color(0xFFF1E2), new Font("Aptos", Font.BOLD, 20), true, false);
        ex4.addActionListener(this);

        ex5 = new JButton("Card Menu");
        buttonDesign(ex5, new Color(0xF5D4B7), new Font("Aptos", Font.BOLD, 20), true, false);
        ex5.addActionListener(this);

        multiplePanel.add(ex1);
        multiplePanel.add(ex2);
        multiplePanel.add(ex3);
        multiplePanel.add(ex4);
        multiplePanel.add(ex5);
    }

    public static void main(String[] args) {
        new MyHub().setVisible(true);

    }

    void buttonDesign(JButton ex, Color color, Font font, boolean opaque, boolean focusable) {
        ex.setBackground(color);
        ex.setOpaque(opaque);
        ex.setFont(font);
        ex.setFocusable(focusable);
    }

    public void design() {
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacDarkLaf");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ex1) {
            new parsing().run();
            System.out.println(ex1.getText() + " byl spuštěn!");
        }
        if (e.getSource() == ex2) {
            new Computers().run();
            System.out.println(ex2.getText() + " byl spuštěn!");
        }
        if (e.getSource() == ex3) {
            try {
                new practiceException().run();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(ex3.getText() + " byl spuštěn!");
        }
        if (e.getSource() == ex4) {
            new filePractice1().run();
            System.out.println(ex4.getText() + " byl spuštěn!");
        }
        if (e.getSource() == ex5) {
            new MainMenu().setVisible(true);
            System.out.println(ex5.getText() + " byl spuštěn!");
        }
    }
}
