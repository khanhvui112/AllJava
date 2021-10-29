package fa.training.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author san vui
 * @create 19/10/2021 - 9:36 AM
 * @sanvankhanh@gmail.com
 */
@Entity
@Table(name = "Location",schema = "dbo")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_Id")
    private int locationId;

    @Column(name = "street_Address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Departments> departments;

    public Location() {
    }

    public Location(int locationId, String streetAddress, String city, List<Departments> departments) {
        this.locationId = locationId;
        this.streetAddress = streetAddress;
        this.city = city;
        this.departments = departments;
    }

    public Location(String streetAddress, String city) {
        this.streetAddress = streetAddress;
        this.city = city;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
