package io;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileOutputStream;


public class PdfDemo {
    private JTable table;


    public static void main(String[] args) {
        PdfDemo demo = new PdfDemo();
        demo.createPdf(true);
    }

    public PdfDemo(){
        table = new JTable();
//        table = new JTable(rdata, colm);
        table.setRowHeight(25);
        table.setFont(new Font("", Font.PLAIN, 15));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(true);
//        table.setPreferredSize(new Dimension(575, 270));
        table.getTableHeader().setFont(table.getFont());

        DefaultTableModel defaultModel = new DefaultTableModel();
        table.setModel(defaultModel);

        defaultModel.setColumnIdentifiers(new String[] {"Code","Name","Lect","Venue","Time & Day"});

        defaultModel.addRow(new String[] {"Cps101","Computer Programming 1","Fred","Pb103","Fridays/9am"});
        defaultModel.addRow(new String[] {"Cps101","Computer Programming 1","Fred","Pb103","Fridays/9am"});
        defaultModel.addRow(new String[] {"Cps101","Computer Programming 1","Fred","Pb103","Fridays/9am"});
        defaultModel.addRow(new String[] {"Cps101","Computer Programming 1","Fred","Pb103","Fridays/9am"});
        defaultModel.addRow(new String[] {"Cps101","Computer Programming 1","Fred","Pb103","Fridays/9am"});


    }

    private void createPdf(boolean shapes){
        Document document = new Document();
        try{
            PdfWriter writer;
            if (shapes) {
                writer = PdfWriter.getInstance(document,new FileOutputStream("/home/muhammed/Output/my_jTable_shapes.pdf"));

            }else {
                writer = PdfWriter.getInstance(document,new FileOutputStream("/home/muhammed/Output/my_jTable_fonts.pdf"));

            }
            document.open();

            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate tp = cb.createTemplate(500,500);

            Graphics2D g2;
            if (shapes) {
                g2 = tp.createGraphicsShapes(500,500);

            }else{
                g2 = tp.createGraphics(500,500);
            }
            table.printAll(g2);
            g2.dispose();
            cb.addTemplate(tp,30,300);
            document.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
