package ro.teamnet.zth.appl.domain;

/**
 * Created by Theodor.Toma on 7/12/2017.
 */

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
a)	Location.java
-	create a public class Location.java with the following private fields: id (Long), streetAddress (String), postalCode (String),
 city (String), stateProvince (String);
-	generate getters and setters for fields above(ALT+INSERT -> Getter and Setter -> select all fields -> OK;
-	override methods equals() and toString() (ALT+INSRT-> select equals()/toString()
-> select all fields -> OK
-	annotate columns defined and the entity with the correct annotation

Example:
 @Id(name = "location_id")
   private Long id;
! OBS: You need to set “name” with the name of DB field for Location entity

 */

@Table(name="locations")
public class Location {
    @Id(name="location_id")
    private long id;
    @Column(name="location_streetAddress")
    private String streetAddress;
    @Column(name="location_postalCode")
    private String postalCode;
    @Column(name="location_city")
    private String city;
    @Column(name="location_stateProvince")
    private String stateProvince;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (streetAddress != null ? !streetAddress.equals(location.streetAddress) : location.streetAddress != null)
            return false;
        if (postalCode != null ? !postalCode.equals(location.postalCode) : location.postalCode != null) return false;
        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        return stateProvince != null ? stateProvince.equals(location.stateProvince) : location.stateProvince == null;
    }

}
