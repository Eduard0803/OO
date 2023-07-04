package TFoo;

public abstract class Acesso {


	public long duracao;
	protected String din,
					hin,
					dout,
					hout,
					placa;
	
	public Acesso() {}
	public Acesso(String din, String hin, String dout, String hout, String placa) {
		this.duracao= new Duracao(din, hin,dout, hout).calcularDiferencaTempo();
		this.din=din;
		this.dout=dout;
		this.hin=hin;
		this.hout=hout;
	}
	
	public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Acesso outroAcesso = (Acesso) obj;
        return placa.equals(outroAcesso.placa);
    }
	
	
	public String getHin() {return hin;}
	public String getHout() {return hout;}
	public String getDin() {return din;}
	public String getDout() {return dout;}
	public String getPlaca() {return placa;}
	public abstract float calcularAcesso();
	public abstract float getValor();
	

	
	
}
