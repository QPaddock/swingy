package gui;

import javax.swing.*;

public class play {
    private JButton westButton;
    private JButton eastButton;
    private JButton northButton;
    private JButton southButton;
    private JLabel label;
    private JPanel panel2;

    public void setLabel(JLabel label) {
        this.label.setIcon(label.getIcon());
        this.label.setText(label.getText());
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public JLabel getLabel() {
        return label;
    }
}
