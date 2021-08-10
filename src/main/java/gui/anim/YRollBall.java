package gui.anim;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Rolls a ball vertically, to and fro, the bounds of this canvas.
 * A sound feedback is played as the ball hits the bounds.
 */
public class YRollBall extends Canvas {
    private int y;
    private char direction;
    private static final int BALL_WIDTH = 30;
    private static final int BALL_HEIGHT = 30;
    private static final int DELAY = 10;


    public static void main(String[] args) {
        MFrame.display("YRoll Ball", new YRollBall());
    }

    public YRollBall(){
        direction = 'D';
        setPreferredSize(new Dimension(100, 300));
        SwingUtilities.invokeLater(()-> new Timer(DELAY, e-> repaint()).start());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        final Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final int x = (getWidth() / 2) - (BALL_WIDTH / 2);
        if (direction == 'D') {
            y++;
            if (y >= (getHeight() - BALL_HEIGHT)) {
                Toolkit.getDefaultToolkit().beep();
                direction = 'U';
            }
        } else if (direction == 'U') {
            y--;
            if (y <= 0) {
                Toolkit.getDefaultToolkit().beep();
                direction = 'D';
            }
        }
        g2d.fillOval(x, y, BALL_WIDTH, BALL_HEIGHT);
    }

}
