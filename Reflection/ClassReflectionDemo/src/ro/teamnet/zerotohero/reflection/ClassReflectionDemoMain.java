package ro.teamnet.zerotohero.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain {

    public enum e {unu, doi, trei};

    static class C {
        public void inheritedMethod(){
            System.out.println("15 Inherited mothod!!");
        }
    };
    static class B extends C{};
    static class A extends B{};

    static class Primitive {
        public int x;
        private String s;
        private char c;

        public Primitive(){};
        private Primitive(int x){
            this.x = x;
        }

        public void publicMethod() {
            System.out.println("14 Public method");
        }
        public void doNothing(){
        }

        public char getC(){
            return c;
        }
    };

    static class Outter{
        static class Inner {};
    };

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //TODO get the class for a String object, and print it
		String s = new String("StringObject");
        System.out.println("1 " + s.getClass());

        //TODO get the class of an Enum, and print it
        System.out.println("2 " + e.doi.getClass());

        //TODO get the class of a collection, and print it
        Collection<Integer> c = new ArrayList<Integer>();
        System.out.println("3 " + c.getClass());

        //TODO get the class of a primitive type, and print it
        System.out.println("4 " + int.class);

        //TODO get and print the class for a field of primitive type
        Primitive p = new Primitive();
        System.out.println("5 " + p.getClass().getDeclaredField("x"));

        //TODO get and print the class for a primitive type, using the wrapper class
        Integer i = 1;
        System.out.println("6 " + Integer.TYPE);

        //TODO get the class for a specified class name
        Class.forName("java.util.ArrayList");

        //TODO get the superclass of a class, and print it
        A a = new A();
        System.out.println("7 " + a.getClass().getSuperclass());

        //TODO get the superclass of the superclass above, and print it
        System.out.println("8 " + a.getClass().getSuperclass().getSuperclass());

        //TODO get and print the declared classes within some other class
        Outter outter = new Outter();
        System.out.println("9 " + outter.getClass().getDeclaredClasses());

        //TODO print the number of constructors of a class
        System.out.println("10 " + (new Primitive()).getClass().getDeclaredConstructors().length);

        //TODO get and invoke a public constructor of a class
        Primitive.class.getConstructor(null).newInstance(null);

        //TODO get and print the class of one private field
        System.out.println("11 " + p.getClass().getDeclaredField("s"));

        //TODO set and print the value of one private field for an object
        Field privateField = p.getClass().getDeclaredField("c");
        privateField.setAccessible(true);
        privateField.set(p,'a');
        System.out.println("12 " + p.getC());

        //TODO get and print only the public fields class
        System.out.println("13" + p.getClass().getFields());

        //TODO get and invoke one public method of a class
        p.getClass().getMethod("publicMethod").invoke(p,null);

        //TODO get and invoke one inherited method of a class
        B b = new B();
        b.getClass().getSuperclass().getMethod("inheritedMethod").invoke(b,null);
		
		//TODO invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())
        long begin = System.currentTimeMillis();
        for ( int j = 0; j < 1000000; j++) {
            p.doNothing();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

        //TODO invoke a method of a class by Reflection for 100 times, and print the timestamp
        begin = System.currentTimeMillis();
        for ( int j = 0; j < 10000; j++) {
            p.getClass().getMethod("doNothing").invoke(p,null);
        }
        end = System.currentTimeMillis();
        System.out.println(end - begin);

        //what do you observe?

		 /*The classic way: 1.000.000 iterations -> 18 ms
         Invoke: 10.000 iterations -> 60 ms
         It is slower with invoke */
    }
}
