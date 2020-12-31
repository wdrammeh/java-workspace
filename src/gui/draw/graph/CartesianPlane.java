package gui.draw.graph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Illustrates the Cartesian Plane.
 * @see XAxis
 * @see YAxis
 */
public class CartesianPlane extends Canvas {
    private List<Integer> xPoints;
    private List<Integer> yPoints;
    private static final int PADDING = 35;
    private static final int DASH_LENGTH = 10;


    public static void main(String[] args) {
        final JFrame frame = new JFrame("The Cartesian Plane");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new CartesianPlane(-5, 5, 1, -5, 5, 1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Constructs a Cartesian Plane with a domain and range
     * specified by the given scales and values.
     * The generated points will be labelled on their respective axes.
     * Note that, based on the sizing of the component and the given scales,
     * the intersection may not occur at zero.
     */
    public CartesianPlane(int xMin, int xMax, int xScale, int yMin, int yMax, int yScale){
        if (xMax % xScale != 0) {
            xMax = xMax / xScale * xScale + xScale;
        }
        xPoints = new ArrayList<>();
        for (int i = xMin; i <= xMax; i += xScale) {
            xPoints.add(i);
        }

        if (yMax % yScale != 0) {
            yMax = yMax / yScale * yScale + yScale;
        }
        yPoints = new ArrayList<>();
        for (int i = yMin; i <= yMax; i += yScale) {
            yPoints.add(i);
        }
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        final Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        rule the x-axis
        g.drawLine(PADDING, getHeight()/2, getWidth() - PADDING, getHeight()/2);
//        strike & label the line
        int hLength = getWidth() - 2 * PADDING;
        for (int i = 0; i < xPoints.size(); i++) {
            int x0 = ((i * hLength) / (xPoints.size() - 1)) + PADDING;
            int y0 = getHeight()/2 + DASH_LENGTH/2;
            int x1 = x0;
            int y1 = y0 - DASH_LENGTH;
            g.drawLine(x0, y0, x1, y1);
            final String point = String.valueOf(xPoints.get(i));
            final FontMetrics metrics = getFontMetrics(getFont());
            g.drawString(point, x0 - metrics.stringWidth(point)/2, y0 + PADDING/2);
        }

//        rule the y-axis
        g.drawLine(getWidth()/2, PADDING, getWidth()/2, getHeight() - PADDING);
//        strike & label the line
        int vLength = getHeight() - 2 * PADDING;
        int j = yPoints.size() - 1;
        for (int i = 0; i < yPoints.size(); i++, j--) {
            int x0 = getWidth()/2 - DASH_LENGTH/2;
            int y0 = ((i * vLength) / (yPoints.size() - 1)) + PADDING;
            int x1 = x0 + DASH_LENGTH;
            int y1 = y0;
            g.drawLine(x0, y0, x1, y1);
            final int point = yPoints.get(j);
            final FontMetrics metrics = getFontMetrics(getFont());
            final String pointText = String.valueOf(point);
            g.drawString(pointText, x0 - metrics.stringWidth(pointText) - 5, y0 + metrics.getHeight()/2);
        }
    }

}
