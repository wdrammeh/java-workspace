package gui.design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginDemo extends JFrame implements ActionListener
{
    JProgressBar pb;
    JButton b1;
    LoginDemo()
    {
        super("LOGIN FORM");
        setLayout(null);
        b1 = new JButton("LOGIN");
        b1.setBackground(Color.yellow);
        pb = new JProgressBar(1,100);
        pb.setValue(0);
        pb.setStringPainted(true);
        pb.setForeground(Color.red);
        pb.setBackground(Color.white);
        b1.setBounds(20,20,80,25);pb.setBounds(110,20,200,25);
        pb.setVisible(false);
        add(b1);
        add(pb);
        b1.addActionListener(this);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        int i = 0;
        if(e.getSource() == b1)
        {
            pb.setVisible(true);
            try
            {
                while(i<=100)
                {
                    Thread.sleep(50);
                    pb.paintImmediately(0, 0, 200, 25);
                    pb.setValue(i);
                    i++;
                }
            }
            catch(Exception e1)
            {
                System.out.print("Caughted exception is ="+e1);
            }
        }
    }
    public static void main(String arg[])
    {
        LoginDemo m = new LoginDemo();
        m.setSize(330,100);
        m.setVisible(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - m.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - m.getHeight()) / 2);
        m.setLocation(x, y);
    }
}
