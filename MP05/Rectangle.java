import java.awt.*;

public class Rectangle extends Shape{
    Point[] points;
    public Rectangle(String type, Point[] points) {
        super(type, points);
        this.points=points;
    }

    @Override
    public double calcArea() {
        return Math.abs(points[0].x-points[1].x)*Math.abs(points[0].y-points[1].y);
    }
}
