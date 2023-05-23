package test.cmp103.abc;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        final HashMap<Integer , Beverage> map = new HashMap<>();
        map.put(1, new Beverage(1, "Espresso", 1.5));
        map.put(2, new Beverage(2, "Cappuccino", 2.5));
        map.put(3, new Beverage(3, "Latte", 2));
        
        final Scanner console = new Scanner(System.in);
        System.out.print("Please enter beverage quantity => ");
        final int quantity = console.nextInt();
        // Todo: Ensure quantity is int|gt:0

        double amount = 0;
        for (int i = 1; i <= quantity; i++) {
            System.out.println("No.\tType\t\tPrice ($)");
            for (Beverage beverage : map.values()) {
                System.out.printf("%d.\t%s\t\t%.2f\n", beverage.getNumber(), beverage.getType(), beverage.getPrice());
            }
            
            System.out.printf("Please enter which beverage %s => ", map.keySet());
            final int id = console.nextInt();
            // Todo: Ensure id is int|gt:0
            final Beverage beverage = map.get(id);
            // Todo: Ensure beverage != null
            amount += beverage.getPrice();

            System.out.print("Please enter whether you want additional milk (Y or N) => ");
            final String answer = console.next();
            amount += answer.startsWith("Y") ? .5 : 0;
        }
        
        System.out.printf("\nThe total amount is $%.2f\n", amount);
    }
    
}
