package hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class nextWindow extends JFrame {
    TextField textField;
    JRadioButton one, two, three, four, five;
    JButton correctBTN;
    PrintWriter pw;

    public nextWindow() throws IOException {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 100);
        this.setLayout(new GridLayout(1, 3));

        textField = new TextField("tmp");
        textField.setFont(new Font("Consolas", Font.PLAIN, 20));
//        textField.setPreferredSize(new Dimension(1000,100));
        textField.setForeground(Color.black);

        one = new JRadioButton();
        two = new JRadioButton();
        three = new JRadioButton();
        four = new JRadioButton();
        five = new JRadioButton();

        ButtonGroup group = new ButtonGroup();
        ArrayList<JRadioButton> buttons = new ArrayList<>();

        group.add(one);
        group.add(two);
        group.add(three);
        group.add(four);
        group.add(five);

        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(four);
        buttons.add(five);

        correctBTN = new JButton("OK");

        correctBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("files/secrets.txt"), true)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                for (int i = 0; i < buttons.size(); i++) {
                    if (buttons.get(i).isSelected()) {
                        switch (i) {
                            case 0:
                                pw.append("\n1;").append(textField.getText()).toString();
                                break;
                            case 1:
                                pw.append("\n2;").append(textField.getText()).toString();
                                break;
                            case 2:
                                pw.append("\n3;").append(textField.getText()).toString();
                                break;
                            case 3:
                                pw.append("\n4;").append(textField.getText()).toString();
                                break;
                            case 4:
                                pw.append("\n5;").append(textField.getText()).toString();
                                break;
                        }
                    }
                }
                pw.close();
            }
        });

        this.add(textField);
        this.add(one);
        this.add(two);
        this.add(three);
        this.add(four);
        this.add(five);
        this.add(correctBTN);
    }
}
