package io;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.io.File;
import java.io.IOException;

public class TestPrinting {

    public static void main(String[] args) {
        final JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setPreferredSize(new Dimension(400,300));
        jPanel.setBackground(Color.LIGHT_GRAY);

        try {
            printComponentToFileType1(jPanel, true);
            printComponentToFileType2(jPanel, false);
        }catch (PrinterException pIssue){
            pIssue.printStackTrace();
        }
    }

    private static void printComponentToFileType1(JComponent comp, boolean fill) throws PrinterException{
        PrinterJob pJob = PrinterJob.getPrinterJob();

        PageFormat pf = pJob.defaultPage();

        pf.setOrientation(PageFormat.LANDSCAPE);

        PageFormat postFormat = pJob.pageDialog(pf);
        if (pf != postFormat) {
            pJob.setPrintable(new ComponentPrinter(comp,fill),postFormat);

            if (pJob.printDialog()) {
                pJob.print();
            }
        }

    }

    private static void printComponentToFileType2(JComponent comp, boolean fill) throws PrinterException{
        Paper paper = new Paper();
        paper.setSize(8.3*72,11.7*72);
        paper.setImageableArea(18,18,559,783);

        PageFormat pf = new PageFormat();
        pf.setPaper(paper);
        pf.setOrientation(PageFormat.LANDSCAPE);

        BufferedImage img = new BufferedImage((int)Math.round(pf.getWidth()), (int)Math.round(pf.getHeight()), BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fill(new Rectangle(0,0,img.getWidth(),img.getHeight()));

        ComponentPrinter cp = new ComponentPrinter(comp,fill);
        try {
            cp.print(g2d,pf,0);
        }finally {
            g2d.dispose();
        }

        try {
            ImageIO.write(img,"png",new File("Page-"+(fill ? "filled" : "")+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class ComponentPrinter implements Printable {
        private JComponent comp;
        private boolean fill;

        private ComponentPrinter(JComponent comp, boolean fill){
            this.comp = comp;
            this.fill = fill;
        }

        @Override
        public int print(Graphics g, PageFormat format, int page_index) throws PrinterException {
            if (page_index > 0 ) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D)g;
            g2.translate(format.getImageableX(),format.getImageableY());

            double width = (int) Math.floor(format.getImageableWidth());
            double height = (int) Math.floor(format.getImageableHeight());

            if (!fill) {
                width = Math.min(width,comp.getPreferredSize().width);
                height = Math.min(height,comp.getPreferredSize().height);
            }

            comp.setBounds(0,0,(int)Math.floor(width),(int)Math.floor(height));
            if (comp.getParent() == null) {
                comp.addNotify();
            }
            comp.validate();
            comp.doLayout();
            comp.printAll(g2);

            if (comp.getParent() != null) {
                comp.removeNotify();
            }

            return Printable.PAGE_EXISTS;
        }
    }
}
