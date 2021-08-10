package inherit;

public class Donkey extends Animal {

    public Donkey(){
        super("Donkey");
    }

    public void bark(){
        System.out.println("Donkey is barking");
    }

    @Override
    public void printDetails() {
        System.out.println("Name: "+getName());
    }

}
