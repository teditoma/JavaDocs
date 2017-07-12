package ro.teamnet.zth.appl.domain;

/**
 * Created by Theodor.Toma on 7/12/2017.
 */

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * CREATE TABLE JOBS (
 JOB_ID VARCHAR2(30) PRIMARY KEY,
 JOB_TITLE VARCHAR2(35),
 MIN_SALARY NUMBER,
 MAX_SALARY NUMBER
 );
 */
@Table(name="jobs")
public class Job {
    @Id(name="job_id")
    private long id;
    @Column(name="job_title")
    private String title;
    @Column(name="min_salary")
    private long min_salary;
    @Column(name="max_salary")
    private long max_salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (id != job.id) return false;
        if (min_salary != job.min_salary) return false;
        if (max_salary != job.max_salary) return false;
        return title != null ? title.equals(job.title) : job.title == null;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", min_salary=" + min_salary +
                ", max_salary=" + max_salary +
                '}';
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(long min_salary) {
        this.min_salary = min_salary;
    }

    public long getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(long max_salary) {
        this.max_salary = max_salary;
    }
}
