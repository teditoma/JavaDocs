package exercise3;

/**
 * Created by Theodor.Toma on 7/7/2017.
 */
public class StudentExt2 extends Student{
    public StudentExt2(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int hashCode() {
        return super.getFirstName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        if (obj == null) return false;

        StudentExt2 s = (StudentExt2)obj;
        if (!s.getFirstName().equals(super.getFirstName()))
            return false;
        if (!s.getLastName().equals(super.getLastName()))
            return false;
        return true;
    }
}
