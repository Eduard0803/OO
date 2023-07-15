
import java.util.*;

class Estacionamento{
    String nome;
    float valorFracao, valorDia, valorMensal, valorEvento, valorArrecadado=0, valorRetorno=0, valorHora;
    int  valorNoite, capacidade, retorno;
    LinkedList <Acesso> acessos = new LinkedList<>();
    
    private Estacionamento(){} // metodo contrutor padrão
    // metodo construtor alternativo
    public Estacionamento(String nome, float valorFracao, int valorHora, float valorDia, int valorNoite, float valorMensal, float valorEvento, int capacidade, int retorno){
        this.nome = nome;
        this.valorFracao = valorFracao;
        this.valorHora = (4* valorFracao * (100-valorHora)/100);
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
                    return valorDia*(100-valorNoite)/100;
                if(i.tempo > 540)
                    return valorDia;
                if(i.tempo >= 60)
                    return i.tempo % 60 == 0 ? (i.tempo/60)*valorHora : ((i.tempo/60)+1)*valorHora;
                if(i.tempo % 15 == 0)
                    return i.tempo/15 * valorFracao;
                if(((i.tempo/15)+1) == 4)
                    return valorHora;
                return ((i.tempo/15)+1) * valorFracao;
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

    public boolean buscarAcesso(String p){ // busca um acesso na lista
    	boolean ta = false;
        for(Acesso a : acessos)
            if(p.equals(a.placa))   
                ta = true;
        return ta;
    }

    public void mudarAcesso(String p, Acesso newAcesso){ // atualiza um acesso da lista
    	int i= 0;
        for(Acesso a : acessos)
            if(p.equals(a.placa))
                acessos.set(i, newAcesso);
          i++;
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
