package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Theodor.Toma on 7/14/2017.
 */
public class DepartmentDao {
    EntityManager em = new EntityManagerImpl();

    public Department insert(Department entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        return em.insert(entity);
    }

    public List<Department> findAll(Class<Department> entityClass) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        return em.findAll(entityClass);
    }

    public Department update(Department entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        return em.update(entity);
    }

    public void delete(Department entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        em.delete(entity);
    }

    public List<Department> findByParams(Class<Department> entityClass, Map<String, Object> params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        return em.findByParams(entityClass,params);
    }
}
