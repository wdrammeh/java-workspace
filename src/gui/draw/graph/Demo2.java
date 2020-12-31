package gui.draw.graph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Demo2 extends Canvas {
    private static final int PADDING = 50;
    private static final int POINTS_HEIGHT = 10;
    private static final int NO_OF_Y_DIVISIONS = 20;
    private static ArrayList<String> names;
    private static ArrayList<Double> points;


    public static void main(String[] args) {
        final ArrayList<String> semesters = new ArrayList<>();
        semesters.add("2016/2017 First Semester");
        semesters.add("2016/2017 Second Semester");
        semesters.add("2017/2018 First Semester");
        semesters.add("2017/2018 Second Semester");
        semesters.add("2018/2019 First Semester");
        semesters.add("2018/2019 Second Semester");
        semesters.add("2019/2020 First Semester");
        semesters.add("2019/2020 Second Semester");

        final ArrayList<Double> points = new ArrayList<>();
        points.add(3.75);
        points.add(4.);
        points.add(2.667);
        points.add(3.5);
        points.add(4.25);
        points.add(4.5);
        points.add(3.7);
        points.add(3.930);

        final Demo2 graphPanel = new Demo2(semesters, points);

        final JFrame frame = new JFrame("Graph Demo 2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(graphPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public Demo2(ArrayList<String> semesters, ArrayList<Double> cgpas) {
        names = semesters;
        points = cgpas;
//        Y_MAX = max(cgs);
        setPreferredSize(new Dimension(1_000, 500));
    }

//    private static double max(ArrayList<Double> doubles){
//        double maxScore = Double.MIN_VALUE;
//        for (Double d : doubles) {
//            maxScore = Math.max(maxScore, d);
//        }
//        return maxScore;
//    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        final Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final double xScale = ((double) (getWidth() - (2 * PADDING)) / (points.size() - 1));
        double y_MAX = 4.45;
        final double yScale = ((double) (getHeight() - (2 * PADDING)) / (y_MAX - 1));

        final List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            int x1 = (int) (i * xScale + PADDING);
            int y1 = (int) ((y_MAX - points.get(i)) * yScale + PADDING);
            graphPoints.add(new Point(x1, y1));
        }

//        rule the lines of the axes
        g2.drawLine(PADDING, this.getHeight() - PADDING, this.getWidth() - PADDING, this.getHeight() - PADDING);
        g2.drawLine(PADDING, this.getHeight() - PADDING, PADDING, PADDING);

//        strike & label the x_axis
        for (int i = 0; i < points.size() - 1; i++) {
            int x0 = (i + 1) * (this.getWidth() - (PADDING * 2)) / (points.size() - 1) + PADDING;
            int x1 = x0;
            int y0 = this.getHeight() - PADDING;
            int y1 = y0 - POINTS_HEIGHT;
            g2.drawLine(x0, y0, x1, y1);
            final String[] nameParts = names.get(i + 1).split(" ");
            g2.drawString(nameParts[0],x0 - 30,y0 + 15);
            g2.drawString(nameParts[1]+" "+nameParts[2],x0 - 40,y0 + 30);
        }

//        and the vertical axes
        for (int i = 0; i < NO_OF_Y_DIVISIONS; i++) {
            int x0 = PADDING;
            int x1 = POINTS_HEIGHT + PADDING;
            int y0 = getHeight() - (((i + 1) * (getHeight() - PADDING * 2)) / NO_OF_Y_DIVISIONS + PADDING);
            int y1 = y0;
            g2.drawLine(x0, y0, x1, y1);
            if (i == NO_OF_Y_DIVISIONS - 1) {
                g2.drawString("5.0",x0 -40,y0 + 5);
            }
        }

//        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(3F));
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }

        final Stroke oldStroke = g2.getStroke();
        g2.setStroke(oldStroke);
        g2.setColor(Color.BLUE);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - POINTS_HEIGHT / 2;
            int y = graphPoints.get(i).y - POINTS_HEIGHT / 2;
            int ovalW = POINTS_HEIGHT;
            int ovalH = POINTS_HEIGHT;
            g2.fillOval(x, y, ovalW, ovalH);
            g2.drawString(points.get(i)+"",x - 10,y - 10);
        }
    }

}
