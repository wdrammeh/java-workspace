package serial.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import serial.types.Employee;

import java.io.File;

public class XStreamDemo {

    public static void main(String[] args) {
        XStream xStream = new XStream(new DomDriver());
//        Employee employee = new Employee("Muhammed Drammeh", "Sukuta",
//                2243, new Telephone(220, "341-3910"));
////        xStream.alias("employee", Employee.class);
////        xStream.alias("telephone", Telephone.class);
//
//        String xml = xStream.toXML(employee);
//        System.out.println(xml);
//        try {
//            FileWriter writer = new FileWriter("employee.xml");
//            writer.write(xml);
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

        xStream.addPermission(AnyTypePermission.ANY);
//        xStream.aliasField("eName", Employee.class, "name");
        Employee muhammed = (Employee) xStream.fromXML(new File("employee.xml"));
        System.out.println(muhammed.name);
        System.out.println(muhammed.address);
        System.out.println(muhammed.ssn);
        System.out.println(muhammed.telephone);
        System.out.println(muhammed.age);
    }

}
