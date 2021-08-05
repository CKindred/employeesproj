package kainos.employee_stuff;

public class SalesEmployee extends Employee{
    public float getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(float comissionRate) {
        this.comissionRate = comissionRate;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    float comissionRate;
    int totalSales;

    public SalesEmployee(String name, String address, String NI, int salary, int employeeNum, float comissionRate, int totalSales) {
        super(name, address, NI, salary, employeeNum);
        this.comissionRate = comissionRate;
        this.totalSales = totalSales;
    }
}
