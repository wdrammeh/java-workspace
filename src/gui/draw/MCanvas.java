package gui.draw;

import gui.MFrame;

import java.awt.*;
/**
 * To draw, we typically extend the Canvas type,
 * and override its paint method.
 */
public class MCanvas {

    public static void main(String[] args) {
        final Canvas canvas = new Canvas(){
            @Override
            public void paint(Graphics graphics) {
                super.paint(graphics);
                final Graphics2D g = (Graphics2D) graphics;
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setBackground(Color.WHITE);
                g.drawString("Welcome",5,10);
                g.setFont(new Font("Arial",Font.BOLD,15));
                g.drawString("Muhammed W Drammeh", 100, 100);
                g.drawRect(10,20,50,30);
                g.drawOval(100, 10, 100, 50);
                g.setColor(Color.BLUE);
                g.drawOval(300, 20,50,50);
                g.fillOval(5,100,100,100);
                g.setColor(Color.BLACK);
                g.drawLine(300,100,500,150);
                g.drawLine(200,200,400,200);
            }
        };
        canvas.setPreferredSize(new Dimension(500, 300));

        MFrame.display("Canvas Sample", canvas);
    }

}
