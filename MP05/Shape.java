import java.awt.*;
import java.util.ArrayList;

public abstract class Shape {

    protected Point[] points;
    protected String type;
    String shapeList="";

    public Shape(String type, Point[] points){
        this.points=points;
        this.type=type;
    }
    public abstract double calcArea();

    public String toString() {
        //System.out.println(type);
        shapeList+=type+"\n";
        for(int i=0; i<points.length; i++) {
            //System.out.println(points[i].getLocation());
            shapeList+=points[i].getLocation().toString()+"\n";
        }
        //System.out.println("area: "+calcArea());
        shapeList+="area: "+calcArea()+"\n";
        return shapeList;
    }
}
