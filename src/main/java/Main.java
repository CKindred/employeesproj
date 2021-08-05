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
            System.out.println("3) generate employee pay report");
            System.out.println("4) reset sales period");
            String choice = obj.readLine();
            switch (choice){
                case("1"):
                    HR.displayEmployee();
                case("2"):
                    HR.genReport();
                case("3"):
                    HR.genPayReport();
                case("4"):
                    HR.resetSalesPeriod();
            }

        } catch (IOException e) {
            System.out.println("Failed to load properties file");
            e.printStackTrace();
        }
    }

}
