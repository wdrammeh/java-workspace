package gui.draw.graph;

import gui.MFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Illustrates the y-axis.
 * @see XAxis
 */
public class YAxis extends Canvas {
    private List<Integer> points;
    private static final int PADDING = 35;
    private static final int DASH_LENGTH = 10;


    public static void main(String[] args) {
        MFrame.display("Y Axis", new YAxis(-5, 10, 1));
    }

    /**
     * Constructs a vertical axis within the given range of values, inclusive.
     * The scale should be understood as 1cm:scale unit.
     * Notice, if the maximum is not a multiple of the scale,
     * it will be augmented to make it a multiple;
     * this brought about an extra point after the given maximum.
     * The generated-points will be labelled along the axis.
     * Notice, also, this, depending on the end-points and the scale,
     * can skip any point including zero.
     */
    public YAxis(int from, int to, int scale){
        if (to % scale != 0) {
            to = to / scale * scale + scale;
        }
        points = new ArrayList<>();
        for (int i = from; i <= to; i += scale) {
            points.add(i);
        }
        setPreferredSize(new Dimension(200, 500));
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        final Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        rule the x-axis
        g.drawLine(getWidth()/2, PADDING, getWidth()/2, getHeight() - PADDING);
//        strike & label the line
        int length = getHeight() - 2 * PADDING;
        int j = points.size() - 1;  // helps indexing in descending order since the strokes are drawn so
        for (int i = 0; i < points.size(); i++, j--) {
            int x0 = getWidth()/2 - DASH_LENGTH/2;
            int y0 = ((i * length) / (points.size() - 1)) + PADDING;
            int x1 = x0 + DASH_LENGTH;
            int y1 = y0;
            g.drawLine(x0, y0, x1, y1);
            final String point = String.valueOf(points.get(j));
            final FontMetrics metrics = getFontMetrics(getFont());
            g.drawString(point, x0 - metrics.stringWidth(point) - 5, y0 + metrics.getHeight()/2);
        }
    }

}
