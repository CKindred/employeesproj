import kainos.employee_stuff.Employee;
import kainos.employee_stuff.SalesEmployee;
import kainos.employee_stuff.TechnicalEmployee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HR {
    public static void displayEmployee() throws SQLException {
        Statement st = Main.c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * FROM employees");
        while (rs.next()) {
            Employee dbEmp = new Employee(rs.getInt("empID"), rs.getString("empName"),
                    rs.getString("address"), rs.getString("nationalInsurance"),
                    rs.getString("sortCode"), rs.getString("accountnumber"),
                    rs.getInt("salary"),
                    rs.getString("department"), "startDate", "endDate");
            System.out.println(dbEmp);
        }
    }

    public static void enterEmployee()throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Please enter their name:");
            String name = obj.readLine();
            System.out.println("Please enter their address:");
            String address = obj.readLine();
            System.out.println("Please enter their NI number:");
            String niNumber = obj.readLine();
            if (niNumber.length() != 13) {
                System.out.println("ni number must be 13 characters long");
                System.exit(0);
            }
            System.out.println("Please enter their sort code:");
            String sortCode = obj.readLine();
            if (sortCode.length() != 8) {
                System.out.println("sort code must be 8 characters long");
                System.exit(0);
            }
            System.out.println("Please enter their account number:");
            String accountNumber = obj.readLine();
            if (accountNumber.length() != 8) {
                System.out.println("account number must be 8 characters long");
                System.exit(0);
            }
            System.out.println("Please enter their salary:");
            String salary = obj.readLine();
            System.out.println("Please enter their department:");
            String department = obj.readLine().toLowerCase();
            List<String> departments = new ArrayList<>();
            departments.add("sales");
            departments.add("technical");
            if (!departments.contains(department)) {
                System.out.println("the department must be one of the following: ");
                System.out.println(departments);
                System.exit(0);
            }
            PreparedStatement preparedStatement = Main.c.prepareStatement("INSERT INTO employees " +
                    "(empName, address, nationalInsurance, sortCode, accountnumber, salary,department) " +
                    "VALUES (?,?,?,?,?,?,?) ");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,address);
            preparedStatement.setString(3,niNumber);
            preparedStatement.setString(4,sortCode);
            preparedStatement.setInt(5, Integer.parseInt(accountNumber));
            preparedStatement.setInt(6, Integer.parseInt(salary));
            preparedStatement.setString(7,department);
            preparedStatement.execute();
            /*
            if(department.equals("sales")){
                ResultSet rs = preparedStatement.getGeneratedKeys();
                System.out.println(rs);
                enterSalesEmployee(rs.getInt(1));
            }*/

        }catch(SQLException e){
            System.out.println("Problem with the SQL statement");
            e.printStackTrace();


        }catch(IOException e){
            System.out.println("Incorrect input");
        }



    }


    public static void genReport() throws SQLException {
        Statement st = Main.c.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM employees join techEmployees using (empID)");
        System.out.println("Technical employees: ");
        while (rs.next()) {
            Employee dbEmp = new TechnicalEmployee(rs.getInt("empID"), rs.getString("empName"),
                    rs.getString("address"), rs.getString("nationalInsurance"),
                    rs.getString("sortCode"), rs.getString("accountnumber"),
                    rs.getInt("salary"),
                    rs.getString("department"), rs.getString("startDate"), rs.getString("endDate"), rs.getString("cv"), rs.getString("photo"));
            System.out.println(dbEmp);
        }

        rs = st.executeQuery("SELECT * FROM employees join salesEmployees using (empID)");
        System.out.println("\nSales Employees: ");

        while (rs.next()) {
            Employee dbEmp = new SalesEmployee(rs.getInt("empID"), rs.getString("empName"),
                    rs.getString("address"), rs.getString("nationalInsurance"),
                    rs.getString("sortCode"), rs.getString("accountnumber"),
                    rs.getInt("salary"),
                    rs.getString("department"), rs.getString("startDate"), rs.getString("endDate"), rs.getFloat("commissionRate"), rs.getInt("totalSales"));
            System.out.println(dbEmp);
        }
    }

    public static void genPayReport() throws SQLException {
        System.out.println("***Employee Pay Report***");
        System.out.println("Name           Net Pay\n");
        Statement st = Main.c.createStatement();

        ResultSet rs = st.executeQuery("SELECT empName, salary FROM employees join techEmployees using (empID)");
        System.out.println("Technical employees: ");
        while (rs.next()) {
            float netPay = rs.getInt("salary") * 0.75f;
            System.out.println(rs.getString("empName") + ": " + netPay);
        }
        System.out.println();
        rs = st.executeQuery("SELECT empName, salary, commissionRate, totalSales FROM employees join salesEmployees using (empID)");
        System.out.println("Sales employees: ");
        while (rs.next()) {
            float payAfterTax = rs.getInt("salary") * 0.75f;
            float totalCommission = rs.getFloat("commissionRate") * rs.getInt("totalSales");
            float netPay = payAfterTax + totalCommission;

            System.out.println(rs.getString("empName") + ": " + netPay);
        }
    }

    public static void resetSalesPeriod() {
        Statement st = null;
        try {
            st = Main.c.createStatement();
            st.executeUpdate("UPDATE salesEmployees set totalSales=0");
        } catch (SQLException throwables) {
            System.out.println("Failed to reset sales period");
            throwables.printStackTrace();
        }
    }
}
