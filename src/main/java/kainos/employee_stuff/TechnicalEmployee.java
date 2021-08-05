package kainos.employee_stuff;

public class TechnicalEmployee extends Employee{
    private String bio;
    private String imgURL;
    public TechnicalEmployee(String name, String address, String NI, int salary, int employeeNum, String bio, String imgURL) {
        super(name, address, NI, salary, employeeNum);
        this.bio = bio;
        this.imgURL = imgURL;
    }
}
