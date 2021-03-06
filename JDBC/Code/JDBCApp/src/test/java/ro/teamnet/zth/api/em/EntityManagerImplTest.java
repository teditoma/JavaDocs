package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Theodor.Toma on 7/13/2017.
 */
public class EntityManagerImplTest {

    @Test
    public void findByIdTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        EntityManager em = new EntityManagerImpl();
        Department department = em.findById(Department.class,new Long(10));
        assertEquals("","Administration",department.getDepartmentName());
    }

    @Test
    public void getNextIdValTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        EntityManager em = new EntityManagerImpl();
        Long id = em.getNextIdVal("departments","department_id");
        assertEquals("",new Long(271),id);
    }

    @Test
    public void insertTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        EntityManager em = new EntityManagerImpl();
        Department d = new Department();
        d.setDepartmentName("solutions");
        d.setLocation(new Long(1700));
        Department res = em.insert(d);
        assertEquals("","solutions",res.getDepartmentName());
    }

    @Test
    public void updateTest() throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        EntityManager em = new EntityManagerImpl();
        Department d = new Department();
        d.setDepartmentName("new_solutions");
        d.setId((long) 271);
        d.setLocation((long) 1700);
        d.setDepartmentName("new_solution");
        Department res = em.update(d);

        assertEquals("","new_solution",res.getDepartmentName());
    }
    @Test
    public void deleteTest() throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        EntityManager em = new EntityManagerImpl();
        Department d = new Department();
        d.setId((long) 271);
        em.delete(d);

        List<Department> list = em.findAll(Department.class);
        assertEquals("",27,list.size());
        assertEquals("","Administration",list.get(0).getDepartmentName());
        assertEquals("","Payroll",list.get(list.size()-1).getDepartmentName());
    }

    @Test
    public void findAllTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        EntityManager em = new EntityManagerImpl();
        List<Department> list = em.findAll(Department.class);
        assertEquals("",27,list.size());
        assertEquals("","Administration",list.get(0).getDepartmentName());
        assertEquals("","Payroll",list.get(list.size()-1).getDepartmentName());
    }

    @Test
    public void findByParamsTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        EntityManager em = new EntityManagerImpl();

        Map<String,Object> params = new HashMap<>();
        params.put("location_id",1700);

        List<Department> list = em.findByParams(Department.class,params);

        assertEquals("",21,list.size());
        assertEquals("","Administration",list.get(0).getDepartmentName());
        assertEquals("","Payroll",list.get(list.size()-1).getDepartmentName());
    }
}
