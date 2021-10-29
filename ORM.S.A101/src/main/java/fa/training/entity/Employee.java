package fa.training.entity;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

/**
 * @author san vui
 * @create 19/10/2021 - 2:55 PM
 * @sanvankhanh@gmail.com
 */
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_Name",length = 50,nullable = false)
    private String firstName;

    @Column(name = "last_Name",length = 50,nullable = false)
    private String lastName;

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "id=" + id +"\t\t\t"+
                "firstName=" + firstName +"\t\t\t"+
                "lastName=" + lastName +"\t\t\t"+"\n";
    }
}

