package gui.layout;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Illustrates the horizontal box layout on a panel.
 * We can use "invisible components" to control sizing
 * withing a bax layout.
 * 1. Rigid Area: fixed-sized
 *  #use Box.createRigidArea
 * 2. Glue: grows as necessary; you can specify where the extra-space will go
 *  #use Box.create[Horizontal/Vertical]Glue
 * 3. filler: has a minimum, preferred, and maximum sizes
 *  #use the Box.Filler type
 */
public class XBox {

    public static void main(String[] args) {
        final JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 300));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        for (int i = 1; i <= 5;) {
            panel.add(new JButton(String.format("Button %d", i++)));
        }

        MFrame.display("XBox Layout", panel);
    }

}
