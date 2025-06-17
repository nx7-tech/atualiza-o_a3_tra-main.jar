package org.exemple.dao.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.exemple.dao.util.ConexaoUtil;
import org.exemple.dao.model.Servico;
import org.exemple.dao.model.Cliente;
public class ClienteDAO {
    public void inserir(Cliente valentine_noivas_cliente) throws SQLException {
        String sql = "INSERT INTO valentine_noivas_cliente (nome, cpf_Cliente, telefone, endereco_Cliente, email_Cliente) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, valentine_noivas_cliente.getNome());
            stmt.setString(2, valentine_noivas_cliente.getCpf());
            stmt.setString(3, valentine_noivas_cliente.getTelefone());
            stmt.setString(4, valentine_noivas_cliente.getEndereco());
            stmt.setString(5, valentine_noivas_cliente.getEmail());

            stmt.executeUpdate();

            System.out.println("Cliente inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Não deu tempo e faltou sanidade pra implementar
    /*public List<Cliente> listarTodos() throws SQLException{
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM valentine_noivas_cliente";
        Connection conn = ConexaoUtil.obterConexao();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        try{
            while (rs.next());{
                Cliente c = new Cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("endereco"),
                        rs.getString("email")
                );
                lista.add(c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public static void deletarCliente(int id_Cliente) throws SQLException{
        String sql = "DELETE FROM valentine_noivas_cliente WHERE id_Cliente = ?";
        Connection conn = ConexaoUtil.obterConexao();
        PreparedStatement stmt = conn.prepareStatement(sql);
        try{
            stmt.setInt(1,id_Cliente);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static void atualizarCliente(int id_Cliente,String novoNome, String novoCPF, String novoTelefone,
                                        String novoEndereco,String novoEmail) throws SQLException{
        String sql = "UPDATE valentine_noivas_cliente SET cpf = ? SET telefone SET endereco = ? SET email = ? SET nome = ?" +
                " WHERE id_Agendamento = ? ";
        Connection conn = ConexaoUtil.obterConexao();
        PreparedStatement stmt = conn.prepareStatement(sql);
        try{
            stmt.setString(1,novoNome);
            stmt.setString(2, novoCPF);
            stmt.setString(3,novoEmail);
            stmt.setString(4,novoEndereco);
            stmt.setString(5,novoTelefone);
            stmt.setInt(6,id_Cliente);
            stmt.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }*/

}
