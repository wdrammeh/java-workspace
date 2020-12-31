package gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for testing.
 * E.g: instead of creating a separate top-level container,
 * like the Frame for most classes, simply use
 * MyFrame.display(title, component)
 */
public class MFrame extends JFrame {

    public MFrame(String title){
        super(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
    }

    public static void display(String title, Component c){
        final MFrame myFrame = new MFrame(title);
        myFrame.add(c);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        SwingUtilities.invokeLater(()-> myFrame.setVisible(true));
    }

}
