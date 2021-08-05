package kainos.employee_stuff;

public class SalesEmployee extends Employee{
    float comissionRate;
    int totalSales;

    public SalesEmployee(String name, String address, String NI, int salary, int employeeNum, float comissionRate, int totalSales) {
        super(name, address, NI, salary, employeeNum);
        this.comissionRate = comissionRate;
        this.totalSales = totalSales;
    }
}
