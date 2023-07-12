import java.time.*;

class Duracao{
	Data dataEntrada, dataSaida;
	Horario horarioEntrada , horarioSaida;
	  
	private Duracao(){} // metodo construtor padrão
	// metodo construtor alternativo
	public Duracao(String dataEntrada, String horarioEntrada, String dataSaida, String horarioSaida) throws ValorAcessoInvalidoException{
		this.dataEntrada = new Data(compute(dataEntrada, "/")[0], compute(dataEntrada, "/")[1], compute(dataEntrada, "/")[2]); // define a data de entrada
		this.horarioEntrada = new Horario(compute(horarioEntrada, ":")[0], compute(horarioEntrada, ":")[1]); // define o horario de entrada
		this.dataSaida = new Data(compute(dataSaida, "/")[0], compute(dataSaida, "/")[1], compute(dataSaida, "/")[2]); // define a data de saida
		this.horarioSaida = new Horario(compute(horarioSaida, ":")[0], compute(horarioSaida, ":")[1]); // defina o horario de saida
	}
	
	private int[] compute(String s, String sep) throws ValorAcessoInvalidoException{ // separa a string em um vetor de int
		int[] v = new int[3];
		int i=0;
		for(String str : s.split(sep)){
			v[i] = Integer.parseInt(str);
			if(v[i++] <= 0)
				if(sep.equals("/"))
					throw new ValorAcessoInvalidoException("Data Incorreta");
				else if(sep.equals(":"))
					throw new ValorAcessoInvalidoException("Hora Incorreta");
				else
					throw new ValorAcessoInvalidoException("Entrada Incorreta");
		}
		return v;
	}

	public int calcularTempo(){ // retorna a diferença de tempo em minutos
		int diaEntrada = dataEntrada.getDia(), mesEntrada = dataEntrada.getMes(), anoEntrada = dataEntrada.getAno(), horaEntrada = horarioEntrada.getHora(), minutoEntrada = horarioEntrada.getMinuto();
		int diaSaida = dataSaida.getDia(), mesSaida = dataSaida.getMes(), anoSaida = dataSaida.getAno(), horaSaida = horarioSaida.getHora(), minutoSaida = horarioSaida.getMinuto();

		LocalDateTime entrada = LocalDateTime.of(anoEntrada, mesEntrada, diaEntrada, horaEntrada, minutoEntrada, 0);
		LocalDateTime saida = LocalDateTime.of(anoSaida, mesSaida, diaSaida, horaSaida, minutoSaida, 0);
		
		Duration duracao = Duration.between(entrada, saida);
		int tempo=(int)(duracao.toHours()*60+duracao.toMinutes()%60);
		return tempo;
	}
}
