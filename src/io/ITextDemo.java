package io;

import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.FileOutputStream;

public final class ITextDemo {


    public static void main(String[] args) {
        try {
            new ITextDemo().createSamplePDF(new String[]{"COURSE CODE", "COURSE DESCRIPTION", "CREDIT VALUE", "GRADE",
                            "QUALITY POINT"},
                    new Object[][]{
                            {"MTH002", "Precalculus", 3, "A", 3.00},
                            {"MTH105", "Basic Statistics", 3, "A", 3.00},
                            {"buid90", "Linear Algebra", 3, "A", 3.00},
                            {"buid90", "Linear Algebra", 3, "A", 3.00}});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSamplePDF(String[] header, Object[][] body) throws Exception{
        final Document document = new Document(){
            @Override
            public boolean newPage() {
                System.out.println("Another page");
                return super.newPage();
            }
        };
        final Rectangle pageSize = document.getPageSize();
        final int maxUsableWidth = (int)(pageSize.getWidth() - pageSize.getWidth()/25) - 20;

        final FileOutputStream outputStream = new FileOutputStream("/home/muhammed/Outputs/test.pdf");
        PdfWriter.getInstance(document, outputStream);

        final Paragraph p1 = new Paragraph(new Phrase("the university of the gambia".toUpperCase(),
                new Font(Font.TIMES_ROMAN, 18, Font.BOLD)));
        p1.setAlignment(Paragraph.ALIGN_CENTER);
        p1.setSpacingAfter(10);

        final Paragraph p2 = new Paragraph(new Phrase("student academic records".toUpperCase(),
                new Font(Font.TIMES_ROMAN, 13, Font.BOLD)));
        p2.setAlignment(Paragraph.ALIGN_CENTER);
        p2.setSpacingAfter(45);

        final Image logo = new Jpeg(getClass().getResource("/UTGLogo.jpg"));
        logo.scaleAbsolute(70, 85);
        logo.setAbsolutePosition(pageSize.getWidth() - 100,
                pageSize.getHeight() - 125);

        final Font detailHintFont = new Font(Font.HELVETICA, 9, Font.BOLD);
        final Font detailValueFont = new Font(Font.HELVETICA, 9, Font.NORMAL);
        final int detailTableWidth = (int)(pageSize.getWidth()/2) - 65;
        final int firstTwoHeight = 30;

        final PdfPTable leftTable = new PdfPTable(2);
        leftTable.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);
        leftTable.setTotalWidth(detailTableWidth);
        leftTable.setLockedWidth(true);
        leftTable.setWidths(new int[] {35, 50});

        final PdfPCell cell11 = new PdfPCell(new Phrase("student name".toUpperCase(), detailHintFont));
        cell11.setPadding(5);
        cell11.setBorderWidth(1F);
        cell11.setFixedHeight(firstTwoHeight);
        leftTable.addCell(cell11);

        final PdfPCell cell12 = new PdfPCell(new Phrase("muhammed w. drammeh".toUpperCase(), detailValueFont));
        cell12.setPadding(5);
        cell12.setBorderWidth(1F);
        leftTable.addCell(cell12);

        final PdfPCell cell13 = new PdfPCell(new Phrase("student \nnumber".toUpperCase(), detailHintFont));
        cell13.setPadding(5);
        cell13.setBorderWidth(1F);
        cell13.setFixedHeight(firstTwoHeight);
        leftTable.addCell(cell13);

        final PdfPCell cell14 = new PdfPCell(new Phrase("21712494".toUpperCase(), detailValueFont));
        cell14.setPadding(5);
        cell14.setBorderWidth(1F);
        leftTable.addCell(cell14);

        final PdfPCell cell15 = new PdfPCell(new Phrase("year enrolled".toUpperCase(), detailHintFont));
        cell15.setPadding(5);
        cell15.setBorderWidth(1F);
        leftTable.addCell(cell15);

        final PdfPCell cell16 = new PdfPCell(new Phrase("September, 2016", detailValueFont));
        cell16.setPadding(5);
        cell16.setBorderWidth(1F);
        leftTable.addCell(cell16);

        final PdfPTable rightTable = new PdfPTable(2);
        rightTable.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT);
        rightTable.setTotalWidth(detailTableWidth);
        rightTable.setLockedWidth(true);
        rightTable.setWidths(new int[] {30, 50});

        final PdfPCell cell21 = new PdfPCell(new Phrase("year graduated".toUpperCase(), detailHintFont));
        cell21.setFixedHeight(firstTwoHeight);
        cell21.setPadding(5);
        cell21.setBorderWidth(1F);
        rightTable.addCell(cell21);

        final PdfPCell cell22 = new PdfPCell(new Phrase("n/a".toUpperCase(), detailValueFont));
        cell22.setPadding(5);
        cell22.setBorderWidth(1F);
        rightTable.addCell(cell22);

        final PdfPCell cell23 = new PdfPCell(new Phrase("major".toUpperCase(), detailHintFont));
        cell23.setFixedHeight(firstTwoHeight);
        cell23.setPadding(5);
        cell23.setBorderWidth(1F);
        rightTable.addCell(cell23);

        final PdfPCell cell24 = new PdfPCell(new Phrase("Bachelor of Science in Mathematics", detailValueFont));
        cell24.setPadding(5);
        cell24.setBorderWidth(1F);
        rightTable.addCell(cell24);

        final PdfPCell cell25 = new PdfPCell(new Phrase("minor".toUpperCase(), detailHintFont));
        cell25.setPadding(5);
        cell25.setBorderWidth(1F);
        rightTable.addCell(cell25);

        final PdfPCell cell26 = new PdfPCell(new Phrase("n/a".toUpperCase(), detailValueFont));
        cell26.setPadding(5);
        cell26.setBorderWidth(1F);
        rightTable.addCell(cell26);

        final PdfPTable detailsTable = new PdfPTable(2);
        detailsTable.getDefaultCell().setBorderColor(Color.WHITE);//desperately trying to hide the border
        detailsTable.setTotalWidth(maxUsableWidth);
        detailsTable.setLockedWidth(true);
        detailsTable.addCell(leftTable);
        detailsTable.addCell(rightTable);
        detailsTable.setSpacingAfter(20);

//        numbering to be included afterwards

        final Font headerFont = new Font(Font.HELVETICA, 9, Font.BOLD);
        final Font bodyFont = new Font(Font.HELVETICA, 9, Font.NORMAL);

        final int[] definedColumnSizes = new int[] {15, 45, 15, 10, 15};

        final PdfPTable headTable = new PdfPTable(header.length);
        headTable.setTotalWidth(maxUsableWidth);
        headTable.setLockedWidth(true);
        headTable.setWidths(definedColumnSizes);
        for (String head : header) {
            final PdfPCell headCell = new PdfPCell(new Phrase(head, headerFont));
            headCell.setBackgroundColor(Color.LIGHT_GRAY);
            headCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            headCell.setPadding(5F);
            headTable.addCell(headCell);
        }

        final PdfPTable semesterTable = new PdfPTable(1);
        semesterTable.setTotalWidth(maxUsableWidth);
        semesterTable.setLockedWidth(true);
        final PdfPCell semesterCell = new PdfPCell(new Phrase("2016/2017 First Semester", headerFont));
        semesterCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        semesterCell.setPadding(5F);
        semesterTable.addCell(semesterCell);

        final PdfPTable bodyTable = new PdfPTable(header.length);
        bodyTable.setTotalWidth(maxUsableWidth);
        bodyTable.setLockedWidth(true);
        bodyTable.setWidths(definedColumnSizes);
        for (int i = 0; i < body.length; i++) {
            for (int j = 0; j < body[i].length; j++) {
                final PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(body[i][j]), bodyFont));
                final boolean firstLast = j == 0 || j  == body[i].length - 1;
                cell.setHorizontalAlignment(firstLast ? PdfPCell.ALIGN_LEFT : PdfPCell.ALIGN_CENTER);
                cell.setPadding(5F);
                bodyTable.addCell(cell);
            }
        }

        final PdfPTable gpaTable = new PdfPTable(3);
        gpaTable.setTotalWidth(maxUsableWidth);
        gpaTable.setLockedWidth(true);
        gpaTable.setWidths(new int[] {definedColumnSizes[0] + definedColumnSizes[1] + definedColumnSizes[2], definedColumnSizes[3], definedColumnSizes[4]});
        final PdfPCell gpHintCell = new PdfPCell(new Phrase("average quality point".toUpperCase(), headerFont));
        gpHintCell.setPadding(10F);
        gpHintCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        final PdfPCell gpValueCell = new PdfPCell(new Phrase("3.9288", headerFont));
        gpValueCell.setPadding(10F);
        gpValueCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        gpaTable.addCell(gpHintCell);
        gpaTable.addCell(gpValueCell);
        final PdfPCell hiddenCell = new PdfPCell(new Phrase(" "));
        hiddenCell.setBorderWidthRight(0.0F);
        hiddenCell.setBorderWidthBottom(0.0F);
        gpaTable.addCell(hiddenCell);

        document.open();
        document.addTitle("UTG Student Transcript");
        document.addAuthor("Muhammed W. Drammeh");
        document.addCreator("UTG Student Dashboard");
        document.addCreationDate();

        document.add(p1);
        document.add(p2);
        document.add(logo);

        document.add(detailsTable);

        document.add(headTable);
        document.add(semesterTable);
        document.add(bodyTable);
        document.add(gpaTable);

        document.close();
        outputStream.flush();
        outputStream.close();
    }

}
