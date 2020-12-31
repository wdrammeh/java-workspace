package gui.draw.graph;

import gui.MFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Illustrates the x-axis.
 * The mathematical Number Line.
 * @see YAxis
 */
public class XAxis extends Canvas {
    private List<Integer> points;
    private static final int PADDING = 35;
    private static final int DASH_LENGTH = 10;


    public static void main(String[] args) {
        MFrame.display("Number Line", new XAxis(-5, 10, 1));
    }

    /**
     * Constructs a horizontal axis within the given range of values, inclusive.
     * The scale should be understood as 1cm:scale unit.
     * Notice, if the maximum is not a multiple of the scale,
     * it will be augmented to make it a multiple;
     * this brought about an extra point after the given maximum.
     * The generated-points will be labelled along the axis.
     * Notice, also, this, depending on the end-points and the scale,
     * can skip any point including zero.
     */
    public XAxis(int from, int to, int scale){
        if (to % scale != 0) {
            to = to / scale * scale + scale;
        }
        points = new ArrayList<>();
        for (int i = from; i <= to; i += scale) {
            points.add(i);
        }
        setPreferredSize(new Dimension(600, 200));
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        final Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        rule the x-axis
        g.drawLine(PADDING, getHeight()/2, getWidth() - PADDING, getHeight()/2);
//        strike & label the line
        int length = getWidth() - 2 * PADDING;  // the actual length of the line
        for (int i = 0; i < points.size(); i++) {
            int x0 = ((i * length) / (points.size() - 1)) + PADDING;
            int y0 = getHeight()/2 + DASH_LENGTH/2;
            int x1 = x0;
            int y1 = y0 - DASH_LENGTH;
            g.drawLine(x0, y0, x1, y1);
            final String point = String.valueOf(points.get(i));
            final FontMetrics metrics = getFontMetrics(getFont());
            g.drawString(point, x0 - metrics.stringWidth(point)/2, y0 + PADDING/2);
        }
    }

}
