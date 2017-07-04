package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class Point {
    private int xPos;
    private int yPos;

    public Point(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public boolean equals( Object other){
        if (other == null)
            return false;
        if (other instanceof Point) {
            Point anotherPoint = (Point)other;
            if (xPos == anotherPoint.xPos && yPos == anotherPoint.yPos)
                return true;
        }
        return false;

    }
}
