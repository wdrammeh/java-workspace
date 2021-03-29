package serial.types;

import java.io.Serializable;

/**
 * <p>For a class to be serialized successfully, two conditions must be met:</p>
 * <ol>
 *     <li>The class must extend the java.io.{@link java.io.Serializable} interface</li>
 *     <li>All the fields in the class must be marked serializable. If a field is not serializable,
 *     then it must be marked <b>transient</b>. <em>If a field is marked <b>transient</b>,
 *     its value won't be serialized!</em></li>
 * </ol>
 * <p><strong>By convention, java serialized files should have the extension .ser</strong></p>
 */
public class Employee implements Serializable {
    public String name;
    public String address;
    public int ssn;
    public Telephone telephone;
    public int age;


    public Employee(String name, String address, int ssn, Telephone telephone, int age) {
        this.name = name;
        this.address = address;
        this.ssn = ssn;
        this.telephone = telephone;
        this.age = age;
    }

}
