package OOP.HUB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardMenu extends JFrame {
    JLabel fullName, salary, shoeSize;
    ImageIcon avatar;
    JPanel lowerMenu;
    JButton next, previous, last, first;
    int page;


    CardMenu() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setResizable(false);

        page = 0;

        this.setLayout(new BorderLayout());
        lowerMenu = new JPanel();
        lowerMenu.setLayout(new FlowLayout());


        fullName = new JLabel();
        salary = new JLabel();
        shoeSize = new JLabel();


        fullName.setFont(new Font("MV Boli", Font.BOLD, 18));
        salary.setFont(new Font("MV Boli", Font.BOLD, 18));
        shoeSize.setFont(new Font("MV Boli", Font.BOLD, 18));

        avatar = new ImageIcon(MainMenu.personData.get(0).avatar.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT));
        fullName.setText("Full name: " + MainMenu.personData.get(0).name + " " + MainMenu.personData.get(0).surname);
        shoeSize.setText("Shoe size: " + MainMenu.personData.get(0).shoeSize);
        salary.setText("Salary: " + MainMenu.personData.get(0).salary);

        fullName.setIcon(avatar);
        fullName.setHorizontalTextPosition(JLabel.CENTER);
        fullName.setVerticalTextPosition(JLabel.TOP);
        fullName.setIconTextGap(5);
        fullName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        this.add(fullName, BorderLayout.CENTER);

        previous = new JButton("Previous");
        next = new JButton("Next");
        first = new JButton("First");
        last = new JButton("Last");
        lowerMenu.add(first);
        lowerMenu.add(previous);
        lowerMenu.add(shoeSize);
        lowerMenu.add(salary);
        lowerMenu.add(next);
        lowerMenu.add(last);

        this.add(lowerMenu, BorderLayout.SOUTH);
        this.pack();

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page++;
                avatar = new ImageIcon(MainMenu.personData.get(page).avatar.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT));
                fullName.setText("Full name: " + MainMenu.personData.get(page).name + " " + MainMenu.personData.get(page).surname);
                shoeSize.setText("Shoe size: " + MainMenu.personData.get(page).shoeSize);
                salary.setText("Salary: " + MainMenu.personData.get(page).salary);
                fullName.setIcon(avatar);
                if (page >= MainMenu.personData.size() - 1) {
                    next.setEnabled(false);
                }
                setButtons();
            }
        });
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page--;
                avatar = new ImageIcon(MainMenu.personData.get(page).avatar.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT));
                fullName.setText("Full name: " + MainMenu.personData.get(page).name + " " + MainMenu.personData.get(page).surname);
                shoeSize.setText("Shoe size: " + MainMenu.personData.get(page).shoeSize);
                salary.setText("Salary: " + MainMenu.personData.get(page).salary);
                fullName.setIcon(avatar);
                if (page == 0) {
                    previous.setEnabled(false);
                }
                setButtons();
            }
        });
        previous.setEnabled(false);
        first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page = 0;
                avatar = new ImageIcon(MainMenu.personData.get(page).avatar.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT));
                fullName.setText("Full name: " + MainMenu.personData.get(page).name + " " + MainMenu.personData.get(page).surname);
                shoeSize.setText("Shoe size: " + MainMenu.personData.get(page).shoeSize);
                salary.setText("Salary: " + MainMenu.personData.get(page).salary);
                fullName.setIcon(avatar);
                setButtons();
            }
        });
        last.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page = MainMenu.personData.size() - 1;
                avatar = new ImageIcon(MainMenu.personData.get(page).avatar.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT));
                fullName.setText("Full name: " + MainMenu.personData.get(page).name + " " + MainMenu.personData.get(page).surname);
                shoeSize.setText("Shoe size: " + MainMenu.personData.get(page).shoeSize);
                salary.setText("Salary: " + MainMenu.personData.get(page).salary);
                fullName.setIcon(avatar);
                setButtons();
            }
        });
    }

    void setButtons() {
        if (page > 0) {
            previous.setEnabled(true);
        } else {
            previous.setEnabled(false);
        }
        if (page < MainMenu.personData.size() - 1) {
            next.setEnabled(true);
        } else {
            next.setEnabled(false);
        }
    }
}
