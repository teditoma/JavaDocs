package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Theodor.Toma on 7/14/2017.
 */
public class LocationDao {
    EntityManager em = new EntityManagerImpl();

    public Location insert(Location entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        return em.insert(entity);
    }

    public List<Location> findAll(Class<Location> entityClass) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        return em.findAll(entityClass);
    }

    public Location update(Location entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        return em.update(entity);
    }

    public void delete(Location entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        em.delete(entity);
    }

    public List<Location> findByParams(Class<Location> entityClass, Map<String, Object> params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        return em.findByParams(entityClass,params);
    }
}
