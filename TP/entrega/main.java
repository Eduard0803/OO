import java.util.*;

class main{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        boolean option = true;
        Estacionamento parking = cadastrarEstacionamento();

        while(true){
            Acesso acesso = cadastrarAcesso();
            parking.inserirAcesso(acesso);
            System.out.println("Valor: " + acesso.valorAcesso);
            System.out.print("digite 0 para encerrar: ");
            if(sc.nextInt() == 0)
                break;
        }
        System.out.println("Total Arrecadado: " + parking.getValorArrecadado());
        System.out.println("Total Apurado pelo contratante: " + parking.getValorRetorno());
    }

    private static Estacionamento cadastrarEstacionamento(){ // metodo para cadastrar estacionamentos
        System.out.println("\n\t\tInsira os dados abaixo\n\n");
        System.out.print("Nome do estacionamento: ");
        String nome = sc.nextLine();

        System.out.print("Valor da Fração: ");
        float v1 = sc.nextFloat();
        
        System.out.print("Desconto por Hora em %: ");
        int v2 = sc.nextInt();

        System.out.print("Valor da Diária Diurna: ");
        float v3 = sc.nextFloat();;

        System.out.print("Desconto por Diária Noturna em %: ");
        int v4 = sc.nextInt();;

        System.out.print("Valor do Acesso Mensalista: ");
        float v5 = sc.nextFloat();;

        System.out.print("Valor do Acesso por Evento: ");
        float v6 = sc.nextFloat();;

        System.out.print("Capacidade: ");
        int cap = sc.nextInt();;
        
        System.out.print("Retorno Contratante em %: ");
        int ret = sc.nextInt();;

        return new Estacionamento(nome, v1, v2, v3, v4, v5, v6, cap, ret);
    }
    private static Duracao horario;
    private static String placa, h1, h2, ta;
    private static Acesso cadastrarAcesso(){ // metodo para cadastrar acessos
        System.out.println("\n\t\tInsira os dados abaixo\n\n");
        
        try{
            System.out.print("Placa do Carro: ");
            placa = sc.nextLine();
            if(placa.length() == 0)
                throw new DescricaoEmBrancoException("Placa do Carro");
        
            System.out.print("Horario de Entrada no formato hh:mm : ");
            h1 = sc.nextLine();
            if(h1.length() == 0)
                throw new DescricaoEmBrancoException("Horario Entrada");
        
            System.out.print("Horario de Saida no formato hh:mm : ");
            h2 = sc.nextLine();
            if(h2.length() == 0)
                throw new DescricaoEmBrancoException("Horario Saida");
        
            System.out.print("Tipo de Acesso (mensalista, evento ou nenhum): ");
            ta = sc.nextLine();
            if(ta.length() == 0)
                throw new DescricaoEmBrancoException("Tipo de Acesso");
        }catch(DescricaoEmBrancoException e){
            System.out.println(e.getMessage());
            cadastrarAcesso();
        }
        try{
            horario = new Duracao("01/01/2000", h1, "01/01/2000", h2);
        }catch(ValorAcessoInvalidoException e){
            System.out.println(e.getMessage());
            cadastrarAcesso();
        }
        return new Acesso(placa, horario, ta);
    }
}
