import java.util.Scanner;

class main{
    private static Scanner sc = new Scanner(System.in);
    private static String menu = "\n\t\tMenu de opcoes\n\nEscolha um poligono\n1 - Quadrado\n2 - Retângulo\n3 - Triangulo equilatero\n4 - Circulo\n";

    public static void main(String[] args){
        System.out.println(menu);
        int option = sc.nextInt();
        Polygon poligono = new square(0);
        
        if(option == 1){
            System.out.println("Insira o lado do quadrado: ");
            poligono = new square(sc.nextInt());
        }
        else if(option == 2){
            System.out.println("Insira a base e altura do Retangulo: ");
            poligono = new rectangle(sc.nextInt(), sc.nextInt());
        }
        else if(option == 3){
            System.out.println("Insira o lado do Triangulo: ");
            poligono = new triangle(sc.nextInt());
        }
        else if(option == 4){
            System.out.println("Insira o raio do Circulo: ");
            poligono = new circle(sc.nextInt());
        }
        System.out.println("Area = " + (float)poligono.getArea());
        System.out.println("Perimetro = " + (float)poligono.getPerimeter());
    }
}
