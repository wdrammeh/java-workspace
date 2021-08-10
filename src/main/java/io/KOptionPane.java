package io;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class KOptionPane {
    private static JLabel message;
    private static Icon sucic;

    static {
        message = null;
        sucic = MyClass.scaleForMe(new File("checked.png"),50,50);
    }


    public static void main(String[] args) {
        promptExitDialog(null, "Confirm Exit", "Do you really want to leave?");
    }

    public static boolean promptExitDialog(JComponent component, String title, String exitMessage){
        message = new JLabel(exitMessage);
        message.setFont(new Font("",Font.PLAIN,17));

        return JOptionPane.showConfirmDialog(component,message,title,JOptionPane.YES_NO_OPTION) == 0;
    }

    public static boolean promptDeleteDialog(){

        return false;
    }

    public static boolean promptAdditionDialog(){

        return false;
    }

    public static void promptErrorMessage(JComponent component, String title, String textMessage){
        message = new JLabel(textMessage+"\n\n");
        message.setFont(new Font("",Font.PLAIN,17));

        JOptionPane.showMessageDialog(component,message,title,JOptionPane.ERROR_MESSAGE);
    }

    public static boolean promptWarningMessage(JComponent component, String title, String warnMessage){
        message = new JLabel(warnMessage);
        message.setFont(new Font("",Font.PLAIN,17));

        return JOptionPane.showConfirmDialog(component,message,title,JOptionPane.WARNING_MESSAGE) == 0;
    }

    public static void promptJustMessage(JComponent component, String title, String text){
        message = new JLabel(text);
        message.setFont(new Font("",Font.PLAIN,17));

        JOptionPane.showMessageDialog(component,message,title,JOptionPane.PLAIN_MESSAGE);
    }

    public static void promptSuccessfulMessage(JComponent component, String title, String text){
        message = new JLabel(text);
        message.setFont(new Font("",Font.PLAIN,17));

        JOptionPane.showMessageDialog(component,message,title,JOptionPane.PLAIN_MESSAGE,sucic);
    }

}
