import javax.swing.*;

class main{
    public static void main(String[] args){
        Interface ux = new Interface();
        ux.exibirEstacionamentoPage();
        Estacionamento parking = ux.getEstacionamento();
        JOptionPane.showMessageDialog(null, "Valor Arrecadado = R$ " + parking.getValorArrecadado());
    }
}
