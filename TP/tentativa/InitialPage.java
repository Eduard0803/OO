import javax.swing.*;

class InitialPage{
    private static JPanel initialP = new JPanel();
    private static JFrame initialF = new JFrame();
        
    public static void main(String[] args){
        JButton cad = new JButton("Cadastrar Estacionamento");
        // addActionListener(e -> exibirEstacionamentoPage());

        initialP.add(cad);
        initialF.getContentPane().add(initialP);
        initialF.setSize(400, 400);
        initialF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exibirInitialPage();
    }

    private static void exibirInitialPage(){
        initialF.setVisible(true);
    }
}
