class Data{
	private int dia, mes, ano;

	private Data(){} // metodo construtor padrão
	public Data(int dia, int mes, int ano){ // metodo construtor alternativo
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int getDia(){return dia;}
	public int getMes(){return mes;}
	public int getAno(){return ano;}
}
