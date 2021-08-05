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
            System.out.println("1) enter an employee");
            System.out.println("2) generate report of employees by department");
            System.out.println("4) generate employee pay report");
            System.out.println("5) display employee with highest sales");
            System.out.println("6) show projects with no employees assigned");
            System.out.println("7) show employees with no projects");
            String choice = obj.readLine();
            if (choice.equals("1")) {
                HR.enterEmployee();
            } else if (choice.equals("2")) {
                HR.genReport();
            } else if (choice.equals("4")) {
                HR.genPayReport();
            } else if (choice.equals("5")) {
                HR.highestSales();
            } else if (choice.equals("6")) {
                HR.emptyProject();
            } else if (choice.equals("7")) {
                HR.empNoProject();
            }

        } catch (IOException e) {
            System.out.println("Failed to load properties file");
            e.printStackTrace();
        }
    }

}
