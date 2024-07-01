import java.util.Scanner;

class Progress{
    static int pa(int a0, int n, int r){
        int termo = a0;
        for(int i=0; i<n; ++i)
            termo += r;
        return termo;
    }
    static void printPA(int a0, int n, int r){
        System.out.print(" " + a0);
        for(int i=0; i<n; ++i){
            a0 += r;
            System.out.print(" " + a0);
        }
    }
    
    static int pg(int a0, int n, int r){
        int termo = a0;
        for(int i=0; i<n; ++i)
            termo *= r;
        return termo;
    }
    static void printPG(int a0, int n, int r){
        System.out.print(" " + a0);
        for(int i=0; i<n; ++i){
            a0 *= r;
            System.out.print(" " + a0);
        }
    }
}

class main{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int first = sc.nextInt(),
        n_termos = sc.nextInt(),
        reason = sc.nextInt();

        System.out.println("\n\t\tArithmect Progression\n");
        Progress.printPA(first, n_termos, reason);
        System.out.println("\n\t\tGeometric Progression\n");
        Progress.printPG(first, n_termos, reason);
    }
}
