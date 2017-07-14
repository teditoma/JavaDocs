package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Theodor.Toma on 7/14/2017.
 */
public class DepartmentDaoTest {
    @Test
    public void insertTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        DepartmentDao dd = new DepartmentDao();
        Department d = new Department();
        d.setDepartmentName("solutions");
        d.setLocation(new Long(1700));
        Department res = dd.insert(d);
        assertEquals("","solutions",res.getDepartmentName());
    }

    @Test
    public void updateTest() throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        DepartmentDao dd = new DepartmentDao();
        Department d = new Department();
        d.setDepartmentName("new_solutions");
        d.setId((long) 271);
        d.setLocation((long) 1700);
        d.setDepartmentName("new_solution");
        Department res = dd.update(d);

        assertEquals("","new_solution",res.getDepartmentName());
    }
    @Test
    public void deleteTest() throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        DepartmentDao dd = new DepartmentDao();
        Department d = new Department();
        d.setId((long) 271);
        dd.delete(d);

        List<Department> list = dd.findAll(Department.class);
        assertEquals("",27,list.size());
        assertEquals("","Administration",list.get(0).getDepartmentName());
        assertEquals("","Payroll",list.get(list.size()-1).getDepartmentName());
    }

    @Test
    public void findAllTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        DepartmentDao dd = new DepartmentDao();
        List<Department> list = dd.findAll(Department.class);
        assertEquals("",27,list.size());
        assertEquals("","Administration",list.get(0).getDepartmentName());
        assertEquals("","Payroll",list.get(list.size()-1).getDepartmentName());
    }

    @Test
    public void findByParamsTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        DepartmentDao dd = new DepartmentDao();

        Map<String,Object> params = new HashMap<>();
        params.put("location_id",1700);

        List<Department> list = dd.findByParams(Department.class,params);

        assertEquals("",21,list.size());
        assertEquals("","Administration",list.get(0).getDepartmentName());
        assertEquals("","Payroll",list.get(list.size()-1).getDepartmentName());
    }
}
