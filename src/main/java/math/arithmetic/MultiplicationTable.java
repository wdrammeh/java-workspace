package math.arithmetic;

import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome. Construct multiplication table up to 12.");
        System.out.print("Enter number: ");
        constructTable(scanner.nextInt());
        scanner.close();
    }

    private static void constructTable(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 12; j++) {
                System.out.println(i+" x "+j+" = "+(i * j));
            }
            System.out.println();
        }
    }

}
