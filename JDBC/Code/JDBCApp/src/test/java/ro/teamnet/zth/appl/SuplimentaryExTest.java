package ro.teamnet.zth.appl;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.api.em.SuplimentaryEx;
import ro.teamnet.zth.appl.domain.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Theodor.Toma on 7/14/2017.
 */
public class SuplimentaryExTest {
    @Test
    public void selectEmployeesTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        SuplimentaryEx se = new SuplimentaryEx();
        ArrayList<Employee> employees = se.findEmployeesFromDepartment("Administration");
        Assert.assertEquals("",1,employees.size());
    }
}
