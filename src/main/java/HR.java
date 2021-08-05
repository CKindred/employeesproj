import kainos.employee_stuff.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.Console;
import java.util.Properties;

public class HR {


    public static void main(String[] args) throws SQLException {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(rootPath);
        String configPath = rootPath + "config.properties";

        Properties config = new Properties();
        try {
            config.load(new FileInputStream(configPath));
            String username = config.getProperty("username");
            String password = config.getProperty("password");
            System.out.println("username: " + username + " password: " + password);

            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://academy2020.cpc8rvmbbd9k.eu-west-2.rds.amazonaws.com/employees?useSSL=false",
                    username, password);  // Bad practices alert!
            Statement st = c.createStatement();

        } catch (IOException e) {
            System.out.println("Failed to load properties file");
            e.printStackTrace();
        }

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
