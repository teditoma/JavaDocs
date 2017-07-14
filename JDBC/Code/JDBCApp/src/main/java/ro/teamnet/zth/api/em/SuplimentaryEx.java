package ro.teamnet.zth.api.em;

import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Theodor.Toma on 7/14/2017.
 */
public class SuplimentaryEx {
    public ArrayList<Employee> findEmployeesFromDepartment(String departmentName) throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        DepartmentDao dd = new DepartmentDao();

        ArrayList<Department> departments = (ArrayList<Department>) dd.findAll(Department.class);

        Map<String,Object> params = new HashMap<>();
        for (Department department : departments) {
            if (department.getDepartmentName().toLowerCase().contains(departmentName.toLowerCase()))
                params.put("department_id",10);
        }

        System.out.println(params);
        EntityManager em = new EntityManagerImpl();
        ArrayList<Employee> employees = (ArrayList<Employee>) em.findByParams(Employee.class,params);
        return employees;
    }
}
