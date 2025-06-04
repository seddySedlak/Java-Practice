package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileInfoViewer extends JFrame {
    JButton button;
    JLabel nameLabel, typeLabel, sizeLabel;

    public FileInfoViewer() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 700);
        this.setLayout(new GridLayout(4, 1));
        this.setBackground(Color.cyan);
        this.setForeground(Color.magenta);

        this.setFont(new Font("Consolas", Font.PLAIN, 22));

        button = new JButton("select file");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("");
                int response = fileChooser.showOpenDialog(null);
                if (response == JFileChooser.APPROVE_OPTION){
                    File f = fileChooser.getSelectedFile();
                    nameLabel.setText(f.getName());
                    typeLabel.setText(f.getName().substring(f.getName().lastIndexOf(".")));
                    sizeLabel.setText((f.length()/1024) + " kb");
                }
            }
        });
        nameLabel = new JLabel("tmp");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setVerticalAlignment(SwingConstants.CENTER);
        nameLabel.setBackground(Color.blue);
        nameLabel.setOpaque(true);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 40));

        typeLabel = new JLabel("tmp");
        typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        typeLabel.setVerticalAlignment(SwingConstants.CENTER);
        typeLabel.setBackground(Color.orange);
        typeLabel.setOpaque(true);
        typeLabel.setFont(new Font("Arial", Font.BOLD, 40));

        sizeLabel = new JLabel("tmp");
        sizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sizeLabel.setVerticalAlignment(SwingConstants.CENTER);
        sizeLabel.setBackground(Color.green);
        sizeLabel.setOpaque(true);
        sizeLabel.setFont(new Font("Arial", Font.BOLD, 40));

        this.add(button);
        this.add(nameLabel);
        this.add(typeLabel);
        this.add(sizeLabel);
    }


    public static void main(String[] args) {
        new FileInfoViewer().setVisible(true);
    }
}
