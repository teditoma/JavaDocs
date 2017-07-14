package ro.teamnet.zth.api.database;

/**
 * Created by Theodor.Toma on 7/13/2017.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * -	create a private constructor with no params which will throw UnsupportedOperationException();
 -	create a constant field CONNECTION_STRING= "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT;", where IP and PORT will be taken
 from  DProperties file.
 -	create a  private static method registerDriver() for registering your driver. (Ex: Class.forName(DBProperties.DRIVER_CLASS) )
 -	create a public static method getConnection() with the following properties:
 •	method will return an object of type Connection;
 •	first you’ll have to register your driver;
 •	in order to obtain the connection object use DriverManager.getConnection with params: CONNECTION_STRING, USER and PASS from DBProperties file;
 -	create a public static method checkConnection(Connection connection) in which you’ll make a simple query to DB (SELECT 1 FROM DUAL) using Statement
 interface.

 */
public class DBManager {
    DBManager() throws UnsupportedOperationException{}

    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private static void registerDriver() throws ClassNotFoundException {
        Class.forName(DBProperties.DRIVER_CLASS);
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        registerDriver();
        return DriverManager.getConnection(CONNECTION_STRING,DBProperties.USER,DBProperties.PASS);
    }

    public static void checkConnection(Connection connection) {
        try {
            Statement statement = getConnection().prepareStatement("Select 1 from dual");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
