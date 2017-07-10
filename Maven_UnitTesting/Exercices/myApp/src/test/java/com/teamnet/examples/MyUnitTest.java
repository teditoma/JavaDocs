package com.teamnet.examples;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Theodor.Toma on 7/10/2017.
 */
public class MyUnitTest {
    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();
        String result = myUnit.concat("one","two");
        assertEquals("onetwo",result);
    }

    @Test
    public void testConcatenateNull() {
        MyUnit myUnit = new MyUnit();
        String result = myUnit.concat("one",null);
        assertNotNull(result);
        assertEquals("one",result);
    }

    @Test
    public void testGetBoolean() {
        MyUnit myUnit = new MyUnit();
        assertNotNull(myUnit.getBoolean());
        assertTrue((Boolean)myUnit.getBoolean() instanceof Boolean);

        Assert.assertThat(123, is(123));

    }

}
