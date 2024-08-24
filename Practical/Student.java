package Practical;
import java.sql.*;
public class Student {

    public static void main(String [] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementdb","jignesh","");
        Statement st = con.createStatement();
        
    }

}
