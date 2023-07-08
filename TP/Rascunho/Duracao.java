import java.time.*;

class Duracao{
	Data dataEntrada, dataSaida;
	Horario horarioEntrada , horarioSaida;
	  
	private Duracao(){}	
	public Duracao(String dataEntrada, String horarioEntrada, String dataSaida, String horarioSaida){
		this.dataEntrada = new Data(computeTime(dataEntrada)[0], computeTime(dataEntrada)[1], computeTime(dataEntrada)[2]);
		this.horarioEntrada = new Horario(computeHour(horarioEntrada)[0], computeHour(horarioEntrada)[1]);
		
		this.dataSaida = new Data(computeTime(dataSaida)[0], computeTime(dataSaida)[1], computeTime(dataSaida)[2]);
		this.horarioSaida = new Horario(computeHour(horarioSaida)[0], computeHour(horarioSaida)[1]);
	}
		
	private int[] computeTime(String date){
		int[] data = new int[3];
		int i=0;
		for(String str : date.split("/"))
			data[i++]=Integer.parseInt(str);
		return data;
	}
	
	private int[] computeHour(String horario){
		int[] horas = new int[2];
		int i=0;
		for(String str : horario.split(":"))
			horas[i++] = Integer.parseInt(str);
		return horas;
	}

	public int calcularTempo(){
		int diaEntrada = dataEntrada.getDia(), mesEntrada = dataEntrada.getMes(), anoEntrada = dataEntrada.getAno(), horaEntrada = horarioEntrada.getHora(), minutoEntrada = horarioEntrada.getMinuto();
		int diaSaida = dataSaida.getDia(), mesSaida = dataSaida.getMes(), anoSaida = dataSaida.getAno(), horaSaida = horarioSaida.getHora(), minutoSaida = horarioSaida.getMinuto();

		LocalDateTime entrada = LocalDateTime.of(anoEntrada, mesEntrada, diaEntrada, horaEntrada, minutoEntrada, 0);
		LocalDateTime saida = LocalDateTime.of(anoSaida, mesSaida, diaSaida, horaSaida, minutoSaida, 0);
		
		Duration duracao = Duration.between(entrada, saida);
		int tempo=(int)(duracao.toHours()*60+duracao.toMinutes()%60);
		return tempo;
	}
}