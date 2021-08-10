package inherit;

public class Cow extends Animal {

    public Cow(){
        super("Cow");
    }

    public void run(){
        System.out.println("Cow is running");
    }

    @Override
    public void printDetails() {
        System.out.println("Name: "+getName());
    }

}
