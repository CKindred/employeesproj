package kainos.employee_stuff;

public class TechnicalEmployee extends Employee{
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    private String bio;
    private String imgURL;
    public TechnicalEmployee(String name, String address, String NI, int salary, int employeeNum, String bio, String imgURL) {
        super(name, address, NI, salary, employeeNum);
        this.bio = bio;
        this.imgURL = imgURL;
    }
}
