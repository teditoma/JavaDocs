package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Theodor.Toma on 7/7/2017.
 */
public class Main {
    /*
    Now create another class that suits the main() method where we create 4 MAPS where the KEY will be of type STUDENT and the VALUE will be a BigDecimal
    representing the age (or whatever).
    In the first Map, the key will be an object from point (a), in the second map it will be an object from point (b), in the third map it will be an
    object from point (c) and in the last map it be an object from point (d).
    Think and set the proper properties for the objects in order to observe what can go wrong with our dictionaries.

    Give suggestive names for the classes and print the content of the dictionaries using Iterator!
    Do this exercises inside the exercise3 package.
     */
    public static void main(String[] args) {
        Map<Student,BigDecimal> map1 = new HashMap<Student,BigDecimal>();
        Map<Student,BigDecimal> map2 = new HashMap<Student,BigDecimal>();
        Map<Student,BigDecimal> map3 = new HashMap<Student,BigDecimal>();
        Map<Student,BigDecimal> map4 = new HashMap<Student,BigDecimal>();

        /* a)
        When both methods equals and hashCode are implemented taking into account the same properties,
        the map works correctly.
        */
        Student s1 = new StudentExt1("Alin","Alin");
        Student s2 = new StudentExt1("Alin","George");
        map1.put(s1, BigDecimal.valueOf(12));
        map1.put(s2, BigDecimal.valueOf(133));
        System.out.println(map1.size());

        /* b)
            The objects are all different but all of them are stored in the same bucket because they have the
            same hashCode.
         */
        Student s3 = new StudentExt2("Alin","Alin");
        Student s4 = new StudentExt2("Alin","George");
        Student s31 = new StudentExt2("Alin","Popescu");
        Student s32 = new StudentExt2("Alin","Mihai");
        Student s33 = new StudentExt2("Alin","Catalin");
        Student s34 = new StudentExt2("Alin","Andrei");

        map2.put(s3, BigDecimal.valueOf(12));
        map2.put(s4, BigDecimal.valueOf(133));
        map2.put(s31, BigDecimal.valueOf(133));
        map2.put(s32, BigDecimal.valueOf(133));
        map2.put(s33, BigDecimal.valueOf(133));
        map2.put(s34, BigDecimal.valueOf(133));

        System.out.println(map2.size());

        /* c)
            The 2 objects are equal as stated by the method equals but they are added both in the map.
         */
        Student s5 = new StudentExt3("Alin","Alin");
        Student s6 = new StudentExt3("Alin","George");
        map3.put(s5, BigDecimal.valueOf(12));
        map3.put(s6, BigDecimal.valueOf(133));
        System.out.println(map3.size());

        /* d)
            This is correct.
         */
        Student s7 = new StudentExt4("Alin","Alin");
        Student s8 = new StudentExt4("Alin","George");
        map4.put(s7, BigDecimal.valueOf(12));
        map4.put(s8, BigDecimal.valueOf(133));
        System.out.println(map4.size());
    }
}
