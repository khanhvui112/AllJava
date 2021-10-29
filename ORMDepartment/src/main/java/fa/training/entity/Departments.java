package fa.training.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author san vui
 * @create 19/10/2021 - 9:29 AM
 * @sanvankhanh@gmail.com
 */
@Entity
@Table(name = "Departments",schema = "dbo")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_Id")
    private int departmentId;

    @Column(name = "department_Name")
    private String departmentName;

    @Column(name = "location_Id")
    private int locationId;

    @OneToMany(mappedBy = "departments",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Employees> employees;

    @ManyToOne
    @JoinColumn(name = "location_Id", referencedColumnName = "location_Id", insertable = false, updatable = false)
    private Location location;

    public Departments() {
    }

    public Departments(String departmentName, int locationId) {
        this.departmentName = departmentName;
        this.locationId = locationId;
    }

    public Departments(int departmentId, String departmentName, int locationId, List<Employees> employees) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.locationId = locationId;
        this.employees = employees;
    }

    public Departments(int departmentId, String departmentName, int locationId, List<Employees> employees, Location location) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.locationId = locationId;
        this.employees = employees;
        this.location = location;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", locationId=" + locationId +
                ", employees=" + employees +
                '}';
    }
}
