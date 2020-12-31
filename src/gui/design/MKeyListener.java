package gui.design;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MKeyListener extends JPanel implements KeyListener {
    private JLabel label;
    private JTextArea area;


    public static void main(String[] args) {
        MFrame.display("Key Listener", new MKeyListener());
    }
    
    MKeyListener(){
        super();
        area = new JTextArea();
        area.addKeyListener(this);
        label = new JLabel("Write something...");
        setLayout(new GridLayout(3, 1));
        add(area);
        add(Box.createVerticalGlue());
        add(label);
        setPreferredSize(new Dimension(300, 200));
    }

    @Override
    public void keyPressed(KeyEvent key) {
        label.setText("key pressed");
    }

    @Override
    public void keyReleased(KeyEvent key) {
        label.setText("key released");
    }

    @Override
    public void keyTyped(KeyEvent key) {
        label.setText("Typing..");
    }

}  
