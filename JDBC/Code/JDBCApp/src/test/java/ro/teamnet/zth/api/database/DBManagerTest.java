package ro.teamnet.zth.api.database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Theodor.Toma on 7/13/2017.
 */
public class DBManagerTest {
    @Test
    public void getConnectionTest() throws SQLException, ClassNotFoundException {
        Assert.assertNotNull(DBManager.getConnection());
    }
}
