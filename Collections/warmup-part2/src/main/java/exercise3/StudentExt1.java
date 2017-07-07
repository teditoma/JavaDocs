package exercise3;

/**
 * Created by Theodor.Toma on 7/7/2017.
 */
public class StudentExt1 extends Student {

    public StudentExt1(String firstName, String lastName) {
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

        StudentExt1 s = (StudentExt1)obj;
        if (!s.getFirstName().equals(super.getFirstName()))
            return false;
        return true;
    }
}
