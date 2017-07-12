package ro.teamnet.zth.api.em;

/**
 * Created by Theodor.Toma on 7/12/2017.
 */

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;


public class EntityUtils {
    private EntityUtils() throws UnsupportedOperationException {}
    public static String getTableName(Class entity){
        if (entity.isAnnotationPresent(Table.class)) {
            Annotation a = entity.getAnnotation(Table.class);
            return ((Table) a).name();
        }
        return entity.getName();
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity){
        ArrayList<ColumnInfo> columns = new ArrayList<>();
        Field[] list = entity.getDeclaredFields();
        for (Field field : list){
            if (field.isAnnotationPresent(Column.class)) {
                    ColumnInfo c = new ColumnInfo();
                    c.setColumnName(field.getName());
                    c.setColumnType(field.getType());
                    c.setDbColumnName(field.getName());
                    columns.add(c);
                }
        }
        return columns;
    }

    /**
     * -	create a public static method castFromSqlType(Object value, Class wantedType), where
     * value is the value from DB and wantedType is the type of value which you want to use.
     * The return type is Object. This method is used to cast the type of “id” column from DB to id field from the entities.
     *
     * Steps:
     •	if value is BigDecimal and wantedType is Integer then you will return an Interger;
     •	if value is BigDecimal and wantedType is Long then you will return an Long;
     •	if value is BigDecimal and wantedType is Float then you will return an Float;
     •	if value is BigDecimal and wantedType is Double then you will return an Double;
     •	if value is different from BigDecimal then the method will return that value;
     */

    public static Object castFromSqlType(Object value, Class wantedType){
        if (value.getClass().equals(BigDecimal.class)) {
            if (wantedType.equals(Integer.class)) return (Integer)value;
            if (wantedType.equals(long.class)) return (Long)value;
            if (wantedType.equals("Float")) return (Float)value;
            if (wantedType.equals("Double")) return (Double)value;
        }
        return value;
    }

    /**
     * -	create a public static method getFieldsByAnnotations(Class clazz, Class annotation),
     * where clazz is for example Department and annotation is @Column. The return type is a list of fields. Steps:
            •	get declared fields for class “clazz”;
•	search fields with the given annotation, and add the field in the list;
•	return list;
    */

    public static ArrayList<Field> getFieldsByAnnotations(Class clazz, Class annotation) {
        ArrayList<Field> list = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields)
            if (f.isAnnotationPresent(annotation))
                list.add(f);
        return list;
    }

    /**-
     * create a public static method getSqlValue(Object object), which will return an Object. Steps:
            •	if object class is annotated with @Table, get the field annotated with @Id, set it
     accessible, and return the object associated with the id field;
•	if object class is not annotated with @Table, return the object
    */

    public static Object getSqlValue(Object object) {
        if (object.getClass().isAnnotationPresent(Table.class)) {
            Field[] fields = object.getClass().getFields();
            for (Field f : fields)
                if (f.isAnnotationPresent(Id.class)) {
                    Field idField = f;
                    idField.setAccessible(true);
                    return idField;
                }
        }
        return object;
    }
}
