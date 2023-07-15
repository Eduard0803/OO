class Horario{
    private int hora;
    private int minuto;

    private Horario(){} // metodo construtor padrão
    public Horario(int hora, int minuto){ // metodo construtor alternativo
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getHora(){return hora;}
    public int getMinuto(){return minuto;}
}
