package ro.teamnet.zth.api.em;

/**
 * Created by Theodor.Toma on 7/12/2017.
 */

/**
 * -	create in same folder class Condition with following private fields: columnName (type String), value (type Object).
 * Create getters and setters for these fields
 */
public class Condition {
    private String columnName;
    private Object value;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
