package model;

/**
 * Created by Theodor.Toma on 7/18/2017.
 */
public class Person {
    private String lastName;
    private String firstName;
    private Long age;
    private Boolean isMarried;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                '}';
    }

    public Person(String firstName, String lastName, Long age, Boolean isMarried) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.isMarried = isMarried;
    }

    public Person() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Boolean getMarried() {
        return isMarried;
    }

    public void setMarried(Boolean married) {
        isMarried = married;
    }
}
