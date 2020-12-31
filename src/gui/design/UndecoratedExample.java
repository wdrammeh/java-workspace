package gui.design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class UndecoratedExample {
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new UndecoratedExample().createAndShowGUI();
        });
    }

    private UndecoratedExample(){
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.add(new OutsidePanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void createAndShowGUI(){

    }

    private class MainPanel extends JPanel{

        private MainPanel(){
            this.setBackground(Color.GRAY);
        }

        @Override
        public Dimension getPreferredSize() {
//            return super.getPreferredSize();
            return new Dimension(400,400);
        }
    }

    private class BorderPanel extends JPanel{
        private JLabel label;
        int pX, pY;

        private BorderPanel(){
            label = new JLabel(" X ");
            label.setOpaque(true);
            label.setBackground(Color.RED);
            label.setForeground(Color.WHITE);
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    System.exit(100);
                }
            });

            this.setBackground(Color.BLACK);
            this.setLayout(new FlowLayout(FlowLayout.RIGHT));
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    pX = e.getX();
                    pY = e.getY();
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                    frame.setLocation(frame.getLocation().x + e.getX() - pX, frame.getLocation().y + e.getY() - pY);
                }
            });
            this.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                    frame.setLocation(frame.getLocation().x + e.getX() - pX, frame.getLocation().y + e.getY() - pY);
                }
            });
            this.add(label);

        }
    }

    private class OutsidePanel extends JPanel{

        public OutsidePanel(){
            this.setLayout(new BorderLayout());
            this.add(new MainPanel(),BorderLayout.CENTER);
            this.add(new BorderPanel(),BorderLayout.PAGE_START);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));

        }
    }

}
