package io;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;

public class ITextPdfDemo {


    public static void main(String[] args) {

        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText("<html>\n" +
                "   <head>\n" +
                "     <title>An example HTMLDocument</title>\n" +
                "     <style type=\"text/css\">\n" +
                "                div { background-color: silver; }\n" +
                "        ul { color: red; }\n" +
                "     </style>\n" +
                "   </head>\n" +
                "   <body>\n" +
                "     <div id=\"BOX\">\n" +
                "       <editorPane>Paragraph 1</editorPane>\n" +
                "       <editorPane>Paragraph 2</editorPane>\n" +
                "     </div>\n" +
                "   <p>This is <br /> a line break (without starting a paragraph)"+
                "" +
                "<table>" +
                "<tr><td>rd</td><td>grd</td><tr>" +
                "<tr>" +
                "<td>Somethindf</td></tr>" +
                "</table>   " +
                "</body>\n" +
                " </html>");


        HTMLDocument d = (HTMLDocument) editorPane.getDocument();

//        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(editorPane);
        frame.setVisible(true);
    }


}
