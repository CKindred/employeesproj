import kainos.employee_stuff.Employee;
import kainos.employee_stuff.SalesEmployee;
import kainos.employee_stuff.TechnicalEmployee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public static void emptyProject() throws SQLException {
        Statement st = Main.c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM projects WHERE projectID NOT IN (SELECT projectID FROM employeeProjects)");
        if(rs.next()) {
            System.out.println("Projects without employees: ");
            System.out.println("Project ID: " + rs.getInt("projectID") + '\'' +
                    "Project Name: " + rs.getString("projectName")+ '\'' +
                    "Project Describe: " + rs.getString("description") + '\'' +
                    "Start Date: " + rs.getString("startDate") + '\'' +
                    "End Date: " + rs.getString("endDate")

            );
        } else {
            System.out.println("All projects have been assigned employees");
        }

    }

    public static void empNoProject() throws SQLException {
        Statement st = Main.c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees WHERE empID NOT IN (SELECT empID FROM employeeProjects)");
        System.out.println("Employees without projects: ");
        if (rs.next() == false) {
            System.out.println("All employees have been assigned projects");
        }
        while (rs.next()) {
                Employee dbEmp = new Employee(rs.getInt("empID"), rs.getString("empName"),
                        rs.getString("address"), rs.getString("nationalInsurance"),
                        rs.getString("sortCode"), rs.getString("accountnumber"),
                        rs.getInt("salary"),
                        rs.getString("department"), "startDate", "endDate");
                System.out.println(dbEmp);
        }

    }

    public static void empsOnProj() throws SQLException{
//        Statement st = Main.c.createStatement();
//        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM projects");
//        int numofproj = rs.getInt(1);
//        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM employeeProjects GROUP BY projectID");
//        for(int x = 1 ; x<numofproj; x++){
//            ArrayList[] totals = new ArrayList;
//            ((ArrayList) totals).add(rs.getInt(x));
//
//        }
//        ResultSet rs2 = st.executeQuery("SELECT * FROM projects");
//        System.out.println("Project: ");
//        while(rs2.next()){
//            System.out.println(
//                    "Project ID: " + rs2.getInt("projectID") + '\'' +
//                            ", Project Name: " + rs2.getString("projectName")+ '\'' +
//                            ", Project Describe: " + rs2.getString("description") + '\'' +
//                            ", has: " + '\''
//            );
//            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM employeeProjects GROUP BY projectID");
//            if(rs.next() == true) {
//                System.out.println(
//                        rs.getInt(1) + " employees"
//                );
//            }
//
//        }
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
