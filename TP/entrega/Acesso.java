class Acesso{
    String placa;
    int tempo;
    float valorAcesso, valorContratante;
    Duracao duracao;
    boolean mensalista=false, evento=false, noturno=false;

    private Acesso(){} // metodo construtor padrão
    public Acesso(String placa, Duracao duracao, String tp){ // metodo construtor alternativo
        this.placa = placa;
        this.duracao = duracao;
        this.tempo = duracao.calcularTempo();
        
        tp = tp.toLowerCase();
        if(tp.equals("mensalista"))
            this.mensalista = true;
        else if(tp.equals("evento"))
            this.evento = true;
        else if(tp.equals("noturno"))
            this.noturno = true;
    }

    protected void setValorAcesso(float valor){this.valorAcesso = valor;} // define o valor do acesso
    protected void setValorContratante(float valor){this.valorContratante = valor;} // define o valor do contratante
}
