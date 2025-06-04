package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimonWindow extends JFrame {
    final int DIFICULTY = 5;
    JButton startButton, replayButton;
    JPanel gridPanel, buttonsPanel;
    String sequence;
    String input = "";
    ArrayList<SimonButton> buttons = new ArrayList<>();

    SimonWindow() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
        replayButton = new JButton("Replay sequence");
        startButton = new JButton("Play");
        gridPanel = new JPanel();
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2));
        replayButton.setEnabled(false);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replayButton.setEnabled(true);
                sequence = getSequence(DIFICULTY);
                highlightSequence(500, new Color(0x03F825));
//                gridPanel.paintImmediately(0,0,getWidth(),getHeight());
                input = "";
            }
        });

        gridPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            SimonButton toAdd = new SimonButton(String.valueOf(i + 1));
            gridPanel.add(toAdd);
            buttons.add(toAdd);
            toAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    input += toAdd.getText();
                    if (input.length() == DIFICULTY) {
                        boolean win;
                        if (sequence.equals(input)) {
                            win = true;
                        } else {
                            win = false;
                        }
                        evaluate(win);
                        input = "";

                    }
                    System.out.println("Input: " + input);

                }
            });
        }
        this.add(buttonsPanel, BorderLayout.NORTH);
        buttonsPanel.add(startButton);

        buttonsPanel.add(replayButton);
        replayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                highlightSequence(1000, Color.orange);
            }
        });
        this.add(gridPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new SimonWindow().setVisible(true);
    }

    String getSequence(int length) {
        String sequence = "";
        for (int i = 0; i < length; i++) {
            sequence += buttons.get((int) (Math.random() * buttons.size())).getText();
        }
        System.out.println("Cheat:" + sequence);
        return sequence;
    }

    void highlightSequence(int time, Color color) {
        Color original;
        for (int i = 0; i < sequence.length(); i++) {
            for (JButton toHighlight : buttons) {
                if (toHighlight.getText().charAt(0) == sequence.charAt(i)) {
                    original = toHighlight.getBackground();
                    toHighlight.setBackground(color);
                    toHighlight.paintImmediately(0, 0, getWidth(), getHeight());
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        System.out.println("Thread died :/");
                    }

                    toHighlight.setBackground(original);
                    toHighlight.paintImmediately(0, 0, getWidth(), getHeight());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        System.out.println("Thread died :/");
                    }
                }
            }
        }
    }

    void evaluate(boolean win) {
        String message;
        String title;

        if (win) {
            message = "Well done! You repeated the sequence correctly. Play again?";
            title = "You Win!";
        } else {
            message = "Wrong sequence! Want to try again?";
            title = "You Lose!";
        }

        int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            resetGame(); // restart the game
        }else{
            System.exit(0);
        }
    }

    void resetGame() {
        replayButton.setEnabled(true);
        sequence = getSequence(DIFICULTY);
        highlightSequence(500, new Color(0x03F825));
    }

}

class SimonButton extends JButton {

    SimonButton(String text) {
        this.setText(text);
        this.setBackground(Color.cyan);
        this.setForeground(Color.black);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.setFont(new Font("Consolas", Font.BOLD, 32));
        this.setFocusable(false);
    }
}
