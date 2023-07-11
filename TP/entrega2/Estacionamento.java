import java.util.*;

class Estacionamento{
    String nome;
    float valorFracao, valorDia, valorMensal, valorEvento, valorArrecadado=0, valorRetorno=0;
    int valorHora, valorNoite, capacidade, retorno;
    LinkedList <Acesso> acessos = new LinkedList<>();
    
    private Estacionamento(){}
    public Estacionamento(String nome, float valorFracao, int valorHora, float valorDia, int valorNoite, float valorMensal, float valorEvento, int capacidade, int retorno)
    {
        this.nome = nome;
        this.valorFracao = valorFracao;
        this.valorHora = valorHora;
        this.valorDia = valorDia;
        this.valorNoite = valorNoite;
        this.valorMensal = valorMensal;
        this.valorEvento = valorEvento;
        this.capacidade = capacidade;
        this.retorno = retorno;
    }
    
    public float calcValor(String placa)
    {
        for(Acesso i : acessos)
            if(placa.equals(i.placa)){
                if(i.mensalista)
                    return valorMensal;
                if(i.evento)
                    return valorEvento;
                if(i.noturno)
                    return valorNoite;
                if(i.tempo > 540)
                    return valorDia;
                if(i.tempo >= 60)
                    return i.tempo % 60 == 0 ? (i.tempo/60)*valorHora : ((i.tempo/60)+1)*valorHora;
                return i.tempo % 15 == 0 ? (i.tempo/15)*valorFracao : ((i.tempo/15)+1)*valorFracao;
            }
        return 0;
    }

    public void inserirAcesso(Acesso acesso){
        acessos.add(acesso);
        this.valorArrecadado += calcValor(acesso.placa);
        this.valorRetorno += calcValor(acesso.placa)*retorno/100;
        acesso.setValorAcesso(calcValor(acesso.placa));
        acesso.setValorContratante(calcValor(acesso.placa)*retorno/100);
    }

    public Acesso buscarAcesso(String p){
        for(Acesso a : acessos)
            if(p.equals(a.placa))   
                return a;
    }

    public void mudarAcesso(String p, Acesso newAcesso){
        for(Acesso a : acessos)
            if(p.equals(a.placa))
                a = newAcesso;
    }

    public void removerAcesso(String placa){
        for(Acesso i : acessos)
            if(placa.equals(i.placa))
                acessos.remove(i);
    }

    public boolean temVaga(){return acessos.size() < capacidade;}
    public boolean taCheio(){return !temVaga();}

    public float getValorArrecadado(){return valorArrecadado;}
    public float getValorRetorno(){return valorRetorno;}
}
