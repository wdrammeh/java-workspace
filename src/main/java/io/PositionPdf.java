package io;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PositionPdf {
    private static String FILE = MyClass.MY_DIRECTORY+"positionPdf.pdf";

    public static void main(String[] args) {
        try {
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            Paragraph paragraph = new Paragraph("This is a right-aligned text");
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph);

            paragraph = new Paragraph("This is a left-aligned text");
            paragraph.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph);

            paragraph = new Paragraph("This is a centered text");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            paragraph = new Paragraph("This was aligned right with indentation.");
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            paragraph.setIndentationRight(50);
            document.add(paragraph);
            document.close();
        } catch (Exception except) {
            except.printStackTrace();
        }

    }
}
