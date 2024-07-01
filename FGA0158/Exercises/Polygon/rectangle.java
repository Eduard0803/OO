public class rectangle extends Polygon{
    private int base, height;

    private rectangle(){}
    rectangle(int base, int height){
        super();
        this.base = base;
        this.height = height;
    }

    public int getBase(){
        return base;
    }
    public int getHeight(){
        return height;
    }
    public double getArea(){
        return base*height;
    }
    public double getPerimeter(){
        return 2*(base+height);
    }
}
