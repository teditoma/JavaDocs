package ro.teamnet.zerotohero.oop.exception;

import java.io.IOException;
import java.io.*;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class Main {
    public static void exceptionMethod() throws MyException {
        throw new MyException("ERR");
    }

    public static void m1() {
        int x = 10/0;
    }
    public  static  void m2(){
        m1();
    }

    public static int ex8(int x) {
        // Ex 8:
        try{
            if ( x == 0)
                return 1;
            return 0;
        }
        finally {
            System.out.println("I finished Ex 8");
        }
    }

    public static void main(String [] args) {
       int [] array = new int[10];

       // Ex 2:
        // throw new MyException();

        // Ex 3:
        try {
           m2();
        }
        catch (Exception e){
            System.err.println("Exception handled in main");
        }

        // Ex 4:
//        try{
//            array[10]++;
//        }
//        catch(IndexOutOfBoundsException e){
//            throw new MyException("Index out of bounds exception",e);
//        }

        // Ex 5:
       try{
            array[10]++;
       }
       catch (IndexOutOfBoundsException e){
               System.err.println("Caught IndexOutOfBounds exception");
       }

        // Ex 6:

        try {
            //BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\theodor.toma\\IdeaProjects\\ProjectDay1\\src\\ro\\teamnet\\zerotohero\\oop\\exception\\file.txt"));
            BufferedReader br = new BufferedReader(new FileReader("file2.txt"));

            StringBuilder sb = new StringBuilder();
            System.out.println("AAAAA");
            String line = br.readLine();
        }
        catch (IOException e) {
            System.err.println("Error at opening file");
        }

        // Ex 7:
        try{
           array[10]++;
        }
        catch(Exception e){
            System.err.println("Caught IndexOutOfBounds exception");
            //return;
        }
        finally {
            System.out.println("Executed finally");
        }

       ex8(10);

        // Ex 9:
        try{
            array[10] = 10/0;
        }
        catch(IndexOutOfBoundsException e1) {
            System.err.println("Caught IndexOutOfBounds exception");
        }
        catch (ArithmeticException e2) {
            System.err.println("Caught Division by zero exception");
        }

        // Ex 10:
        try{
            array[10] = 10/0;
        }
        catch(IndexOutOfBoundsException | ArithmeticException e1) {
            System.err.println("Caught exception at attribution");
        }
    }
}
