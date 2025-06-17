package org.exemple.dao.dao;

import org.exemple.dao.model.Agendamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.exemple.dao.util.ConexaoUtil;
import org.exemple.dao.model.Servico;
import org.exemple.dao.model.Cliente;

public class AgendamentoDAO {
    public void inserir(Agendamento agendamento) throws SQLException {
        String sql = "INSERT INTO valentine_noivas_agendamento (data, hora, status, key_Cliente, key_Servico) VALUES (?, ?, 'Confirmado', ?, ?)";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Adicione um DEBUG para ver os valores que estão sendo inseridos
            System.out.println("DEBUG - Dados a inserir:");
            System.out.println("Data: " + agendamento.getData());
            System.out.println("Hora: " + agendamento.getHora());
            System.out.println("ID Cliente: " + agendamento.getCliente());
            System.out.println("Serviço: " + agendamento.getServico());

            stmt.setString(1, agendamento.getData().toString());
            stmt.setString(2, agendamento.getHora().toString());
            stmt.setInt(3, agendamento.getCliente());
            stmt.setInt(4, agendamento.getServico());

            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas); // Deve retornar 1

        }
    }
    //Não deu tempo e faltou sanidade pra implementar
    /*public List<Agendamento> listarTodos() throws SQLException{
        List<Agendamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM valentine_noivas_agendamento";
        Connection conn = ConexaoUtil.obterConexao();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        try{
            while (rs.next());{
                Agendamento a = new Agendamento(
                        rs.getString("data"),  // String data
                        rs.getString("hora"),  // String horario
                        new Cliente("", "", "", "",""),  // Cliente (só com ID)
                        Servico.valueOf(rs.getString("Servico")) // Servico
                );
                lista.add(a);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public static void deletarAgendamento(int id_Agendamento) throws SQLException{
        String sql = "DELETE FROM valentine_noivas_agendamento WHERE id_Agendamento = ?";
        Connection conn = ConexaoUtil.obterConexao();
        PreparedStatement stmt = conn.prepareStatement(sql);
        try{
            stmt.setInt(1,id_Agendamento);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static void atualizarAgendamento(int id_Agendamento, String novaData, String novaHora) throws SQLException{
        String sql = "UPDATE valentine_noivas_agendamento SET hora = ? SET data = ? WHERE id_Agendamento = ? ";
        Connection conn = ConexaoUtil.obterConexao();
        PreparedStatement stmt = conn.prepareStatement(sql);
        try{
            stmt.setString(1, novaHora);
            stmt.setString(2,novaData);
            stmt.setInt(3,id_Agendamento);
            stmt.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }*/
}
