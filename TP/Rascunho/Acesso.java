class Acesso{
    String placa;
    int tempo;
    float valorAcesso, valorContratante;
    Duracao duracao;
    boolean mensalista=false, evento=false, noturno=false;

    private Acesso(){}
    public Acesso(String placa, Duracao duracao, String tp)
    {
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

    protected void setValorAcesso(float valor){this.valorAcesso = valor;}
    protected void setValorContratante(float valor){this.valorContratante = valor;}
}
