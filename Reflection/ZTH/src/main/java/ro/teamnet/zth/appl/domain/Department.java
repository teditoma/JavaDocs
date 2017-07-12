package ro.teamnet.zth.appl.domain;

/**
 * Created by Theodor.Toma on 7/12/2017.
 */

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * b)	Department.java
 -	create a public class Department.java, with the following private fields: id (Long), departmentName (String), location (Location);
 -	create getters and setters for fields above;
 -	override methods equals() and toString() (ALT+INSRT-> select equals()/toString()
 -> select all fields -> OK
 -	annotate columns defined and the entity with the correct annotation

 Example:
 @Id(name = "department_id")
 private Long id;
 ! OBS: You need to set “name” with the name of DB field for Location entity

 */
@Table(name="departments")
public class Department {
    @Id(name="department_id")
    private long id;
    @Column(name="department_departmentName")
    private String departmentName;
    @Column(name="department_location")
    private Location location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        return location != null ? location.equals(that.location) : that.location == null;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", location=" + location +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getdepartmentName() {
        return departmentName;
    }

    public void setdepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
