package exercise3;

/**
 * Created by Theodor.Toma on 7/7/2017.
 */
public class StudentExt3 extends Student {
    public StudentExt3(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int hashCode() {
        return super.getFirstName().hashCode() + 31 * super.getLastName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        if (obj == null) return false;

        StudentExt3 s = (StudentExt3)obj;
        if (!s.getFirstName().equals(super.getFirstName()))
            return false;

        return true;
    }
}
