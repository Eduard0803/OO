import java.util.Scanner;

class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int input_1 = sc.nextInt();
        int input_2 = sc.nextInt();

        System.out.println(input_1+input_2);
        System.out.println(input_1-input_2);
        System.out.println(input_1*input_2);
        System.out.println(input_1/input_2);
        System.out.println((int) Math.pow(input_1, input_2));
    }
}
