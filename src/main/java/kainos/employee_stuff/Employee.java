package kainos.employee_stuff;

public class Employee {
    private String name;
    private String address;
    private String NI;
    private int salary;
    private int employeeNum;
    String sortCode;
    String accountNum;
    String department;
    String startDate;

    @Override
    public String toString() {
        return "Employee: " +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", NI='" + NI + '\'' +
                ", salary=" + salary +
                ", employeeNum=" + employeeNum +
                ", sortCode='" + sortCode + '\'' +
                ", accountNum='" + accountNum + '\'' +
                ", department='" + department + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'';
    }

    String endDate;

    public Employee(int employeeNum, String name, String address, String NI, String sortCode, String accountNum,
                    int salary, String department, String startDate, String endDate) {
        this.name = name;
        this.address = address;
        this.NI = NI;
        this.salary = salary;
        this.employeeNum = employeeNum;
        this.sortCode = sortCode;
        this.accountNum = accountNum;
        this.department = department;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }
}





