package dps3.x2024;

import dps3.Constants;
import dps3.Month;
import dps3.Year;

public class Main {
    
    public static void main(String[] args) {
        final String game = Constants.GAME;
        final String cashPower = Constants.CASH_POWER;

        final int year = 2024;
        final int rent = 3000;
        final double wagePercent = .2;

        final Month jan = new Month("January", year, rent, wagePercent);
        Record.addJanData(jan);
        System.out.println(jan.getStatement());

        final Month feb = new Month("February", year, rent, wagePercent);
        Record.addFebData(feb);
        System.out.println(feb.getStatement());

        final Month mar = new Month("March", year, rent, wagePercent);
        Record.addMarData(mar);
        System.out.println(mar.getStatement());

        final Month apr = new Month("April", year, rent, wagePercent);
        Record.addAprData(apr);
        System.out.println(apr.getStatement());

        final Month may = new Month("May", year, rent, wagePercent);
        Record.addMayData(may);
        System.out.println(may.getStatement());

        final Month jun = new Month("June", year, rent, wagePercent);
        Record.addJunData(jun);
        System.out.println(jun.getStatement());

        final Month jul = new Month("July", year, rent, wagePercent);
        Record.addJulData(jul);
        System.out.println(jul.getStatement());

        final Month aug = new Month("August", year, rent, wagePercent);
        Record.addAugData(aug);
        System.out.println(aug.getStatement());

        final Month sep = new Month("September", year, rent, wagePercent);
        Record.addSepData(sep);
        System.out.println(sep.getStatement());

        final Month oct = new Month("October", year, rent, wagePercent);
        Record.addOctData(oct);
        System.out.println(oct.getStatement());

        final Month nov = new Month("November", year, rent, wagePercent);
        Record.addNovData(nov);
        System.out.println(nov.getStatement());

        final Month dec = new Month("December", year, rent, wagePercent);
        Record.addDecData(dec);
        System.out.println(dec.getStatement());

        // 
        final Year xYear = new Year(2024);
        xYear.setMonths(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec);
        System.out.println(xYear.getStatement());
    }

}
