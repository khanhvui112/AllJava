package entites;

/**
 * @author san vui
 * @create 11/09/2021 - 15:47
 * @sanvankhanh@gmail.com
 */
public class Employee {
    private int employeeId;
    private String name;
    private  int experiences;

    public Employee(int employeeId, String name, int experiences) {
        this.employeeId = employeeId;
        this.name = name;
        this.experiences = experiences;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperiences() {
        return experiences;
    }

    public void setExperiences(int experiences) {
        this.experiences = experiences;
    }
}
