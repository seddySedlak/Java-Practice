package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class BubbleSortVisualization extends JFrame implements ActionListener {
    Integer[] array;
    JButton sortButton;
    JLabel[] labels;

    BubbleSortVisualization(Integer[] array) {
        this.array = array;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, array.length));
        labels = new JLabel[array.length];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            this.add(labels[i]);
        }
        formatLabels();
        visualizeArray();
        sortButton = new JButton("Sort Array");
        sortButton.addActionListener(this);
        sortButton.setBackground(Color.darkGray);
        sortButton.setFont(new Font("Consolas", Font.PLAIN, 24));
        sortButton.setForeground(Color.WHITE);
        sortButton.setFocusable(false);
        this.add(sortButton);
        this.pack();
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacDarkLaf");
        Integer[] array = {8, 6, 4, 2, 9, 11, 5, 10, 42, 7};
        BubbleSortVisualization visualization = new BubbleSortVisualization(array);
        visualization.setVisible(true);
    }

    void visualizeArray() {
        for (int i = 0; i < array.length; i++) {
            labels[i].setText(String.valueOf(array[i]));
            labels[i].paintImmediately(0, 0, getWidth(), getHeight());
        }
    }

    void highlight(Color color, int index) {
        labels[index].setBackground(color);
        labels[index].paintImmediately(0, 0, getWidth(), getHeight());
        labels[index].setForeground(Color.black);
    }

    void formatLabels() {
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        for (JLabel label : labels) {
            label.setFont(new Font("MV Boli", Font.PLAIN, 48));
            label.setBorder(border);
            label.setOpaque(true);// it will be usefull :)
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.CENTER);
        }
    }

    void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Thread died :( yikes");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sortButton) {
            sortButton.setText("Sorting...");
            sortButton.setEnabled(false);
            sortButton.paintImmediately(0, 0, getWidth(), getHeight());
//            do some magic
            bubbleSort(array);
            printArray(array);
            sortButton.setText("Sorted!");
        }
    }

    void printArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.println(Arrays.toString(array));
    }


    void bubbleSort(Integer[] toSort) {
        Integer tmp;
        for (int i = 0; i < toSort.length - 1; i++) {
            for (int j = 0; j < toSort.length - i - 1; j++) {
                if (toSort[j].compareTo(toSort[j + 1]) > 0) {
                    tmp = toSort[j];
                    highlight(Color.blue, j);
                    highlight(Color.green, j + 1);
                    pause();
                    toSort[j] = toSort[j + 1];
                    highlight(Color.green, j);
                    highlight(Color.blue, j + 1);
                    toSort[j + 1] = tmp;
                    visualizeArray();
                    pause();
                    highlight(Color.white, j);
                    highlight(Color.white, j + 1);
                }
            }
        }
    }
}
