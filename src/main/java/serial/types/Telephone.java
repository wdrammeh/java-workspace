package serial.types;

public class Telephone {
    int code;
    String number;


    public Telephone(int code, String number) {
        this.code = code;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("+%d %s", code, number);
    }

}
