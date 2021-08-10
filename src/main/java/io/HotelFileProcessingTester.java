package io;

import java.io.IOException;

public class HotelFileProcessingTester {

    public static void main(String[] args) {
        HotelFileProcessing fileProcessing = new HotelFileProcessing();
        String fileName = "hotel.txt";
        try {
            fileProcessing.readFile(fileName);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
