import java.util.*;

class main{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int option = menu();
        if(option == 1)
            circle();
        else if(option == 2)
            square();
        else if(option == 3)
            rectangle();
        else if(option == 4)
            triangle();
    }
    
    private static int menu(){
        System.out.println("Escolha uma opcao\n\n1 - Circulo\n2 - Quadrado\n3 - Retangulo\n4 - Triangulo\n");
        int option = sc.nextInt();
        return option;
    }

    private static void circle(){
        System.out.println("Informe o raio do circulo: ");
        float radius = sc.nextFloat();
        float p = radius*2*3.1415f;
        float a = (float)(Math.pow(radius, 2)*3.1415f);
        System.out.println("Perimetro = " + p + "\nArea = " + a);
    }

    private static void square(){
        System.out.println("Informe o lado do quadrado: ");
        int side = sc.nextInt();
        System.out.println("Perimetro = " + 4*side);
        System.out.println("Area = " + (int)Math.pow(side, 2));
    }

    private static void rectangle(){
        System.out.println("Informe os lados do retangulo: ");
        int side_1 = sc.nextInt();
        int side_2 = sc.nextInt();
        System.out.println("Perimetro = " + 2*(side_1 + side_2));
        System.out.println("Area = " + side_1*side_2);
    }
    
    private static void triangle(){
        System.out.println("Informe os lados do triangulo: ");
        int[] l = new int[3];
        int p=0;
        for(int i=0; i<3; i++){
            l[i] = sc.nextInt();
            p += l[i];
        }
        Arrays.sort(l);
        System.out.println("Perimetro = " + p);
        if(Math.pow(l[2], 2) == (Math.pow(l[0], 2) + Math.pow(l[1], 2)))
            System.out.println("Area = " + (l[0]*l[1])/2);
    }
}
