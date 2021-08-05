import kainos.employee_stuff.Employee;

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
    private static void enterEmployee(Connection c) {
        //String choice = console.readLine("Please enter an option:");


    }

}
