import java.util.*;

class Estacionamento{
    String nome;
    float valorFracao, valorDia, valorMensal, valorEvento, valorArrecadado=0, valorRetorno=0;
    int valorHora, valorNoite, capacidade, retorno;
    LinkedList <Acesso> acessos = new LinkedList<>();
    
    private Estacionamento(){} // metodo contrutor padrão
    // metodo construtor alternativo
    public Estacionamento(String nome, float valorFracao, int valorHora, float valorDia, int valorNoite, float valorMensal, float valorEvento, int capacidade, int retorno){
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
    
    public float calcValor(String placa){ // metodo para calcular o valor do acesso
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

    public void inserirAcesso(Acesso acesso){ // insere um novo acesso na lista
        acessos.add(acesso);
        this.valorArrecadado += calcValor(acesso.placa);
        this.valorRetorno += calcValor(acesso.placa)*retorno/100;
        acesso.setValorAcesso(calcValor(acesso.placa));
        acesso.setValorContratante(calcValor(acesso.placa)*retorno/100);
    }

    public Acesso buscarAcesso(String p, Acesso r){ // busca um acesso na lista
        for(Acesso a : acessos)
            if(p.equals(a.placa))   
                r = a;
        return r;
    }

    public void mudarAcesso(String p, Acesso newAcesso){ // atualiza um acesso da lista
        for(Acesso a : acessos)
            if(p.equals(a.placa))
                a = newAcesso;
    }

    public void removerAcesso(String placa){ // remove um acesso da lista
        for(Acesso i : acessos)
            if(placa.equals(i.placa))
                acessos.remove(i);
    }

    public boolean temVaga(){return acessos.size() < capacidade;} // retorna se tem vaga na lista
    public boolean taCheio(){return !temVaga();} // retorna se o estacionamento ta cheio
    public float getValorArrecadado(){return valorArrecadado;} // retorna o valor arrecadado do estacionamento
    public float getValorRetorno(){return valorRetorno;} // retorna o valor de retorno ao contratante
}
