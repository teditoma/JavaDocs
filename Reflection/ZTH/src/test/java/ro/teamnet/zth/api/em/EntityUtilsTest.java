package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import static org.junit.Assert.assertEquals;

/**
 * Created by Theodor.Toma on 7/12/2017.
 */
public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod1() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetTableNameMethod2() {
        String tableName = EntityUtils.getTableName(Employee.class);
        assertEquals("Table name should be departments!", "employees", tableName);
    }
}
