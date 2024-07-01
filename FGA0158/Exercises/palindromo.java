import java.util.Scanner;
import java.util.Arrays;

class string{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Input the String: ");
        String input = sc.nextLine();
        System.out.println(palindromo(input));
    }
    private static boolean palindromo(String str){ // metodo para verificar uma string é um palindromo 
        String reverse = "";

        for(int i=str.length()-1; i>=0; i--) // inverte a string `str` e armazena na string `reverse`
            reverse += str.charAt(i);

        if(str.equals(reverse)) // se a string `str` for igual a string `reverse` retorna `true`, senão retorna `false`
            return true;
        else
            return false;
    }
}