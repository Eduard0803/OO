import javax.swing.JOptionPane;

class Hello{
    public static void main(String[] args){
        String name = JOptionPane.showInputDialog(null, "Input your name: ");

        JOptionPane.showMessageDialog(null, "Olá "+ name +", seja bem vindo!");
    }
}