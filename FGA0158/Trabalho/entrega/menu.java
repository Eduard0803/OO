
import java.util.LinkedList;
import java. util. Scanner;
import javax.swing.*;
public class menu {

	public static void main(String[] args) throws ValorAcessoInvalidoException {
		int p = 1;
		Scanner scan = new Scanner(System.in);
		int indicador;
		 LinkedList <Estacionamento> ListaEstacionametos = new LinkedList<>();
		do {
			System.out.println(""
					+ "1 - Cadastrar Estacionamento\n"
					+ "2 - Cadastrar novo Acesso\n"
					+ "3 - Pesquisar Acesso no estacionamento\n"
					+ "4 - Excluir acesso no estacionameto\n"
					+ "5 - Modificar acesso no estacionameto\n"
					+ "6 - Consultar estacionameto\n"
					+ "7 - Encerrar");
			indicador  = scan.nextInt();
			switch(indicador){
			case 1:
				
				System.out.println("Digite o nome do estacionamento\n");
				String nome = scan.next();
				System.out.println("Digite a capacidade do estacionamento\n");
				int capacidade = scan.nextInt();
				System.out.println("Digite o valor da Fracao\n");
				float valorFracao = scan.nextFloat();
				System.out.println("Digite o valordo desconto da Hora\n");
				int valorHora = scan.nextInt();
				System.out.println("Digite o valor do  Diurno\n");
				float valorDia = scan.nextFloat();
				System.out.println("Digite o valor do desconto no Noturno\n");
				int valorNoite = scan.nextInt();
				System.out.println("Digite o valor do Mensal\n");
				float valorMensal = scan.nextFloat();
				System.out.println("Digite o valor do  Evento\n");
				float valorEvento = scan.nextFloat();
				System.out.println("Digite o retorno do estacionamento em %\n");
				int retorno = scan.nextInt();

				try{ // tratamento da Exceção
					if(nome.length() <= 0)
		                throw new ValorAcessoInvalidoException("Nome Estacionamento");
		            if(capacidade <= 0)
		                throw new ValorAcessoInvalidoException("Capacidade");
		            if(valorFracao <= 0)
		                throw new ValorAcessoInvalidoException("Valor Fração");
		            if(valorHora < 0)
		                throw new ValorAcessoInvalidoException("Valor Hora Cheia");
		            if(valorDia <= 0)
		                throw new ValorAcessoInvalidoException("Valor Diaria Diurna");
		            if(valorNoite < 0)
		                throw new ValorAcessoInvalidoException("Valor Diaria Noturna");
		            if(valorMensal <= 0)
		                throw new ValorAcessoInvalidoException("Valor Mensalista");
		            if(valorEvento <= 0)
		                throw new ValorAcessoInvalidoException("Valor Evento");
		            if(retorno <= 0)
		                throw new ValorAcessoInvalidoException("Retorno Contratante");
		        }catch(ValorAcessoInvalidoException e){
		            JOptionPane.showMessageDialog(null, e.getMessage());
		        }
				Estacionamento est = new Estacionamento(nome, valorFracao, valorHora, valorDia, valorNoite, valorMensal, valorEvento, capacidade, retorno);
				ListaEstacionametos.add(est);
				break;
			
			case 2:
				
				System.out.println("Digite a placa do carro\n");
				String placa = scan.next();
				System.out.println("Digite o tipo de acesso (Mensalista/Evento/Nenhum)\n");
				String Tipoacesso = scan.next();
				System.out.println("Digite a data de entrada (MM/DD/AAAA)\n");
				String dataEntrada = scan.next();
				System.out.println("Digite a data de Saída (MM/DD/AAAA)\n");
				String dataSaida = scan.next();
				System.out.println("Digite a hora de entrada (HH:MM)\n");
				String horarioEntrada = scan.next();
				System.out.println("Digite a hora de saída (HH:MM)\n");
				String horarioSaida = scan.next();
				Duracao dura = new Duracao(dataEntrada, horarioEntrada, dataSaida, horarioSaida);
				Acesso acesso = new Acesso(placa, dura, Tipoacesso);
				for(Estacionamento c : ListaEstacionametos) 
					System.out.println(c.nome);
				System.out.println("Em qual estacionameto quer colocar o carro\n");
				String nameEstacio = scan.next();
				for(Estacionamento d : ListaEstacionametos)
					if(nameEstacio.toLowerCase().equals(d.nome.toLowerCase())) {
						d.inserirAcesso(acesso);
						System.out.println("O total a pagar é: "+ acesso.getValorAcesso());
						System.out.println("O contratantte recebera: "+acesso.getValorContratante());
					}

				break;
			case 3:
				
				System.out.println("Digite a placa que deseja pesquisar\n");
				String plaq = scan.next();
				System.out.println("Lista de estacionametos: \n");
				for(Estacionamento a : ListaEstacionametos) 
					System.out.println(a.nome);
				System.out.println("Digite o nome do estacionameto no qual deseja pesquisar\n");
				String nomeEstacio = scan.next();
				for(Estacionamento b : ListaEstacionametos)
					if(nomeEstacio.toLowerCase().equals(b.nome.toLowerCase())) {
						boolean yep;
						yep = b.buscarAcesso(plaq);
						if(yep == true) {
							System.out.println("O carro esta estacionado aqui\n");
						}else {
							System.out.println("O carro não está aqui\n");
						}
					}
				break;
			case 4:
				
				System.out.println("Digite a placa que deseja excluir\n");
				String plaqu = scan.next();
				System.out.println("Lista de estacionametos: \n");
				for(Estacionamento o : ListaEstacionametos) 
					System.out.println(o.nome);
				System.out.println("Digite o nome do estacionameto no qual deseja excluir\n");
				String nomeEstacion = scan.next();
				for(Estacionamento l : ListaEstacionametos)
					if(nomeEstacion.toLowerCase().equals(l.nome.toLowerCase())) {
						l.removerAcesso(plaqu);
			
						}
				break;
					
			case 5:
				
				System.out.println("Digite a placa que deseja modificar\n");
				String plaquia = scan.next();
				System.out.println("Lista de estacionametos: \n");
				for(Estacionamento o : ListaEstacionametos) 
					System.out.println(o.nome);
				System.out.println("Digite o nome do estacionameto no qual deseja pesquisar\n");
				String nomeEstaciona = scan.next();
				for(Estacionamento l : ListaEstacionametos)
					if(nomeEstaciona.toLowerCase().equals(l.nome.toLowerCase())) {
						System.out.println("Digite a plca do carro\n");
						String plac = scan.next();
						System.out.println("Digite o tipo de acesso (Mensalista/Evento/Nenhum)\n");
						String Tipoacess = scan.next();
						System.out.println("Digite a data de entrada (MM/DD/AAAA)\n");
						String dataEntrad = scan.next();
						System.out.println("Digite a data de Saída (MM/DD/AAAA)\n");
						String dataSaid = scan.next();
						System.out.println("Digite a hora de entrada (HH:MM)\n");
						String horarioEntrad = scan.next();
						System.out.println("Digite a hora de saída (HH:MM)\n");
						String horarioSaid = scan.next();
						Duracao dur = new Duracao(dataEntrad, horarioEntrad, dataSaid, horarioSaid);
						Acesso acess = new Acesso(plac, dur, Tipoacess);
						System.out.println("O total a pagar é: "+ acess.getValorAcesso());
						System.out.println("O contratantte recebera: "+acess.getValorContratante());
						l.mudarAcesso(plaquia, acess);
						}
				break;
			case 6:
				System.out.println("Lista de estacionametos: \n");
				for(Estacionamento o : ListaEstacionametos) 
					System.out.println(o.nome);
				System.out.println("Digite o nome do estacionameto no qual deseja pesquisar\n");
				String nomeEstacionam = scan.next();
				for(Estacionamento u : ListaEstacionametos)
					if(nomeEstacionam.toLowerCase().equals(u.nome.toLowerCase())) {
						System.out.println("O valor arrecadado pelo estacionameto é: "+ u.getValorArrecadado());
						System.out.println("O valor de retorno do estacionameto é: "+ u.getValorRetorno());
					}
				break;
			case 7:
				
				p=12000;
				break;
			}	
		}while(p == 1);
		}
	}