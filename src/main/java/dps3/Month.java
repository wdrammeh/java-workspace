package dps3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

public class Month {
    private String name;
    private int year;
    private int rent;
    private double wagePercentage;
    private final ArrayList<Day> days;
    private final ArrayList<Inflow> extraInflows;
    private final ArrayList<Outflow> extraOutflows;


    public Month(String name, int year, int rent, double wagePercentage) {
        this.name = name;
        this.year = year;
        this.rent = rent;
        this.wagePercentage = wagePercentage;
        this.days = new ArrayList<>();
        this.extraInflows = new ArrayList<>();
        this.extraOutflows = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public double getWagePercentage() {
        return wagePercentage;
    }

    public void setWagePercentage(double wagePercentage) {
        this.wagePercentage = wagePercentage;
    }

    public void setDays(Day... d) {
        Collections.addAll(days, d);
    }

    public void setExtraInflows(Inflow... i) {
        Collections.addAll(extraInflows, i);
    }

    public void setExtraOutflows(Outflow... o) {
        Collections.addAll(extraOutflows, o);
    }

    public int totalDailyInflow() {
        int total = 0;
        for (Day day : days) {
            total += day.totalInflow();
        }
        return total;
    }

    public int totalDailyOutflow() {
        int total = 0;
        for (Day day : days) {
            total += day.totalOutflow();
        }
        return total;
    }

    public int totalExtraInflow() {
        int total = 0;
        for (Inflow inflow : extraInflows) {
            total += inflow.getAmount();
        }
        return total;
    }

    public int totalExtraOutflow() {
        int total = 0;
        for (Outflow outflow : extraOutflows) {
            total += outflow.getAmount();
        }
        return total;
    }

    public double totalRevenue() {
        return totalDailyInflow() + totalExtraInflow();
    }

    public double wage() {
        return wagePercentage * totalRevenue();
    }

    public double totalExpense() {
        return rent + wage() + totalDailyOutflow() + totalExtraOutflow();
    }

    public double netProfit() {
        return totalRevenue() - totalExpense();
    }

    public String getDisplayName() {
        return String.format("%s %s", name, year);
    }

    public int totalCashPowerCost() {
        int total = 0;
        for (Day day : days) {
            for (Outflow outflow : day.getOutflows()) {
                if (Constants.CASH_POWER.equals(outflow.getName())) {
                    total += outflow.getAmount();
                }
            }
        }
        for (Outflow outflow : extraOutflows) {
            if (Constants.CASH_POWER.equals(outflow.getName())) {
                total += outflow.getAmount();
            }
        }
        return total;
    }

    public double avgDailyInflow() {
        return Utils.round(totalRevenue() / days.size(), 2);
    }

    public String getStatement() {
        final StringJoiner joiner = new StringJoiner("\n");
        joiner.add(String.format("[ %s ]", getDisplayName()))
                .add(String.format("Total Revenue: %s", totalRevenue()))
                .add(String.format("Rent Fee: %s", getRent()))
                .add(String.format("Cash Power: %s", totalCashPowerCost()))
                .add(String.format("Wage (%s): %s", wagePercentage, wage()))
                .add(String.format("Total Expense: %s", totalExpense()))
                // .add(String.format("Avg. Daily Income: %s", avgDailyInflow()))
                .add(String.format("Net Profit: %s", netProfit()))
                .add("");
        return joiner.toString();
    }

}
