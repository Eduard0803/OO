package TFoo;

public class Data{

	private int dia;
	private int mes;
	
	private Data() {}
	public Data(int mes, int dia) {
		this.mes=mes;
		this.dia=dia;
	}
	public int getDia() {return dia;}
	public int getMes() {return mes;}

}
