package test.cmp103.abc;

public class Beverage {
    private int number;
    private String type;
    private double price;


    public Beverage(int number, String type, double price) {
        this.number = number;
        this.type = type;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
