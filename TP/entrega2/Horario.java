class Horario{
    private int hora;
    private int minuto;

    private Horario(){}
    public Horario(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getHora(){return hora;}
    public int getMinuto(){return minuto;}
}
