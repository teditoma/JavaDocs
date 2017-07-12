package ro.teamnet.zth.api.em;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Theodor.Toma on 7/12/2017.
 */
public class QueryBuilder {
    /**
     * -	create a public method getValueForQuery(Object value) which returns a
     * string object. If object type is String then return the value, between ‘’. If the object type is Date, then use:

     DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
     return "TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY'"; If value is
     some other type, return value.toString().
     */

    public String getValueForQuery(Object value){
        if (value.getClass().equals(String.class))
            return "'" + (String)value + "'";
        if (value.getClass().equals(Date.class)) {
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY'";
        }
        return value.toString();
    }

    /**-	create private fields tableName(type Object), queryColumns(type List<ColumnInfo>), queryType(type QueryType),
     * conditions(type List<Condition>);*/

    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public QueryBuilder() {
        queryColumns = new ArrayList<>();
        conditions = new ArrayList<>();
    }
    /**-	create a public method addCondition(Condition condition) which will return a QueryBuilder
     * (the current object), and will add the given conditions to the already existing list of
     * conditions necessary for a query (from the current object); */

    public QueryBuilder addCondition(Condition condition) {
        conditions.add(condition);
        return this;
    }

    /**-	create a public method setTableName(Object tableName) which will return a QueryBuilder (the current object)
     *  and will set the table name necessary for a query;*/

    public QueryBuilder setTableName(Object tableName) {
        this.tableName = tableName;
        return this;
    }

    /**-	create a public method addQueryColumns(List<ColumnInfo> queryColumns) which will return a QueryBuilder and
     * will add the given query columns to the already existing list of query columns (from the current object);*/
    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns) {
        this.queryColumns.addAll(queryColumns);
        return this;
    }

    /**-	create a public method setQueryType(QueryType queryType) which will return a QueryBuilder and will set the
     *  type of the query;*/

    public QueryBuilder setQuerryType(QueryType querryType){
        this.queryType = querryType;
        return this;
    }

    /**-	create 4 private methods: createSelectQuery(), createDeleteQuery(), createUpdateQuery(), createInsertQuery()
     * , that will return a String object representing an SQL query. You will do this using StringBuilder class
     * (ref: https://docs.oracle.com/javase/tutorial/java/data/buffers.html ), and all the properties from the current
     * object (QueryBuilder): the query type, the table name, the query columns and the conditions of the query.
    o	!!! Use the getValueForQuery() method to set the condition values of the query;
    o	!!! Be careful when adding the query columns  (must be separated by , ) and the query conditions (don’t forget the WHERE clause);
*/

    public String createSelectQuerry(){
        StringBuilder querry = new StringBuilder("select ");
        for (ColumnInfo c : queryColumns) {
            querry.append(c.getColumnName());
            querry.append(", ");
        }
        querry.deleteCharAt(querry.length()-2);
        querry.append("from ");
        querry.append(tableName);
        if (conditions.size() != 0) {
            querry.append(" where ");
            for (Condition c : conditions) {
                querry.append(c.getColumnName());
                querry.append(" = ");
                querry.append(getValueForQuery(c.getValue()));
                querry.append(" and ");
            }
            querry.delete(querry.length() - 5, querry.length() - 1);
        }
        querry.append(";");
        return querry.toString();
    }

//    public String createDeleteQuerry(){
//        StringBuilder querry = new StringBuilder("delete ");
//        for (ColumnInfo c : queryColumns) {
//            querry.append(c.getColumnName());
//            querry.append(", ");
//        }
//        querry.deleteCharAt(querry.length()-2);
//        querry.append("from ");
//        querry.append(tableName);
//        querry.append(" where ");
//        for (Condition c : conditions){
//            querry.append(c.getColumnName());
//            querry.append(" = ");
//            querry.append(getValueForQuery(c.getValue()));
//            querry.append(" and ");
//        }
//        querry.delete(querry.length()-5,querry.length()-1);
//        querry.append(";");
//        return querry.toString();
//    }

    /**-	create public method createQuery() which will return a String. In this method you will check the query type
     * (using QueryType enum), and call one of the 4 methods defined above; */

    public String createQuery() {
        if (queryType == QueryType.SELECT)
            return createSelectQuerry();
//        if (queryType == QueryType.SELECT)
//            return createDeleteQuerry();
//        if (queryType == QueryType.SELECT)
//            return createUpdateQuerry();
//        if (queryType == QueryType.SELECT)
//            return createInsertQuerry();
        return null;
    }
}
