package serial;

import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main(String[] args) {
//        final Person maha = new Person("Muhammed","Drammeh",20);

        final JLabel label = new JLabel("Welcome to Swing...!");
        label.setFont(new Font("",Font.BOLD,20));
        label.setForeground(Color.BLUE);
        final JFrame frame = new JFrame("My Frame");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().add(label);
        frame.setLocationRelativeTo(null);

        final Serializer s = new Serializer();
        s.serialize(frame,"frame.ser");

        final Deserializer d = new Deserializer();
        JFrame jFrame = (JFrame) d.deserialize("frame.ser");
        SwingUtilities.invokeLater(()->{
            jFrame.setVisible(true);
        });
    }

}
