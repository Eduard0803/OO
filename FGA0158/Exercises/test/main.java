import javax.swing.*;
import java.awt.*;
import java.io.*;

class main{
    public static void main(String[] args) {
        // Criar um painel personalizado com dois campos de entrada
        JPanel panel = new JPanel(); // instancia um painel
        panel.setLayout(new GridLayout(8, 2)); // define o tamanho do painel

        JTextField bufferField = new JTextField();

        panel.add(new JLabel("Name:")); // criar o campo 'name'
        JTextField nomeField = new JTextField(); // define que o campo recebera um input
        panel.add(nomeField); // adiciona o campo 'name' ao painel

        panel.add(new JLabel("Age:")); // cria o campo 'age'
        JTextField ageField = new JTextField(); // define que o campo recebera um input
        panel.add(ageField); // adiciona o campo 'age' ao painel

        panel.add(new JLabel("e-mail:")); // cria o campo 'e-mail'
        JTextField emailField = new JTextField(); // define que o campo recebera um input
        panel.add(emailField); // adiciona o campo 'e-mail ao painel'

        // Exibir o painel personalizado em uma janela usando o JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Input yours data", JOptionPane.OK_CANCEL_OPTION); // define o titulo da janela como 'Input yours data'
        if(result == JOptionPane.OK_OPTION){
            Person person = new Person( // cria um objeto do tipo 'Person'
                                        nomeField.getText(), // recebe a String do campo 'name'
                                        Integer.parseInt(ageField.getText()), // recebe a int do campo 'age'
                                        emailField.getText() // recebe a String do campo 'email'
            );
            
            String out = "Your name: " + person.getName(); // define a String que será exibida na janela de saida
            out += "\nAge:  " + person.getAge();
            out += " years old\ne-mail: " + person.getEmail();
            JOptionPane.showMessageDialog(null, out); // exibe os dados coletados

            try{ // tenta escrever os dados no arquivo
                File arq = new File("data_user.txt"); // cria um objeto do tipo 'File' para o arquivo 'data_user.txt'
                BufferedWriter bw = new BufferedWriter(new FileWriter(arq, true)); // cria um objeto para a escrita no arquivo 'data_user.txt'
                bw.write(out + "\n"); // escreve os dado no arquivo 
                bw.close(); // fecha o arquivo
            }catch(IOException e){ // em caso de erro lança a exceção
                JOptionPane.showMessageDialog(null, "error");
            }
        }
    }
}
