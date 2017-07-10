package com.teamnet.examples;

/**
 * Created by Theodor.Toma on 7/10/2017.
 */
public class MyUnit {
    public String concat(String s1, String s2) {
        if (s1 == null)
            return s2;
        if (s2 == null)
            return s1;
        return s1 + s2;
    }
    public Boolean getBoolean() {
        return new java.util.Random().nextBoolean();
    }
}
