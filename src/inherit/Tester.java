package inherit;

public class Tester {


    public static void main(String[] args) {
        Animal a = new Cow();
        a.printDetails();
//        a.run(); // not possible
//        to do so, downcast the animal to a cow
        Cow c = (Cow) a;
        c.run();

//        down-casting may not always work
        Animal b = new Cow();
//        Donkey d = (Donkey) b;  // will throw a ClassCastException

//        but up-casting always work; and it's automatic
        Donkey donkey = new Donkey();
        Animal animal = donkey;
    }

}
