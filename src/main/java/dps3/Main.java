package dps3;

public class Main {
    
    public static void main(String[] args) {
        final String game = Constants.GAME;
        final String cashPower = Constants.CASH_POWER;

        final Month jan = new Month("January", 2024, 3000, .2);
        Records.addJanData(jan);
        System.out.println(jan.getStatement());

        final Month feb = new Month("February", 2024, 3000, .2);
        Records.addFebData(feb);
        System.out.println(feb.getStatement());

        final Month mar = new Month("March", 2024, 3000, .2);
        Records.addMarData(mar);
        System.out.println(mar.getStatement());

        final Month apr = new Month("April", 2024, 3000, .2);
        Records.addAprData(apr);
        System.out.println(apr.getStatement());

        final Month may = new Month("May", 2024, 3000, .2);
        Records.addMayData(may);
        System.out.println(may.getStatement());

        final Month jun = new Month("June", 2024, 3000, .2);
        Records.addJunData(jun);
        System.out.println(jun.getStatement());

        final Month jul = new Month("July", 2024, 3000, .2);
        Records.addJulData(jul);
        System.out.println(jul.getStatement());

        final Month aug = new Month("August", 2024, 3000, .2);
        Records.addAugData(aug);
        System.out.println(aug.getStatement());

        // 
        final Year year = new Year(2024);
        year.setMonths(jan, feb, mar, apr, may, jun);
        System.out.println(year.getStatement());
    }

}
