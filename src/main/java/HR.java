import kainos.employee_stuff.Employee;
import kainos.employee_stuff.SalesEmployee;
import kainos.employee_stuff.TechnicalEmployee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void highestSales() throws SQLException {
        Statement st = Main.c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees join salesEmployees using (empID) ORDER BY totalSales DESC");

        System.out.println("Employee with highest total sales: ");
        if(rs.next()) {
            Employee dbEmp = new SalesEmployee(rs.getInt("empID"), rs.getString("empName"),
                    rs.getString("address"), rs.getString("nationalInsurance"),
                    rs.getString("sortCode"), rs.getString("accountnumber"),
                    rs.getInt("salary"),
                    rs.getString("department"), rs.getString("startDate"), rs.getString("endDate"), rs.getFloat("commissionRate"), rs.getInt("totalSales"));
            System.out.println(dbEmp.getName());
            System.out.println(dbEmp);
        }

    }


    private static void enterEmployee(Connection c) {
        //String choice = console.readLine("Please enter an option:");


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
}
