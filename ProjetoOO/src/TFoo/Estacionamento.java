package TFoo;
import java.util.*;
public class Estacionamento {
	
	private int comecoNoite;
	private int fimNoite ;
	private String NOME;
	private int capacidade;
	private float valorFracao,
					valorHoraCheia,
					valorDiaria,
					valorNoturna,
					acessoMensalista,
					valorEvento,
					valorRetorno;
	private Horario horarioAbertura,
					horarioFechamento;

	
	
	private LinkedList<Acesso> list = new LinkedList<>();
	
	public Estacionamento(String NOME, int capacidade, int comecoNoite, int fimNoite,
							float valorFracao, float valorMensalista, float valorEvento, float valorRetorno, 
							float valorNoturno, float valorDiaria, float valorHoraCheia, String horarioAbertura, String horarioFechamento) {
		this.NOME=NOME;
		this.fimNoite=fimNoite;
		this.capacidade=capacidade;
		this.comecoNoite=comecoNoite;
		this.valorFracao=valorFracao;
		this.valorDiaria=valorDiaria;
		this.valorEvento=valorEvento;
		this.valorNoturna=valorNoturno;
		this.valorRetorno=valorRetorno;
		this.valorHoraCheia=valorHoraCheia;
		this.acessoMensalista=valorMensalista;
		this.horarioAbertura=new Horario(horarioAbertura);
		this.horarioFechamento=new Horario(horarioFechamento);
	}
	
	public boolean isFull() {return capacidade==list.size();}
	public int getValorRetorno() {return 0;}//ajustar o metodo para calcular o valor q será pago a empresa contratante 
	public boolean setAcesso(Acesso novo) {
		if(isFull()) {
			return false;
		}
		list.add(novo);
		return true;
	}

	public boolean temVaga() {return !isFull();}
	
	
}
