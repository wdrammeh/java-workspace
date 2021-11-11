package types;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Tester {

    public static void main(String[] args) throws ParseException {
        DateFormat format = SimpleDateFormat.getDateInstance(DateFormat.DEFAULT,
        Locale.US);

        final ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Muhammed", "Drammeh",
                format.parse("Jan 1, 1999")));
        persons.add(new Person("Modou", "Touray",
                format.parse("Sep 11, 1998")));
        persons.add(new Person("Yusuf", "Drammeh",
                format.parse("Feb 21, 2011")));
        persons.add(new Person("Baba", "Charty",
                format.parse("Nov 3, 1996")));

        System.out.println(persons);

        Person person = persons.get(2);
        System.out.println(person);

        person.setFirstName("New First Name");
        System.out.println(person);
        System.out.println(persons);
        
        person = new Person("F","L", null);
        System.out.println(person);
        System.out.println(persons);
        System.out.println(persons.contains(person));
    }

}
