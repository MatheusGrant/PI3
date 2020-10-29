package dao;

import entidade.Cliente;
import Conexao.GerenciadorConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.Cliente.ClienteServlet;

public class ClienteDAO {
    
    public static List<Cliente> getClientes() {
        
      List<Cliente> listaClientes = new ArrayList();
      try {
          Connection con = GerenciadorConexao.getConexao();
          String query = "select * from cliente";
          PreparedStatement ps = con.prepareStatement(query);
          ResultSet rs = ps.executeQuery();
          
          while (rs.next()) {
              String nome = rs.getString("nome");                
              String cpf_cliente = rs.getString("cpf_cliente");
              String telefone = rs.getString("telefone");
              String data_nasc = rs.getString("data_nasc");
              String endereco = rs.getString("endereco");
              String sexo = rs.getString("sexo");
              listaClientes.add(new Cliente(nome, cpf_cliente, telefone, data_nasc, endereco, sexo));
          }
      } catch (SQLException ex) {
          Logger.getLogger(ClienteServlet.class.getName()).
                  log(Level.SEVERE, null, ex);
      }
      return listaClientes;
  }
    
     public static void addCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
         
      Connection con = GerenciadorConexao.getConexao();
      
      String query = "insert into cliente(nome, cpf_cliente, telefone, data_nasc, endereco, sexo) values (?,?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, cliente.getNome());       
      ps.setString(2, cliente.getCpf_cliente());
      ps.setString(3, cliente.getTelefone());
      ps.setString(4, cliente.getData_nasc());
      ps.setString(5, cliente.getEndereco());
      ps.setString(6, cliente.getSexo());
      ps.execute();
  }
     
      public static void updateCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
          
      Connection con = GerenciadorConexao.getConexao();
      
      String query = "update cliente set nome=?, telefone=?,  data_nasc=?, endereco=?,  sexo=? where cpf_cliente=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, cliente.getNome());    
      ps.setString(2, cliente.getTelefone());
      ps.setString(3, cliente.getData_nasc());
      ps.setString(4, cliente.getEndereco());
      ps.setString(5, cliente.getSexo());
      ps.setString(6, cliente.getCpf_cliente());
      ps.execute();
  }
      
      public static void deleteCliente(String cpf_cliente) throws ClassNotFoundException, SQLException {
          
      Connection con = GerenciadorConexao.getConexao();
      
      String query = "delete from cliente where cpf_cliente=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, cpf_cliente);
      ps.execute();
  }
      
      public static Cliente getCliente(String cpf_cliente) {
          
      Cliente cliente = null;
      
      try {
          Connection con = GerenciadorConexao.getConexao();
          String query = "select * from cliente where cpf_cliente=?";
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1, cpf_cliente);
          ResultSet rs = ps.executeQuery();
          if (rs.next()) {
              String nome = rs.getString("nome");
              String telefone = rs.getString("telefone");
              String data_nasc = rs.getString("data_nasc");
              String endereco = rs.getString("endereco");
              String sexo = rs.getString("sexo");
              cliente = new Cliente(nome, cpf_cliente, telefone, data_nasc, endereco, sexo);
          }
      } catch (SQLException ex) {
          Logger.getLogger(ClienteServlet.class.getName()).
                  log(Level.SEVERE, null, ex);
      }
      return cliente;
  }

    public static void deletaCliente(int cod_produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}