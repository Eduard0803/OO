import java.util.*;

class main{
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
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

    private static Estacionamento cadastrarEstacionamento()
    {
        // System.out.println("\n\t\tInsira os dados abaixo\n\n");
        // System.out.print("Nome do estacionamento: ");
        String nome = "Estac. 1";

        // System.out.print("Valor da Fração: ");
        float v1 = 30f;
        
        // System.out.print("Desconto por Hora: ");
        int v2 = 45;

        // System.out.print("Valor da Diária Diurna: ");
        float v3 = 120f;

        // System.out.print("Desconto por Diária Noturna: ");
        int v4 = 45;

        // System.out.print("Valor do Acesso Mensalista: ");
        float v5 = 600f;

        // System.out.print("Valor do Acesso por Evento: ");
        float v6 = 50f;

        // System.out.print("Capacidade: ");
        int cap = 300;
        
        // System.out.print("Retorno Contratante: ");
        int ret = 50;

        return new Estacionamento(nome, v1, v2, v3, v4, v5, v6, cap, ret);
    }

    private static Acesso cadastrarAcesso()
    {
        System.out.println("\n\t\tInsira os dados abaixo\n\n");
        
        System.out.print("Placa do Carro: ");
        String placa = sc.nextLine();

        // System.out.print("Data de Entrada no formato dd/mm/yyyy: ");
        // String d1 = sc.nextLine();

        System.out.print("Horario de Entrada no formato hh:mm : ");
        String h1 = sc.nextLine();
        
        // System.out.print("Data de Saida no formato dd/mm/yyyy: ");
        // String d2 = sc.nextLine();
        
        System.out.print("Horario de Saida no formato hh:mm : ");
        String h2 = sc.nextLine();
        
        System.out.print("Tipo de Acesso (mensalista, evento, noturno ou nenhum): ");
        String ta = sc.nextLine();

        Duracao horario = new Duracao("01/01/2000", h1, "01/01/2000", h2);
        return new Acesso(placa, horario, ta);
    }
}
