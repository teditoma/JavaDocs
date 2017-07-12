package ro.teamnet.zth.api.em;

/**
 * Created by Theodor.Toma on 7/12/2017.
 */

/**
 * -	create in same folder a class ColumnInfo with following private fields: columnName (type String), columnType
 * (type Class), dbColumnName (type String), isId (type boolean), value (type Object). Create getters and setters for these fields.
 */
public class ColumnInfo {
    private String ColumnName;
    private Class columnType;
    private String dbColumnName;
    private boolean isId;
    private Object value;

    public String getColumnName() {
        return ColumnName;
    }

    public void setColumnName(String columnName) {
        ColumnName = columnName;
    }

    public Class getColumnType() {
        return columnType;
    }

    public void setColumnType(Class columnType) {
        this.columnType = columnType;
    }

    public String getDbColumnName() {
        return dbColumnName;
    }

    public void setDbColumnName(String dbColumnName) {
        this.dbColumnName = dbColumnName;
    }

    public boolean isId() {
        return isId;
    }

    public void setId(boolean id) {
        isId = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
