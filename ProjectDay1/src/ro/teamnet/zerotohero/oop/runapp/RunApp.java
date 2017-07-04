package ro.teamnet.zerotohero.oop.runapp;
import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.canvas.*;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class RunApp {
    public static void main(String[] args) {
        Circles circles = new Circles();
        System.out.println("The default area is: " + circles.getAreaPub());
        circles.getAreaDef();

        System.out.println();

        Canvas canvas = new Canvas();

        Shape s = new Circle(10);
        System.out.println(s.area());
        ShapeBehaviour sq = new Square(10);
        System.out.println(sq.area());

        System.out.println();

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

    }
}
