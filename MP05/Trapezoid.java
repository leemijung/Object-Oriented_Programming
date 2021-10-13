import java.awt.*;

public class Trapezoid extends Shape{
    public Trapezoid(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        return (Math.abs(points[0].x-points[3].x)+Math.abs(points[1].x-points[2].x))*Math.abs(points[0].y-points[2].y)*0.5;
    }
}
