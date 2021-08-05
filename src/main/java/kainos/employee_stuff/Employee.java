package kainos.employee_stuff;

import java.sql.Connection;

public class Employee {
    private String name;
    private String address;
    private String NI;
    private int salary;
    private int employeeNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNI() {
        return NI;
    }

    public void setNI(String NI) {
        this.NI = NI;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public Employee(String name, String address, String NI, int salary, int employeeNum){
        this.name = name;
        this.address = address;
        this.NI = NI;
        this.salary = salary;
        this.employeeNum = employeeNum;
    }





}
