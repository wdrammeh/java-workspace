package types;

import java.text.DateFormat;
import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private final Date dateOfBirth;


    public Person(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        return String.format("%s %s %s", firstName, lastName, dateOfBirth == null? "Null" :
                            dateFormat.format(dateOfBirth));
    }

}
