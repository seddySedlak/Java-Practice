package OOP.HUB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends JFrame implements ActionListener {

    static List<Person> personData = new ArrayList<>();
    JButton tableView, dataView, dataLoad;
    JLabel status;

    public MainMenu() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        tableView = new JButton("Table");
        dataView = new JButton("Data");

        dataView.setEnabled(false);
        tableView.setEnabled(false);

        status = new JLabel("There are no data loaded!");
        status.setFont(new Font("MV Boli", Font.BOLD, 21));

        dataLoad = new JButton("Load persons");
        dataLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<String> data = Files.readAllLines(Paths.get("files/persons.txt"));

                    for (String line : data) {
                        String[] att = line.split(";");
                        personData.add(new Person(att[0], att[1], Integer.parseInt(att[2]), Integer.parseInt(att[3]), att[4]));
                    }
                } catch (IOException ioException) {
                    System.err.println(":(");
                }

                status.setText(personData.size() + " records loaded! You can now view the dataset!");
                tableView.setEnabled(true);
                dataView.setEnabled(true);
                dataLoad.setEnabled(false);
                pack();
            }
        });

        tableView.addActionListener(this);
        dataView.addActionListener(this);

        this.add(dataLoad);
        this.add(status);
        this.add(tableView);
        this.add(dataView);
        this.pack();
    }

    public void run() {
        MainMenu loader = new MainMenu();
        loader.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tableView)
            new TableMenu().setVisible(true);
        if (e.getSource() == dataView)
            new CardMenu().setVisible(true);
    }
}
