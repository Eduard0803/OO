public class circle extends Polygon{
    private int radius;

    private circle(){}
    circle(int radius){
        super();
        this.radius = radius;
    }

    public int getRadius(){
        return radius;
    }
    public double getArea(){
        return 3.1415*radius*radius;
    }
    public double getPerimeter(){
        return 3.1415*2*radius;
    }
}
