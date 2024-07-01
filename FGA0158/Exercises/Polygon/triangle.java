public class triangle extends Polygon{
    private int side;

    private triangle(){}
    triangle(int side){
        super();
        this.side = side;
    }

    public int getSide(){
        return side;
    }
    public double getArea(){
        double area =  (side*side*Math.sqrt(3))/4;
        return area;
    }
    public double getPerimeter(){
        return 3*side;
    }
}
