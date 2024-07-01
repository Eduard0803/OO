public class square extends Polygon{
    private int side;

    private square(){}
    square(int side){
        super();
        this.side = side;
    }

    public int getSide(){ // retorna o lado do quadrado
        return side;
    }
    public double getArea(){ // retorna a area do quadrado
        return side*side;
    }
    public double getPerimeter(){ // retorna o perimetro do quadrado
        return 4*side;
    }
}
