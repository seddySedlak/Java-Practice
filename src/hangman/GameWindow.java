package hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    JProgressBar progressBar;
    JButton submitButton;
    JTextField inputField;
    SecretLabel label;
    int difficulty;

    GameWindow(int difficulty) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 700);
        this.difficulty = difficulty;
        init();
    }

    void init() {
        this.setLayout(new BorderLayout());
        progressBar = new JProgressBar(0, 10);
        progressBar.setValue(10);
        progressBar.setForeground(Color.red);
        progressBar.setBackground(Color.black);
        progressBar.setPreferredSize(new Dimension(500, 100));
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("MV Boli", Font.BOLD, 36));

        label = new SecretLabel(4);
        this.add(label, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.blue);
        inputPanel.setPreferredSize(new Dimension(500, 150));
        this.add(inputPanel, BorderLayout.SOUTH);

        //input text:
        inputField = new JTextField("");
        inputField.setPreferredSize(new Dimension(100, 50));
        inputField.setFont(new Font("MV Boli", Font.PLAIN, 32));
        inputField.setHorizontalAlignment(SwingConstants.CENTER);

        //button setting
        submitButton = new JButton("Guess");
        submitButton.setFont(new Font("MV Boli", Font.PLAIN, 32));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputField.getText().length() > 1) {
                    incorrect(2);
                }else {
                    makeAGuess(inputField.getText().charAt(0));
                    char c = inputField.getText().charAt(0);
                    makeAGuess(Character.toLowerCase(c));
                }
                inputField.setText("");
            }
        });

        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(inputField);
        inputPanel.add(submitButton);

        this.add(progressBar, BorderLayout.NORTH);
        this.getRootPane().setDefaultButton(submitButton);
        this.pack();
        this.setSize(this.getWidth(), 700);
    }

    void makeAGuess(char guess) {
        if (label.secret.indexOf(guess) >= 0) {
            System.out.println("Guess!");
            label.guessed.add(guess);
            label.reprint();
            this.pack();
            this.setSize(this.getWidth(), 700);
            if (!label.text.contains("_")){
                submitButton.setEnabled(false);
                inputField.setEnabled(false);
                progressBar.setForeground(Color.yellow);
                progressBar.setValue(10);
                progressBar.setStringPainted(true);
                progressBar.setString("Winner");
            }

        } else {
            progressBar.setValue(progressBar.getValue() - 1);
            if (progressBar.getValue() < 1) {
                label.setText("GAME OVER!");
                submitButton.setEnabled(false);
                inputField.setEnabled(false);
            }
        }
    }
    private void incorrect(int toRemove){
        progressBar.setValue(progressBar.getValue() - 1);
        if (progressBar.getValue() < 1) {
            label.setText("GAME OVER!");
            submitButton.setEnabled(false);
            inputField.setEnabled(false);
        }
    }
}
