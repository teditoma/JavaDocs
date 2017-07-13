package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Department;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Theodor.Toma on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {
    @Override
    public <T> T findById(Class<T> entityClass, Long id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        ArrayList<ColumnInfo> columns = (ArrayList<ColumnInfo>) EntityUtils.getColumns(entityClass);
        ArrayList<Field> idColums = (ArrayList<Field>) EntityUtils.getFieldsByAnnotations(entityClass,Id.class);
        ArrayList<Field> columnColums = (ArrayList<Field>) EntityUtils.getFieldsByAnnotations(entityClass,Column.class);

        Condition condition = new Condition();
        condition.setValue(id);
        for (ColumnInfo columnInfo : columns){
            if(columnInfo.isId()) {
                System.out.println(columnInfo.getDbColumnName());
                condition.setColumnName(columnInfo.getDbColumnName());
            }
        }

        QueryBuilder qb =  new QueryBuilder();
        qb.setTableName(tableName);
        qb.setQueryType(QueryType.SELECT);
        qb.addCondition(condition);
        qb.addQueryColumns(columns);
        String query = qb.createQuery();

        Statement ps = connection.createStatement();
        ResultSet resultSet = ps.executeQuery(query);

        if (resultSet.next()) {
            T instance = entityClass.newInstance();

            for (ColumnInfo column : columns) {
                Field f = instance.getClass().getDeclaredField(column.getColumnName());
                f.setAccessible(true);
                f.set(instance,EntityUtils.castFromSqlType(resultSet.getObject(column.getDbColumnName()),f.getType()));
            }
            connection.close();
            return instance;
        }
        connection.close();
        return null;
    }

    @Override
    public Long getNextIdVal(String tableName, String columnIdName) throws SQLException, ClassNotFoundException {
        Connection connection = DBManager.getConnection();
        String query = "select max(" + columnIdName + ") from " + tableName;
        Statement ps = connection.createStatement();
        ResultSet resultSet = ps.executeQuery(query);
        if (resultSet.next()) {
            Long res = resultSet.getLong(1);
            connection.close();
            return  res + 1;
        }
        connection.close();
        return null;
    }

    /**
     * c)	Method <T> Object insert(T entity)
     -	iterate through ColumnInfo list
     o	if the column is an id, set its value using getNextIdVal method;
     o	else call getDeclaredField by column name on entity T;
     o	make the field accessible;
     o	set the value of the columnInfo with the value obtained from the field;

     -	create a QueryBuilder object  in which you have to set the name of the table, columns, query type;
     -	call createQuery() method from QueryBuilder.java;
     -	create a Statement object and execute the query;
     -	return inserted entity using findByIdMethod;
     */
    @Override
    public <T> T insert(T entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Connection connection = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entity.getClass());
        ArrayList<ColumnInfo> columns = (ArrayList<ColumnInfo>) EntityUtils.getColumns(entity.getClass());

        Long id = new Long(0);
        for (ColumnInfo column : columns) {
            if (column.isId()) {
                id = getNextIdVal(tableName,column.getDbColumnName());
                column.setValue(id);
            }
            else {
                Field f = entity.getClass().getDeclaredField(column.getColumnName());
                f.setAccessible(true);
                column.setValue(f.get(entity));
            }
        }

        QueryBuilder qb = new QueryBuilder();
        qb.setQueryType(QueryType.INSERT);
        qb.setTableName(tableName);
        qb.addQueryColumns(columns);
        String query = qb.createQuery();

        Statement ps = connection.createStatement();
        System.out.println(query);
        //ResultSet resultSet = ps.executeQuery(query);
        //return null;
        return (T) findById(entity.getClass(), id);
    }

    /**
     * d)	Method <T> List<T> findAll(Class<T> entityClass)

     -	create a connection to DB;
     -	get table name, columns using the methods from EntityUtils class;
     -	create a QueryBuilder object  in which you have to set the name of the table, columns, query type;
     -	call createQuery() method from QueryBuilder.java;
     -	create a resultSet object using Statement and execute the query obtained above;
     -	create an ArrayList of type T;
     -	while the resultSet has any values (resultSet.next()) then:
     o	 you have to create an instance of type T;
     o	iterate through ColumnInfo list and obtain the field of the instance using getColumnName().
     Ex: instance.getClass().getDeclaredField(column.getColumnName());
     o	make the field accessible;
     o	set the value of the field with the value obtained from resultSet object;
     o	add the instance in ArrayList;

     -	return the ArrayList;
     */
    @Override
    public <T> List<T> findAll(Class<T> entityClass) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Connection connection = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entityClass);
        ArrayList<ColumnInfo> columns = (ArrayList<ColumnInfo>) EntityUtils.getColumns(entityClass);

        QueryBuilder qb = new QueryBuilder();
        qb.setTableName(tableName);
        qb.setQueryType(QueryType.SELECT);
        qb.addQueryColumns(columns);
        String query = qb.createQuery();

        Statement ps = connection.createStatement();
        ResultSet resultSet = ps.executeQuery(query);

        ArrayList<T> list = new ArrayList<>();

        while(resultSet.next()) {
            T instance = entityClass.newInstance();
            for (ColumnInfo column : columns ) {
                Field f = instance.getClass().getDeclaredField(column.getColumnName());
                f.setAccessible(true);
                f.set(instance,EntityUtils.castFromSqlType(resultSet.getObject(column.getDbColumnName()),f.getType()));
            }
            list.add(instance);
        }
        connection.close();
        return list;
    }
}
