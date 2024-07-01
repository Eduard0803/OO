import javax.swing.*;
import java.awt.*;
import java.io.*;

class Interface{
    private Estacionamento parking;
    // define os objetos da interface gráfica
    private ImageIcon icon = new ImageIcon("images/icon_1.png"); // define qual a imagem será o icone
    private JFrame acessoFrame = new JFrame("SGE - Cadastro de Acessos"), estacFrame = new JFrame("SGE - Cadastro de Estacionamentos");
    private JPanel acessPanel = new JPanel(), estacPanel = new JPanel();
    private JTextField placaField = new JTextField(),
                            HorarioInField = new JTextField(),
                            HorarioOutField = new JTextField(),
                            tipoAcesso = new JTextField(),

                            NameEstacField = new JTextField(),
                            CapacidadeField = new JTextField(),
                            RetornoContratanteField = new JTextField(),
                            ValorFracaoField = new JTextField(),
                            ValorHoraField = new JTextField(),
                            ValorDiurnoField = new JTextField(),
                            ValorNoturnoField = new JTextField(), 
                            ValorMensalistaField = new JTextField(),                           
                            ValorEventoField = new JTextField();
    
    public Interface(){ // metodo construtor padrão
        setAcessoPage();
        setEstacionamentoPage();
    }

    private void exibirValor(float valor){JOptionPane.showMessageDialog(null, "Valor à pagar = R$" + valor);} // exibe o valor do acesso
    public Estacionamento getEstacionamento(){return parking;} // metodo get para o objeto do estacionamento
	private void closeAction(JFrame frame){frame.dispose();} // metodo para fechar a janela
    private void exibirAcessoPage(){ // metodo para exibir a janela de Acessos
        estacFrame.setVisible(false);// esconde a janela de estacionamento
        estacFrame.dispose(); // fecha a janela de eventos
        acessoFrame.setVisible(true); // exibe a janela principal
    }

    private void restart(JFrame frame){
        closeAction(frame); // fecha a pagina de acessos
        clearInputs(estacPanel); // limpa os inputs da janela estacionamento
        exibirEstacionamentoPage(); // exibe a janela estacionamento
        parking.acessos.clear(); // apaga todos os elementos da lista de acesos
    }

    private void setAcessoPage(){ // Define a janela de Acessos
        JButton botao = new JButton("Inserir Acesso"); // define o botão 'Inserir Acesso'
        botao.addActionListener(e -> setAcesso(parking)); // executa o metodo 'setAcesso' quando clicar no botão 'Inserir Acesso'
        JButton close = new JButton("Fechar"); // define o botão para fechar a janela
        close.addActionListener(e -> closeAction(acessoFrame));
        JButton back = new JButton("Voltar");
        back.addActionListener(e -> restart(acessoFrame));
        acessPanel.setLayout(new GridLayout(12, 4)); // define o tamanho do painel

        // cria as caixas de texto para os inputs
        acessPanel.add(new JLabel("Insira os dados"));
        acessPanel.add(new JLabel("Placa do veiculo:"));
        placaField = new JTextField();
        acessPanel.add(placaField);
        
        acessPanel.add(new JLabel("Horário de Entrada:"));
        HorarioInField = new JTextField();
        acessPanel.add(HorarioInField);
        
        acessPanel.add(new JLabel("Horário de Saída:"));
        HorarioOutField = new JTextField();
        acessPanel.add(HorarioOutField);
        
        acessPanel.add(new JLabel("Tipo de Acesso (Mensalista, Evento, Nenhum):"));
        tipoAcesso = new JTextField();
        acessPanel.add(tipoAcesso);

        // adiciona os botões ao painel
        acessPanel.add(botao);
        acessPanel.add(close);
        acessPanel.add(back);

        acessoFrame.setIconImage(icon.getImage()); // define o icone da janela
        acessoFrame.getContentPane().add(acessPanel); // adiciona o JPanel ao JFrame
        acessoFrame.setSize(400, 400); // define o tamanho da janela
        acessoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define o tipo de JFrame
    }

    private Estacionamento setEstacionamento(){ // retorna um objeto do tipo 'Estacionamento' com os dados dos inputs
        String pName = NameEstacField.getText(),
                valorFracao = ValorFracaoField.getText(), 
                valorDiaria = ValorDiurnoField.getText(),
                valorMensalista = ValorMensalistaField.getText(),
                valorEvento = ValorEventoField.getText(),
                valorHora = ValorHoraField.getText(),
                valorNoturno = ValorNoturnoField.getText(),
                capacidade = CapacidadeField.getText(),
                retornoContratante = RetornoContratanteField.getText();
        try{ // tratamento da Exceção do tipo 'DescricaoEmBrancoException'
            if(pName.length() == 0)
                throw new DescricaoEmBrancoException("Nome Estacionamento");
            if(valorFracao.length() == 0)
                throw new DescricaoEmBrancoException("Valor Fração");
            if(valorHora.length() == 0)
                throw new DescricaoEmBrancoException("Valor Hora Cheia");
            if(valorDiaria.length() == 0)
                throw new DescricaoEmBrancoException("Valor Diaria Diurna");
            if(valorNoturno.length() == 0)
                throw new DescricaoEmBrancoException("Valor Diaria Noturna");
            if(valorMensalista.length() == 0)
                throw new DescricaoEmBrancoException("Valor Mensalista");
            if(valorEvento.length() == 0)
                throw new DescricaoEmBrancoException("Valor Evento");
            if(capacidade.length() == 0)
                throw new DescricaoEmBrancoException("Capacidade");
            if(retornoContratante.length() == 0)
                throw new DescricaoEmBrancoException("Retorno Contratante");
        }catch(DescricaoEmBrancoException e){
            closeAction(estacFrame);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        exibirAcessoPage();
        return new Estacionamento(pName,
                            Integer.parseInt(valorFracao), Integer.parseInt(valorHora),
                            Integer.parseInt(valorDiaria), Integer.parseInt(valorNoturno),
                            Integer.parseInt(valorMensalista), Integer.parseInt(valorEvento),
                            Integer.parseInt(capacidade), Integer.parseInt(retornoContratante)
        );
    }

    public void exibirEstacionamentoPage(){ // metodo para exibir a janela de Estacionamentos
        acessoFrame.setVisible(false); // esconde a janela inicial
        acessoFrame.dispose(); // fecha a janela de eventos
        estacFrame.setVisible(true); // exibe a janela de eventos
    }

	private void setEstacionamentoPage(){ // define a janela de cadastro de Estacionamentos
		JButton button = new JButton("Cadastrar Acessos"); // define o botão 'Cadastrar Acessos'
        button.addActionListener(e -> parking = setEstacionamento()); // executa o metodo 'setEstacionamento' quando clicar no botão 'Cadastrar Acessos'
        JButton close = new JButton("Fechar"); // define o botão para fechar a janela
        close.addActionListener(e -> closeAction(estacFrame));
        estacPanel.setLayout(new GridLayout(22, 4)); // define o tamanho do painel

        // define as caixas de input
        estacPanel.add(new JLabel("Insira os dados do Estacionamento"));
        estacPanel.add(new JLabel("Nome do estacionamento:"));
        NameEstacField = new JTextField();
        estacPanel.add(NameEstacField);
        
        estacPanel.add(new JLabel("Valor da fracao em R$:"));
        ValorFracaoField = new JTextField();
        estacPanel.add(ValorFracaoField);
        
        estacPanel.add(new JLabel("Desconto da Hora em %:"));
        ValorHoraField = new JTextField();
        estacPanel.add(ValorHoraField);
        
        estacPanel.add(new JLabel("Valor Acesso diurno em R$:"));
        ValorDiurnoField = new JTextField();
        estacPanel.add(ValorDiurnoField);
        
        estacPanel.add(new JLabel("Desconto Acesso noturno em %:"));
        ValorNoturnoField = new JTextField();
        estacPanel.add(ValorNoturnoField);
        
        estacPanel.add(new JLabel("Valor Acesso Mensalista:"));
        ValorMensalistaField = new JTextField();
        estacPanel.add(ValorMensalistaField);
        
        estacPanel.add(new JLabel("Valor Acesso por Evento:"));
        ValorEventoField = new JTextField();
        estacPanel.add(ValorEventoField);
        
        estacPanel.add(new JLabel("Capacidade do estacionamento:"));
        CapacidadeField = new JTextField();
        estacPanel.add(CapacidadeField);
        
        estacPanel.add(new JLabel("Retorno do contratante em %:"));
        RetornoContratanteField = new JTextField();
        estacPanel.add(RetornoContratanteField);

        // adiciona os botões ao painel
        estacPanel.add(button);
        estacPanel.add(close);
        
        estacFrame.setIconImage(icon.getImage()); // define o icone da janela
        estacFrame.getContentPane().add(estacPanel); // adiciona o JPanel ao JFrame
        estacFrame.setSize(450, 450); // define o tamanho da janela
        estacFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define o tipo de JFrame
	}

    private void clearInputs(JPanel panel){ // metodo para limpar os inputs do JPanel
        for(Component c : panel.getComponents())
            if(c instanceof JTextField){
                JTextField jtf = (JTextField)c;
                jtf.setText("");
            }
    }

    private void setAcesso(Estacionamento parking){ // metodo para definir um novo Acesso ao Estacionamento
        String placa = placaField.getText(),
                horaEntrada = HorarioInField.getText(), 
                horaSaida = HorarioOutField.getText(),
                ta = tipoAcesso.getText();
            ta = ta.toLowerCase(); // transforma toda a string para minusculo
            if(ta.equals("mensalista") || ta.equals("evento") || ta.equals("noturno"))
                horaEntrada = "00:00";
                horaSaida = "00:00";
        try{ // tratamento da exceção do tipo 'DescricaoEmBrancoException'
            if(placa.length() == 0)
                throw new DescricaoEmBrancoException("Placa");
            if(horaEntrada.length() == 0)
                throw new DescricaoEmBrancoException("Horario de Entrada");
            if(horaSaida.length() == 0)
                throw new DescricaoEmBrancoException("Horario de Saida");
            if(ta.length() == 0)
                throw new DescricaoEmBrancoException("Tipo de Acesso");
        }catch(DescricaoEmBrancoException e){
            closeAction(acessoFrame);
            JOptionPane.showMessageDialog(null, e.getMessage());
            exibirAcessoPage();
        }
        try{ // tratamento da exceção do tipo 'ValorAcessoInvalidoException'
            parking.inserirAcesso(new Acesso(placa, new Duracao("01/01/2000", horaEntrada, "01/01/2000", horaSaida), ta));
        }catch(ValorAcessoInvalidoException e){
            closeAction(acessoFrame);
            JOptionPane.showMessageDialog(null, e.getMessage());
            exibirEstacionamentoPage();
        }
        exibirValor(parking.calcValor(placa)); // exibe o valor à ser pago pelo Acesso
        clearInputs(acessPanel); // limpa as caixas de texto da janela de cadastro de acessos
        exibirAcessoPage(); // exibe a janela de cadastro de acessos
    }
}
