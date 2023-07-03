import java.util.*;

class main{
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){

		System.out.println("\n\t\tInsira os dados abaixo\n\n");
		System.out.print("informe a data de entrada: ");
		String datain = sc.nextLine();

		System.out.print("informe a hora de entrada: ");
		String horain = sc.nextLine();

		System.out.print("informe a data de saida: ");
		String dataout = sc.nextLine();

		System.out.print("informe a hora de saida: ");
		String horaout = sc.nextLine();

		Duracao tempo = new Duracao(datain, horain, dataout, horaout);

		int diferenca = tempo.calcularDiferencaTempo();
	
        System.out.println("Diferença: "+ diferenca + " minutos.");
	}
}
