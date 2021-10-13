import java.awt.*;

public class RightTriangle extends Shape{
    public RightTriangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        return Math.abs(points[1].x-points[2].x)*Math.abs(points[0].y-points[1].y)*0.5;
    }
}
