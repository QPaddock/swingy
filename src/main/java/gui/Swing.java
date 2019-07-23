package gui;

import Player.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Swing {

    final JFrame f = new JFrame("Trying");

    public void Swings() {
        f.setSize(600, 600);
        f.setVisible(true);
    }

    public void showMenu() {
        final Menu men = new Menu();
        f.add(men.getPanel1());
        Swings();
    }

    public void initHero(String name, int cls) {
        Hero player = new Hero(name, cls);
        JLabel label = new JLabel();
        if (cls == 1) {
            ImageIcon img = new ImageIcon("Footsoldier.png");
            label.setIcon(img);
            label.setText("Foot Soldier");
        }
        else if (cls == 2) {
            ImageIcon img = new ImageIcon("Archer.png");
            label.setIcon(img);
            label.setText("Archer");
        }
        else if (cls == 3) {
            ImageIcon img = new ImageIcon("Knight.png");
            label.setIcon(img);
            label.setText("Knight");
        }
        game(label);
    }

    public void game(JLabel label) {
        final play newg = new play();
        newg.setLabel(label);
        f.getContentPane().add(newg.getPanel2());
        Swings();
    }

    public void clearScr() {
    }
}
