package org.exemple.dao.util;

import org.exemple.dao.dao.AgendamentoDAO;
import org.exemple.dao.dao.ClienteDAO;
import org.exemple.dao.model.Agendamento;
import org.exemple.dao.model.Cliente;
import org.exemple.dao.model.Servico;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainInterface {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema Valentine Noivas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane abas = new JTabbedPane();

        abas.addTab("Clientes", criarPainelClientes());

        abas.addTab("Agendamentos", criarPainelAgendamentos());

        frame.add(abas);
        frame.setVisible(true);
    }

    private static JPanel criarPainelClientes() {
        JPanel painel = new JPanel(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(6, 2));

        formulario.add(new JLabel("Nome:"));
        JTextField nomeField = new JTextField();
        formulario.add(nomeField);

        formulario.add(new JLabel("CPF:"));
        JTextField cpfField = new JTextField();
        formulario.add(cpfField);

        formulario.add(new JLabel("Telefone:"));
        JTextField telefoneField = new JTextField();
        formulario.add(telefoneField);

        formulario.add(new JLabel("Endereço:"));
        JTextField enderecoField = new JTextField();
        formulario.add(enderecoField);

        formulario.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        formulario.add(emailField);

        JButton btnInserir = new JButton("Cadastrar Cliente");
        btnInserir.addActionListener(e -> {
            try {
                Cliente cliente = new Cliente(
                        nomeField.getText(),  // NOME (novo campo)
                        cpfField.getText(),
                        telefoneField.getText(),
                        enderecoField.getText(),
                        emailField.getText()
                );
                new ClienteDAO().inserir(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        painel.add(formulario, BorderLayout.NORTH);
        painel.add(btnInserir, BorderLayout.SOUTH);

        return painel;
    }

    private static JPanel criarPainelAgendamentos() {
        JPanel painel = new JPanel(new BorderLayout());
        JPanel formulario = new JPanel(new GridLayout(7, 2)); // Agora 7 linhas (adicionamos 1 campo)

        // ID CLIENTE
        formulario.add(new JLabel("ID do Cliente:"));
        JTextField clienteIdField = new JTextField();
        formulario.add(clienteIdField);

        // DATA
        formulario.add(new JLabel("Data (DD/MM/YYYY):"));
        JTextField dataField = new JTextField();
        formulario.add(dataField);

        // HORÁRIO
        formulario.add(new JLabel("Horário (HH:MM):"));
        JTextField horaField = new JTextField();
        formulario.add(horaField);

        // SERVIÇOS
        formulario.add(new JLabel("Tipo de Serviço:"));
        JComboBox<Object> servicoComboBox = new JComboBox<>();
        servicoComboBox.addItem("Selecione um serviço...");  // Primeiro item vazio
        for (Servico servico : Servico.values()) {
            servicoComboBox.addItem(servico);
        }
        formulario.add(servicoComboBox);

        // BOTÃO
        JButton btnAgendar = new JButton("Agendar");
        btnAgendar.addActionListener(e -> {
            try {
                int clienteId = Integer.parseInt(clienteIdField.getText());

                // Conversão da data
                String dataTexto = dataField.getText();
                DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate data = LocalDate.parse(dataTexto, formatterData);

                // Conversão da hora
                String horaTexto = horaField.getText();
                DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime hora = LocalTime.parse(horaTexto, formatterHora);

                Servico servicoSelecionado = (Servico) servicoComboBox.getSelectedItem();
                int idServico = servicoSelecionado.getId();

                Agendamento agendamento = new Agendamento(
                        data,
                        hora,
                        clienteId,
                        idServico
                );

                // Insere no banco
                new AgendamentoDAO().inserir(agendamento);
                JOptionPane.showMessageDialog(null, "Agendamento criado com sucesso!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao agendar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        painel.add(formulario, BorderLayout.NORTH);
        painel.add(btnAgendar, BorderLayout.SOUTH);
        return painel;
    }


}