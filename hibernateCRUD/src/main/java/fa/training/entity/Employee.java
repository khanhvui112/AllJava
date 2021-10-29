package fa.training.entity;

import org.hibernate.annotations.Check;

import javax.persistence.*;

/**
 * @author san vui
 * @create 15/10/2021 - 8:03 PM
 * @sanvankhanh@gmail.com
 */
@Entity
@Table(name = "Employee")
@Check(constraints = "gender = N'Nam' or gender = N'Nữ'")
public class Employee {

    @Id
    @Column(name = "employee_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(columnDefinition = "nvarchar(50)")
    private String fullName;

    @Column(columnDefinition = "nvarchar(4)")
    private String gender;

    @Column(columnDefinition = "nvarchar(100)")
    private String address;

    public Employee() {
    }
    public Employee(String fullName, String gender, String address) {
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
    }

    public Employee(int employeeId, String fullName, String gender, String address) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
