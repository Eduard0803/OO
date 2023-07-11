import javax.swing.*;
import java.awt.*;
import java.io.*;

class main{
    public static ImageIcon icon = new ImageIcon("C:/Users/eduar/OneDrive/Área de Trabalho/OO/TP/interface/images/icon_1.png"); // define qual a imagem será o icone
    public static JFrame initialFrame = new JFrame("SGE"), eventFrame = new JFrame("SGE"); // cria o JFrame e define o titulo como 'SGE'
    public static JPanel panel = new JPanel(), eventPanel = new JPanel();
    public static String parkingData, eventData;
    public static JTextField placaField = new JTextField(),
                            dataInField = new JTextField(),
                            HorarioInField = new JTextField(),
                            dataOutField = new JTextField(),
                            HorarioOutField = new JTextField(),
                            NameField = new JTextField();

    public static void main(String[] args){
        setInitialPage(); // define o JPanel inicial
        setEventPage(); // define o JPanel dos eventos
        
        exibirInitialPage(); // exibe a pagina inicial
    }

    private static void closeAction(JFrame frame, String fileName){
        if(fileName.equals("estacionamentos.txt"))
            parkingData = "placa: " + placaField.getText() + "\nhoraIn: " + HorarioInField.getText() + "\nhoraOut: " + HorarioOutField.getText();
        else
            eventData = "nome: " + NameField.getText() + "\nhoraIn: " + HorarioInField.getText() + "\nhoraOut: " + HorarioOutField.getText();
        frame.dispose();
    }

    // metodos para o painel principal
    private static void exibirInitialPage(){
        eventFrame.setVisible(false); // esconde a janela de eventos
        eventFrame.dispose(); // fecha a janela de eventos
        initialFrame.setVisible(true); // exibe a janela principal
    }

    private static void setInitialPage(){
        JButton botao = new JButton("Novo Evento"); // cria o botão 'Novo Evento'
        botao.addActionListener(e -> exibirEventPage()); // função para disparar a mensagem quando clicar no botão e fechar a janela depois
        JButton close = new JButton("Fechar");
        close.addActionListener(e -> closeAction(initialFrame, "estacionamentos.txt"));

        panel.setLayout(new GridLayout(13, 13)); // define o tamanho do painel

        // cria as caixas de texto para os inputs
        panel.add(new JLabel("Insira os dados"));

        panel.add(new JLabel("Placa do veiculo:")); // exibe o texto ao lado da caixa de 'input'
        placaField = new JTextField();
        panel.add(placaField); // adiciona a caixa de 'input' no painel
        
        panel.add(new JLabel("Horário de Entrada:"));
        HorarioInField = new JTextField();
        panel.add(HorarioInField);
        
        panel.add(new JLabel("Horário de Saída:"));
        HorarioOutField = new JTextField();
        panel.add(HorarioOutField);

        panel.add(botao); // adiciona o botão no JPanel
        panel.add(close); // adiciona o botão close

        initialFrame.setIconImage(icon.getImage()); // define o icone da janela
        initialFrame.getContentPane().add(panel); // adiciona o JPanel ao JFrame
        initialFrame.setSize(400, 300); // define o tamanho da janela
        initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define o tipo de JFrame
    }
    
    // metodos para o painel de eventos
    private static void exibirEventPage(){
        initialFrame.setVisible(false); // esconde a janela principal
        initialFrame.dispose(); // fecha a janela inicial
        eventFrame.setVisible(true); // exibe a janela de eventos
    }

    private static void setEventPage(){
        JButton button = new JButton("Voltar");
        button.addActionListener(e -> exibirInitialPage());
        JButton close = new JButton("Fechar");
        close.addActionListener(e -> closeAction(eventFrame, "eventos.txt"));

        eventPanel.setLayout(new GridLayout(13, 13)); // define o tamanho do painel

        // cria as caixas de texto para os inputs
        eventPanel.add(new JLabel("Insira os dados do evento"));

        eventPanel.add(new JLabel("Nome:")); // exibe o texto ao lado da caixa de 'input'
        NameField = new JTextField();
        eventPanel.add(NameField); // adiciona a caixa de 'input' no painel
        
        eventPanel.add(new JLabel("Data de Inicio:"));
        dataInField = new JTextField();
        eventPanel.add(dataInField);
        
        eventPanel.add(new JLabel("Horário de Inicio:"));
        HorarioInField = new JTextField();
        eventPanel.add(HorarioInField);
        
        eventPanel.add(new JLabel("Data de Termino:"));
        dataOutField = new JTextField();
        eventPanel.add(dataOutField);
        
        eventPanel.add(new JLabel("Horário de Termino:"));
        HorarioOutField = new JTextField();
        eventPanel.add(HorarioOutField);

        eventPanel.add(button);
        eventPanel.add(close);
        
        eventFrame.setIconImage(icon.getImage());
        eventFrame.getContentPane().add(eventPanel);
        eventFrame.setSize(400, 400);
        eventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
