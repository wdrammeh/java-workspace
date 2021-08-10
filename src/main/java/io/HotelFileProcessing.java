package io;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Question 2
 *
 * A hotel salesperson enters sales in a text file. Each line contains the following, separated by semicolons:
 * The name of the client, the service sold (such as Dinner, Conference, Lodging, and so on), the amount of the sale,
 * and the date of that event.
 * Write a program that reads such a file and displays the total amount for each service category.
 * Display an error if the file does not exist or the format is incorrect.
 * PROVIDE A TESTER CLASS FOR PROGRAM
 */
public class HotelFileProcessing {
    private final ArrayList<Service> services = new ArrayList<>();


    public void readFile(String fileName) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNextLine()) {
            try {
                readData(scanner.nextLine());
            } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
                System.err.println("Error: bad file format");
                return;
            }
        }
        for (Service s : services) {
            System.out.printf("Service: %s \t Total amount: $%d \n", s.name, s.amount);
        }
    }

    private void readData(String line) throws StringIndexOutOfBoundsException, NumberFormatException {
        int i = line.indexOf("service:");
        int j = line.indexOf(";", i);
        String serviceName = line.substring(i + 9, j);

        int k = line.indexOf("amount:");
        int l = line.indexOf(";", k);
        String amount = line.substring(k + 8, l);
        int serviceAmount = Integer.parseInt(amount.replace("$", ""));

        for (Service service : services){
            if (service.name.equals(serviceName)) {
                service.amount += serviceAmount;
                return;
            }
        }
        services.add(new Service(serviceName, serviceAmount));
    }

    /**
     * A simple innerclass to conveniently deal with the services
     */
    private static class Service {
        private String name;
        private int amount;

        private Service(String name, int amount){
            this.name = name;
            this.amount = amount;
        }
    }

}
