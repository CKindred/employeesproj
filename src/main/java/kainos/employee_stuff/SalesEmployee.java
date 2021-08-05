package kainos.employee_stuff;

public class SalesEmployee extends Employee{
    private final float comissionRate;
    private final int totalSales;

    public SalesEmployee(int employeeNum, String name, String address, String NI, String sortCode, String accountNum, int salary, String department, String startDate, String endDate, float comissionRate, int totalSales) {
        super(employeeNum, name, address, NI, sortCode, accountNum, salary, department, startDate, endDate);
        this.comissionRate = comissionRate;
        this.totalSales = totalSales;
    }
}
