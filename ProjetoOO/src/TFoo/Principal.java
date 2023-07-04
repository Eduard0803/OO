package TFoo;

import javax.swing.*;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		
		final long começoNoite = 20;
        final long fimNoite = 06;

        long minutos = 2881;
        long hin=21;
        long hout=05;
        boolean mensalista = true;

        if(mensalista == true) {
            System.out.println("Acesso Mensalista");
        }else if(hin >= começoNoite && hout < fimNoite && minutos/60.0 <= 24 - começoNoite + fimNoite) {
            System.out.println("Acesso do tipo noturno");
        }else if(minutos/15 < 4) {
            System.out.println("Acesso do tipo Fração:" + minutos+"minutos");
        }else if(minutos/15 < 36) {
            System.out.println("Acesso do tipo Hora cheira:"+ minutos/60+"horas cheias");
        }else {
            if(minutos/1440 < 1) {
                System.out.println("Acesso do tipo Diurno: uma diaria apenas");
            }else if(minutos%1440==0) {
                System.out.println("Acesso do tipo Diurno:"+minutos/1440+"diárias");
            }else {
                System.out.println("Acesso do tipo Diurno: "+((minutos/1440)+1) +"Diárias");
            }

        }

		
		/*Scanner scanner = new Scanner(System.in);

        // Solicita a quantidade de minutos ao usuário
        System.out.print("Digite a quantidade de minutos: ");
        int minutos = scanner.nextInt();

        // Calcula o número de horas cheias e frações de 15 minutos
        int horasCheia = minutos / 60;
        int fracao = (minutos % 60) / 15;
        int diurno = (minutos/60)/9;
        // Imprime o resultado
        /*if (horasCheia > 0) {
            System.out.println("H".repeat(horasCheia)); // Horas cheias
        }*/
		/*
        if (fracao> 0) {
            System.out.println("F".repeat(fracao)); // Frações de 15 minutos
        }
        if(diurno>0) {
        	System.out.println("D".repeat(diurno));
        }else if(horasCheia>0){
        	  System.out.println("H".repeat(horasCheia));
        }
        scanner.close();
		*/
		
		
		
		
		/*String din="2023-12-31";
		String hin="23:50";
		String dout="2024-01-01";
		String hout="00:50";
		
		Duracao carai=new Duracao( din, hin, dout, hout);
		
		long tempo= carai.calcularDiferencaTempo();
		JOptionPane.showMessageDialog(null, tempo);*/
		
		
		
	}

}
