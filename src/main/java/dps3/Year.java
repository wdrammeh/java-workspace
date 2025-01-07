package dps3;

import static dps3.Utils.numberFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

public class Year {
    private int name;    
    private final ArrayList<Month> months;
    private final ArrayList<Inflow> extraInflows;
    private final ArrayList<Outflow> extraOutflows;


    public Year(int name) {
        this.name = name;
        this.months = new ArrayList<>();
        this.extraInflows = new ArrayList<>();
        this.extraOutflows = new ArrayList<>();
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public ArrayList<Month> getMonths() {
        return months;
    }

    public void setMonths(Month... months) {
        Collections.addAll(this.months, months);
    }

    public int totalMonthlyRent() {
        int total = 0;
        for (Month month : months) {
            total += month.getRent();
        }
        return total;
    }

    public int totalMonthlyWage() {
        int total = 0;
        for (Month month : months) {
            total += month.wage();
        }
        return total;
    }

    public int totalMonthlyInflow() {
        int total = 0;
        for (Month month : months) {
            total += month.totalRevenue();
        }
        return total;
    }

    public int totalMonthlyOutflow() {
        int total = 0;
        for (Month month : months) {
            total += month.totalExpense();
        }
        return total;
    }

    public void setExtraInflows(Inflow... inflows) {
        Collections.addAll(this.extraInflows, inflows);
    }

    public int totalExtraInflow() {
        int total = 0;
        for (Inflow inflow : extraInflows) {
            total += inflow.getAmount();
        }
        return total;
    }

    public void setExtraOutflows(Outflow... outflows) {
        Collections.addAll(this.extraOutflows, outflows);
    }
    
    public int totalExtraOutflow() {
        int total = 0;
        for (Outflow outflow : extraOutflows) {
            total += outflow.getAmount();
        }
        return total;
    }

    public int totalCashPowerCost() {
        int total = 0;
        for (Month month : months) {
            total += month.totalCashPowerCost();
        }
        for (Outflow outflow : extraOutflows) {
            if (Constants.CASH_POWER.equals(outflow.getName())) {
                total += outflow.getAmount();
            }
        }
        return total;
    }

    public double totalRevenue() {
        return totalMonthlyInflow() + totalExtraInflow();
    }

    public double totalExpense() {
        return totalMonthlyOutflow() + totalExtraOutflow();
    }

    public double netProfit() {
        return totalRevenue() - totalExpense();
    }

    public double avgMonthlyInflow() {
        return Utils.round(totalRevenue() / months.size(), 2);
    }

    public double avgMonthlyProfit() {
        return Utils.round(netProfit() / months.size(), 2);
    }

    public String getStatement() {
        final StringJoiner joiner = new StringJoiner("\n");
        joiner.add(String.format("[ %s ]", name))
                .add(String.format("Total Revenue: %s", numberFormat(totalRevenue())))
                .add(String.format("Total Rent: %s", numberFormat(totalMonthlyRent())))
                .add(String.format("Cash Power: %s", numberFormat(totalCashPowerCost())))
                .add(String.format("Total Wage: %s", numberFormat(totalMonthlyWage())))
                .add(String.format("Total Expense: %s", numberFormat(totalExpense())))
                .add(String.format("Avg. Monthly Income: %s", numberFormat(avgMonthlyInflow())))
                .add(String.format("Net Profit: %s", numberFormat(netProfit())))
                .add(String.format("Avg. Monthly Profit: %s", numberFormat(avgMonthlyProfit())))
                .add("");
        return joiner.toString();
    }

}
