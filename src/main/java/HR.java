import kainos.employee_stuff.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.Console;
public class HR {


    public static void main(String[] args) throws SQLException {
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://academy2020.cpc8rvmbbd9k.eu-west-2.rds.amazonaws.com/employees?useSSL=false",
                "empsuser", "empPwd!");  // Bad practices alert!
        Statement st = c.createStatement();

//        Console console = System.console();
//        System.out.println("Enter 1 for entering an employee, etc");
//        String choice = console.readLine("Please enter an option:");
//        switch (choice){
//            case("1"):
//                enterEmployee(c);
//        }



    }

    private static void enterEmployee(Connection c) {
        //String choice = console.readLine("Please enter an option:");


    }


}
