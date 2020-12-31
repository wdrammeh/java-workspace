package gui.anim;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Rolls a ball horizontally, to and fro, the bounds of this canvas.
 * A sound feedback is played as the ball hits the bounds.
 */
public class XRollBall extends Canvas {
    private int x;
    private char direction;
    private static final int BALL_WIDTH = 30;
    private static final int BALL_HEIGHT = 30;
    private static final int DELAY = 10;


    public static void main(String[] args) {
        MFrame.display("XRoll Ball", new XRollBall());
    }

    public XRollBall(){
        direction = 'R';
        setPreferredSize(new Dimension(300, 100));
        SwingUtilities.invokeLater(()-> new Timer(DELAY, e-> repaint()).start());
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        final Graphics2D g = (Graphics2D)graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final int y = (getHeight() / 2) - (BALL_HEIGHT / 2);
        if (direction == 'R') {
            x++;
            if (x >= (getWidth() - BALL_WIDTH)) {
                Toolkit.getDefaultToolkit().beep();
                direction = 'L';
            }
        } else if (direction == 'L') {
            x--;
            if (x <= 0) {
                Toolkit.getDefaultToolkit().beep();
                direction = 'R';
            }
        }
        g.fillOval(x, y, BALL_WIDTH, BALL_HEIGHT);
    }

}
