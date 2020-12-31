package mysqli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {


    public static void main(String[] args) {
        try {
            final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/smateq","root","");
            final Statement statement = connection.createStatement();
            final ResultSet result = statement.executeQuery("SELECT * FROM staffs");
            while (result.next()){
                System.out.println(result.getString("id")+": "+result.getString("user_name"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
