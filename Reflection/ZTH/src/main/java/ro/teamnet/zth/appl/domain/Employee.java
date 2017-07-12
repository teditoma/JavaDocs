package ro.teamnet.zth.appl.domain;

/**
 * Created by Theodor.Toma on 7/12/2017.
 */

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.util.Date;

/**
 * CREATE TABLE EMPLOYEES (
 EMPLOYEE_ID NUMBER PRIMARY KEY,
 FIRST_NAME VARCHAR2(20),
 LAST_NAME VARCHAR2(25) NOT NULL ,
 EMAIL VARCHAR2(25) NOT NULL,
 PHONE_NUMBER VARCHAR2(20),
 HIRE_DATE DATE NOT NULL ,
 JOB_ID VARCHAR2(30) NOT NULL ,
 SALARY NUMBER(8,2),
 COMMISSION_PCT NUMBER(2,2),
 MANAGER_ID NUMBER,
 DEPARTMENT_ID NUMBER
 );
 */
@Table(name="employees")
public class Employee {
    @Id(name="employee_id")
    private long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="hire_date")
    private Date hireDate;
    @Column(name="job_id")
    private long jobId;
    @Column(name="salary")
    private long salary;
    @Column(name="comission")
    private long comission;
    @Column(name="manager_id")
    private long managerId;
    @Column(name="department_id")
    private long departmentId;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", jobId=" + jobId +
                ", salary=" + salary +
                ", comission=" + comission +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (jobId != employee.jobId) return false;
        if (salary != employee.salary) return false;
        if (comission != employee.comission) return false;
        if (managerId != employee.managerId) return false;
        if (departmentId != employee.departmentId) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null)
            return false;
        return hireDate != null ? hireDate.equals(employee.hireDate) : employee.hireDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (int) (jobId ^ (jobId >>> 32));
        result = 31 * result + (int) (salary ^ (salary >>> 32));
        result = 31 * result + (int) (comission ^ (comission >>> 32));
        result = 31 * result + (int) (managerId ^ (managerId >>> 32));
        result = 31 * result + (int) (departmentId ^ (departmentId >>> 32));
        return result;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getComission() {
        return comission;
    }

    public void setComission(long comission) {
        this.comission = comission;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
}
