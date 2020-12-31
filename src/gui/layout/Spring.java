package gui.layout;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

public class Spring {

    public static void main(String[] args) {
        Container container = new JPanel();
        container.setPreferredSize(new Dimension(400, 200));
        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);
        JLabel label = new JLabel("Label: ");
        JTextField textField = new JTextField("Text Field", 15);
        container.add(label);
        container.add(textField);
        layout.putConstraint(SpringLayout.WEST, label,10, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, label,10, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, textField,10, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, textField,10, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.EAST, container,10, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.SOUTH, container,10, SpringLayout.SOUTH, textField);

        MFrame.display("Spring Layout", container);
    }

}
