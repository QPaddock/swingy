package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JButton a1FootSoldierButton;
    private JPanel panel1;
    private JButton a3KnightButton;
    private JButton a2ArcherButton;
    private JTextField textField1;
    public String name;

    public Menu() {
        final Swing s = new Swing();
        a1FootSoldierButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = textField1.getText();
                s.initHero(name, 1);
            }
        });
        a2ArcherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = textField1.getText();
                s.initHero(name, 2);
            }
        });
        a3KnightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = textField1.getText();
                s.initHero(name, 3);
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
