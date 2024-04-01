package dps;

import java.util.Calendar;
import org.apache.commons.lang3.time.DateUtils;

public class Main {
    
    public static void main(String[] args) {
        final String game = Constants.GAME;
        final String cashPower = Constants.CASH_POWER;

        final Month jan = new Month("January", 2024, 3000, .2);
        jan.setDays(
            Day.on(jan, 1).setDefaultInflow(335).setDefaultOutflow(100),
            Day.on(jan, 2).setDefaultInflow(390),
            Day.on(jan, 3).setDefaultInflow(425),
            Day.on(jan, 4).setDefaultInflow(350).setDefaultOutflow(50),
            Day.on(jan, 5).setDefaultInflow(305),
            Day.on(jan, 6).setDefaultInflow(195).setDefaultOutflow(100),
            Day.on(jan, 7).setDefaultInflow(485),
            Day.on(jan, 8).setDefaultInflow(155),
            Day.on(jan, 9).setDefaultInflow(275),
            Day.on(jan, 10).setDefaultInflow(285).setDefaultOutflow(100),
            Day.on(jan, 11).setDefaultInflow(360),
            Day.on(jan, 12).setDefaultInflow(320),
            Day.on(jan, 13).setDefaultInflow(445).setDefaultOutflow(300),
            Day.on(jan, 14).setDefaultInflow(435),
            Day.on(jan, 15).setDefaultInflow(320),
            Day.on(jan, 16).setDefaultInflow(365),
            Day.on(jan, 17).setDefaultInflow(225),
            Day.on(jan, 18).setDefaultInflow(290),
            Day.on(jan, 19).setDefaultInflow(180),
            Day.on(jan, 20).setDefaultInflow(410),
            Day.on(jan, 21).setDefaultInflow(110),
            Day.on(jan, 22).setDefaultInflow(215).setDefaultOutflow(300),
            Day.on(jan, 23).setDefaultInflow(110),
            Day.on(jan, 24).setDefaultInflow(125),
            Day.on(jan, 25).setDefaultInflow(485),
            Day.on(jan, 26).setDefaultInflow(485),
            Day.on(jan, 27).setDefaultInflow(650),
            Day.on(jan, 28).setDefaultInflow(510),
            Day.on(jan, 29).setDefaultInflow(190),
            Day.on(jan, 30).setDefaultInflow(445).setDefaultOutflow(100),
            Day.on(jan, 31).setDefaultInflow(425)
        );
        
        System.out.println(String.format("[ %s ]", jan.getDisplayName()));
        System.out.println(String.format("Total Revenue: %s", jan.totalRevenue()));
        System.out.println(String.format("Rent: %s", jan.getRent()));
        System.out.println(String.format("Cash Power: %s", jan.totalCashPowerCost()));
        System.out.println(String.format("Wage: %s", jan.wage()));
        System.out.println(String.format("Total Expense: %s", jan.totalExpense()));
        System.out.println(String.format("Net Profit: %s", jan.netProfit()));
    }

}
