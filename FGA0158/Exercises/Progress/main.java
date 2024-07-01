import java.util.Scanner;

public class main{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Progress p1 = new ArithmeticProgress(1, 5, 2);
        Progress p2 = new GeometryProgress(1, 5, 2);
        System.out.println("\n\t\tArithmetic Progression\n");
        p1.printProgress();
        System.out.println("Soma dos Elementos = " + p1.somaElementos());

        System.out.println("\n\t\tGeometry Progression\n");
        p2.printProgress();
        System.out.println("Soma dos Elementos = " + p2.somaElementos());
    }
}
