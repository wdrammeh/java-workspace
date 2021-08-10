package gui.layout;

import gui.MFrame;

import java.applet.Applet;
import java.awt.*;

/**
 * Illustrates the grid-bag layout.
 * A flexible layout manager that aligns components vertically,
 * horizontally or along their baseline without requiring that
 * the components be of the same size.
 * Each GridBagLayout object maintains a dynamic, rectangular grid of cells,
 * with each component occupying one or more cells, called its display area.
 * Each component managed by a GridBagLayout is associated with an instance of
 * a GridBagConstraints; which specifies where a component's display area
 * should be located on the grid and how the component should be positioned
 * within its display area.
 * @see GridBagLayout
 */
public class GridBag extends Applet {

    public static void main(String[] args) {
        final GridBag bag = new GridBag();
        bag.init();
        MFrame.display("GridBag Layout", bag);
    }

    @Override
    public void init() {
        final GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
        setFont(new Font("SansSerif", Font.PLAIN, 14));

        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        makeButton("Button1", gridBag, c);
        makeButton("Button2", gridBag, c);
        makeButton("Button3", gridBag, c);
        c.gridwidth = GridBagConstraints.REMAINDER; // end row
        makeButton("Button4", gridBag, c);

        c.weightx = 0.0;                // reset to the default
        makeButton("Button5", gridBag, c); // another row

        c.gridwidth = GridBagConstraints.RELATIVE; // next-to-last in row
        makeButton("Button6", gridBag, c);

        c.gridwidth = GridBagConstraints.REMAINDER; // end row
        makeButton("Button7", gridBag, c);

        c.gridwidth = 1;                // reset to the default
        c.gridheight = 2;
        c.weighty = 1.0;
        makeButton("Button8", gridBag, c);

        c.weighty = 0.0;                // reset to the default
        c.gridwidth = GridBagConstraints.REMAINDER; // end row
        c.gridheight = 1;               // reset to the default
        makeButton("Button9", gridBag, c);
        makeButton("Button10", gridBag, c);

        setPreferredSize(new Dimension(500, 300));
    }

    protected void makeButton(String name, GridBagLayout gridBag, GridBagConstraints c) {
        final Button button = new Button(name);
        gridBag.setConstraints(button, c);
        add(button);
    }

}
