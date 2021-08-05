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
