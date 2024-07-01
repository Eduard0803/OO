import java.util.Scanner;

class main{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Digite a quantidade de numeros: ");
        int x = sc.nextInt();
        int[] v = new int[x];
        int count_pos=0, count_neg=0, count_zero=0, count_pair=0, count_impar=0;
        for(int i=0; i<x; i++){
            v[i] = sc.nextInt();
            if(v[i] > 0)
                count_pos++;
            if(v[i] < 0)
                count_neg++;
            if(v[i] == 0)
                count_zero++;
            if(v[i] % 2 == 0)
                count_pair++;
            else
                count_impar++;
        }
        System.out.println("positivos = " + count_pos);
        System.out.println("negativos = " + count_neg);
        System.out.println("zeros = " + count_zero);
        System.out.println("pares = " + count_pair);
        System.out.println("impares = " + count_impar);
    }
}
