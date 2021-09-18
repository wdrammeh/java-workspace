package utils;

public class Particle {
    int position;
    String direction;
    public static final String LEFT = "Left";
    public static final String RIGHT = "Right";
    public static final String UNDEFINED = "Undefined";


    public Particle(int position, String direction) {
        this.position = position;
        this.direction = direction;
    }

    void move(){
        if (direction.equals(RIGHT)) {
            position++;
        } else if (direction.equals(LEFT)) {
            position--;
        }
    }

    void shiftDirection(){
        if (direction.equals(LEFT)) {
            direction = RIGHT;
        } else if (direction.equals(RIGHT)) {
            direction = LEFT;
        }
    }

}
