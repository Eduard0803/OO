import java.util.Scanner;

class Aluno{
    String nome, curso;
    int matricula;
    Aluno(String name, int mat, String course){
        nome = name;
        matricula = mat;
        curso = course;
    }

    void printStudent(){
        System.out.println("Name: "+ nome +"\nMatricula: "+ matricula +"\nCurso: "+ curso);
    }
}

class main{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Aluno student_1 = new Aluno("Andre", 13, "Engenharia de Software");
        Aluno student_2 = new Aluno("Miguel", 14, "Direito");
        Aluno student_3 = new Aluno("Maria", 15, "Matematica");

        System.out.println("Aluno 1");
        student_1.printStudent();

        System.out.println("\nAluno 2");
        student_2.printStudent();

        System.out.println("\nAluno 3");
        student_3.printStudent();
    }
}
