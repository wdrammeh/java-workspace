package gui.draw.graph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Illustrates the "Lower" Cartesian Plane;
 * where the x-axis and the y-axis are at the far bottom and left, respectively.
 * This model proves to be very useful, especially when comparing absolute-value data.
 * Unlike the normal {@link CartesianPlane}, this guarantees that intersection
 * will always occur at the lower-left, zero.
 */
public class LowerCartesian extends Canvas {
    protected List<Integer> xPoints;
    protected List<Integer> yPoints;
    private static final int PADDING = 35;
    private static final int DASH_LENGTH = 10;


    public static void main(String[] args) {
        final JFrame frame = new JFrame("Lower Cartesian Plane");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new LowerCartesian(1, 5, 1, 5));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public LowerCartesian(int xScale, int xMax, int yScale, int yMax){
        if (xMax % xScale != 0) {
            xMax = xMax / xScale * xScale + xScale;
        }
        xPoints = new ArrayList<>();
        for (int i = 0; i <= xMax; i += xScale) {
            xPoints.add(i);
        }

        if (yMax % yScale != 0) {
            yMax = yMax / yScale * yScale + yScale;
        }
        yPoints = new ArrayList<>();
        for (int i = 0; i <= yMax; i += yScale) {
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
        g.drawLine(PADDING, getHeight() - PADDING, getWidth() - PADDING, getHeight() - PADDING);
//        strike & label it
        int hLength = getWidth() - 2 * PADDING;
        for (int i = 0; i < xPoints.size(); i++) {
            int x0 = ((i * hLength) / (xPoints.size() - 1)) + PADDING;
            int y0 = getHeight() - PADDING;
            int x1 = x0;
            int y1 = y0 - DASH_LENGTH;
            g.drawLine(x0, y0, x1, y1);
            final String point = String.valueOf(xPoints.get(i));
            final FontMetrics metrics = getFontMetrics(getFont());
            g.drawString(point, x0 - metrics.stringWidth(point)/2, y0 + PADDING/2);
        }

//        rule the y-axis
        g.drawLine(PADDING, PADDING, PADDING, getHeight() - PADDING);
//        strike & label it
        int vLength = getHeight() - 2 * PADDING;
        int j = yPoints.size() - 1;
        for (int i = 0; i < yPoints.size(); i++, j--) {
            int x0 = PADDING;
            int y0 = ((i * vLength) / (yPoints.size() - 1)) + PADDING;
            int x1 = x0 + DASH_LENGTH;
            int y1 = y0;
            g.drawLine(x0, y0, x1, y1);
            if (j > 0) {  // do not write the 0 twice
                final FontMetrics metrics = getFontMetrics(getFont());
                final String pointText = String.valueOf(yPoints.get(j));
                g.drawString(pointText, x0 - metrics.stringWidth(pointText) - 5, y0 + metrics.getHeight()/2);
            }
        }
    }

}
