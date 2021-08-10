package gui.practice;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class WKeyListener extends JFrame implements KeyListener{  
    JLabel l;  
    JTextArea area;
    
    public static void main(String[] args) {  
        new WKeyListener();  
    } 

    WKeyListener(){
          
        l = new JLabel();  
        l.setBounds(20,50,200,20);  
        area = new JTextArea();  
        area.setBounds(20,80,300, 300);  
        area.addKeyListener(this);  
          
        this.add(l);add(area);  
        this.setSize(400,400);  
        this. setLayout(null);  
        this.setVisible(true);
        
    }
    
    public void keyPressed(KeyEvent e) {
    	
    }
    public void keyReleased(KeyEvent e) {  
        String text = area.getText();
        String words[] = text.split("\\s");  
        l.setText("Words: "+words.length+" Characters:"+text.length());  
    }  
    
    public void keyTyped(KeyEvent e) {
    	
    } 
}  