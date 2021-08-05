import kainos.employee_stuff.Employee;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Main {

    public static Connection c;
    public static void main(String[] args) throws SQLException {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(rootPath);
        String configPath = rootPath + "config.properties";

        Properties config = new Properties();
        try {
            config.load(new FileInputStream(configPath));
            String username = config.getProperty("username");
            String password = config.getProperty("password");
            //System.out.println("username: " + username + " password: " + password);

            c = DriverManager.getConnection(
                    "jdbc:mysql://academy2020.cpc8rvmbbd9k.eu-west-2.rds.amazonaws.com/DB_teamrocket?useSSL=false",
                    username, password);  // Bad practices alert!


            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("select an option");
            System.out.println("1) view all employees");
            System.out.println("2) generate report of employees by department");
            String choice = obj.readLine();
            if (choice.equals("1")) {
                HR.displayEmployee();
            } else if (choice.equals("2")) {
                HR.genReport();
            } else if (choice.equals("3")) {
                HR.genPayReport();
            } else if (choice.equals("4")) {
                HR.resetSalesPeriod();
            } else if (choice.equals("5")) {
                HR.enterEmployee();
            }

        } catch (IOException e) {
            System.out.println("Failed to load properties file");
            e.printStackTrace();
        }
    }

}
