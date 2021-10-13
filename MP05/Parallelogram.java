import java.awt.*;

public class Parallelogram extends Shape{
    public Parallelogram(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        return Math.abs(points[0].x-points[3].x)*Math.abs(points[0].y-points[1].y);
    }
}
