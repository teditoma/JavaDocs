package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.List;

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
        d.setLocation(new Long(700));
        Department res = em.insert(d);
        assertEquals("","solutions",res.getDepartmentName());
    }

    @Test
    public void findAllTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        EntityManager em = new EntityManagerImpl();
        List<Department> list = em.findAll(Department.class);
        assertEquals("",27,list.size());
        assertEquals("","Administration",list.get(0).getDepartmentName());
        assertEquals("","Payroll",list.get(list.size()-1).getDepartmentName());
    }
}
