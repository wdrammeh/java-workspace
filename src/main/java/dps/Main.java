package dps;

import java.util.Calendar;
import org.apache.commons.lang3.time.DateUtils;

public class Main {
    
    public static void main(String[] args) {
        final String game = Constants.GAME;
        final String cashPower = Constants.CASH_POWER;

        final Month jan = new Month("January", 2024, 3000, .2);
        Records.addJanData(jan);
        // System.out.println(jan.getStatement());

        final Month feb = new Month("February", 2024, 3000, .2);
        Records.addFebData(feb);
        // System.out.println(feb.getStatement());

        final Month mar = new Month("March", 2024, 3000, .2);
        Records.addMarData(mar);
        // System.out.println(mar.getStatement());

        // 
        final Year year = new Year(2024);
        year.setMonths(jan, feb, mar);
        System.out.println(year.getStatement());
    }

}
