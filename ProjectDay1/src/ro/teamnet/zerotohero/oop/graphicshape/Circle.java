package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class Circle extends Shape{
    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 0;
    }

    public Circle(int radius) {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = radius;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = 0;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "center = (" + xPos + "," + yPos + ") and radius = " + radius;
    }

    public void fillColor() {
        System.out.println("parent color is: " + super.color);
    }

    public void fillColor( int color) {
        super.color = color;
        System.out.println("The circle color is now: " + super.color);
    }

    public void fillColor(float saturation) {
        super.saturation = saturation;
    }
}
