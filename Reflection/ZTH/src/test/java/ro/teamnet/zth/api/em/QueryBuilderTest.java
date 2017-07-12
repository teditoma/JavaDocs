package ro.teamnet.zth.api.em;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Theodor.Toma on 7/12/2017.
 */
public class QueryBuilderTest {
    @Test
    public void testSelectQuery1(){
        QueryBuilder qb = new QueryBuilder();
        qb.setQuerryType(QueryType.SELECT);
        qb.setTableName("employees");
        Condition c = new Condition();
        c.setColumnName("first_name");
        c.setValue("Theodor");
        qb.addCondition(c);
        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setColumnName("first_name");
        ArrayList<ColumnInfo> list = new ArrayList<>();
        list.add(columnInfo);
        qb.addQueryColumns(list);
        String res = qb.createQuery();
        String expected = "select first_name from employees where first_name = 'Theodor' ;";
        assertEquals("",expected.replaceAll(" \n\t",""), res.replaceAll(" \n\t",""));
    }

    @Test
    public void testSelectQuery2(){
        QueryBuilder qb = new QueryBuilder();
        qb.setQuerryType(QueryType.SELECT);
        qb.setTableName("employees");

        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setColumnName("first_name");
        ArrayList<ColumnInfo> list = new ArrayList<>();
        list.add(columnInfo);
        qb.addQueryColumns(list);
        String res = qb.createQuery();
        String expected = "select first_name from employees;";
        System.out.println(res);
        assertEquals("",expected.replaceAll(" \n\t",""), res.replaceAll(" \n\t",""));
    }
}
