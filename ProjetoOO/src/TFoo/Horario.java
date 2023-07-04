package TFoo;

public class Horario {

	private int hora,
				minuto;
	public Horario(String tempo) {
		String[] parte= tempo.split(":");
		this.hora= Integer.parseInt(parte[0]);
		this.minuto=Integer.parseInt(parte[1]);
	}


	   
	public int getHora() {return hora;}
	public int getMinuto() {return minuto;}
}
