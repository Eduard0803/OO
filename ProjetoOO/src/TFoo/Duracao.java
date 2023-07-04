package TFoo;
import java.time.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Duracao {
	
	

/*	Data dataEntrada, dataSaida;
	Horario horarioEntrada , horarioSaida;*/
	
	private String dataEntrada,
				dataSaida,
				horaEntrada,
				horaSaida;
  
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("AAAA-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	private Duracao() {}
	public Duracao(String dataEntrada, String horarioEntrada, String dataSaida, String horarioSaida) {
	    this.dataEntrada=dataEntrada;
	    this.dataSaida=dataSaida;
	    this.horaEntrada=horarioEntrada;
	    this.horaSaida=horarioSaida;
  }
  
  int[] computeTime(String date){ // metodo para reduzir cada parcela da data a um inteiro
		int[] data = new int[3];
		int i=0;
		for(String str : date.split("/")) 
			data[i++]=Integer.parseInt(str);
			
		
		return data;

	}
  int[] computeHour(String horario){ // transforma a string horario em um vetor de int com as horas e os minutos
      int[] horas = new int[3];
      int i=0;
      for(String buffer : horario.split(":"))
          horas[i++] = Integer.parseInt(buffer);
      return horas;
  }

   /* // Calcula a diferença entre a entrada e a saída
    Duration diferenca = calcularDiferencaTempo(dataEntrada, horarioEntrada, dataSaida, horarioSaida);

    // Exibe a diferença em dias, horas e minutos
    */


	public long calcularDiferencaTempo() {
	    LocalDate entradaData = LocalDate.parse(dataEntrada, dateFormatter);
        LocalTime entradaHora = LocalTime.parse(horaEntrada, timeFormatter);
        LocalDateTime entrada = LocalDateTime.of(entradaData, entradaHora);

        LocalDate saidaData = LocalDate.parse(dataSaida, dateFormatter);
        LocalTime saidaHora = LocalTime.parse(horaSaida, timeFormatter);
        LocalDateTime saida = LocalDateTime.of(saidaData, saidaHora);

        // Calcula a diferença de tempo entre entrada e saída
        Duration duracao = Duration.between(entrada, saida);
        Period periodo = Period.between(entradaData, saidaData);

        // Imprime a diferença de tempo
        long anos = periodo.getYears();
        long meses = periodo.getMonths();
        long dias = periodo.getDays();
        long horas = duracao.toHours();
        if((horas/24) < 1) {
        	dias = 0;
        }
        horas = horas - 24*(horas/24);
        long minutos = duracao.toMinutesPart();
        
        long tempo= (525600*anos)+(43800*meses)+(1440*dias)+(60*horas)+ minutos;
		return tempo;
	}
}
