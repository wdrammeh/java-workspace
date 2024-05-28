package dps3;

import java.util.ArrayList;
import java.util.Collections;

public class Day {
    private int number;
    private Month month;
    private final ArrayList<Inflow> inflows;
    private final ArrayList<Outflow> outflows;


    public Day(int number, Month month) {
        this.month = month;
        this.number = number;
        this.inflows = new ArrayList<>();
        this.outflows = new ArrayList<>();
    }

    public static Day on(Month month, int number) {
        return new Day(number, month);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public ArrayList<Inflow> getInflows() {
        return inflows;
    }

    public Day setInflows(Inflow... i) {
        Collections.addAll(inflows, i);
        return this;
    }

    public Day setInflow(String name, int amount) {
        inflows.add(new Inflow(name, amount));
        return this;
    }

    public Day setDefaultInflow(int amount) {
        inflows.add(new Inflow(Constants.GAME, amount));
        return this;
    }
    
    public ArrayList<Outflow> getOutflows() {
        return outflows;
    }

    public Day setOutflows(Outflow... o) {
        Collections.addAll(outflows, o);
        return this;
    }

    public Day setOutflow(String name, int amount) {
        outflows.add(new Outflow(name, amount));
        return this;
    }

    public Day setDefaultOutflow(int amount) {
        outflows.add(new Outflow(Constants.CASH_POWER, amount));
        return this;
    }

    public int totalInflow() {
        int total = 0;
        for (Inflow inflow : inflows) {
            total += inflow.getAmount();
        }
        return total;
    }

    public int totalOutflow() {
        int total = 0;
        for (Outflow outflow : outflows) {
            total += outflow.getAmount();
        }
        return total;
    }

    public int totalIncome() {
        return totalInflow() - totalOutflow();
    }

}
