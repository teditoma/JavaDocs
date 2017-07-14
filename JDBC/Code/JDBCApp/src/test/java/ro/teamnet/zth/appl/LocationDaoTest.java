package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Theodor.Toma on 7/14/2017.
 */
public class LocationDaoTest {
    @Test
    public void insertTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        LocationDao ld = new LocationDao();
        Location l = new Location();
        l.setCity("Braila");
        l.setPostalCode("161161");
        l.setStateProvince("Braila");
        l.setStreetAddress("25 Hipodrom");
        Location res = ld.insert(l);
        assertEquals("",new Long((3201)),res.getId());
        assertEquals("","Braila",res.getCity());
    }

    @Test
    public void updateTest() throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        LocationDao ld = new LocationDao();
        Location l = new Location();
        l.setId(new Long(3201));
        l.setCity("Buzau");
        l.setStreetAddress("32 Dorobanti");
        l.setStateProvince("Buzau");
        l.setPostalCode("111111");
        Location res = ld.update(l);
        assertEquals("","Buzau",res.getCity());
    }
    @Test
    public void deleteTest() throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        LocationDao ld = new LocationDao();
        Location l = new Location();
        l.setId(new Long(3201));
        ld.delete(l);

        List<Location> list = ld.findAll(Location.class);

        assertEquals("",23,list.size());
        assertEquals("","Roma",list.get(0).getCity());
        assertEquals("","Mexico City",list.get(list.size()-1).getCity());
    }

    @Test
    public void findAllTest() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        LocationDao ld = new LocationDao();
        List<Location> list = ld.findAll(Location.class);
        assertEquals("",23,list.size());
        assertEquals("","Roma",list.get(0).getCity());
        assertEquals("","Mexico City",list.get(list.size()-1).getCity());
    }

    @Test
    public void findByParamsTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        LocationDao ld = new LocationDao();

        Map<String,Object> params = new HashMap<>();
        params.put("postal_code","1689");

        List<Location> list = ld.findByParams(Location.class,params);

        assertEquals("",1,list.size());
        assertEquals("","Tokyo",list.get(0).getCity());
    }
}
