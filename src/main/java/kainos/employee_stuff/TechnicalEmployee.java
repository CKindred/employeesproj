package kainos.employee_stuff;

public class TechnicalEmployee extends Employee{
    private final String photo;
    private final String cv;

    public TechnicalEmployee(int employeeNum, String name, String address, String NI, String sortCode, String accountNum, int salary, String department, String startDate, String endDate, String cv, String photo) {
        super(employeeNum, name, address, NI, sortCode, accountNum, salary, department, startDate, endDate);
        this.cv = cv;
        this.photo = photo;
    }
}
