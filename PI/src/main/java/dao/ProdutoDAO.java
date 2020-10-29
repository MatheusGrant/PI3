package dao;

import entidade.Cliente;
import Conexao.GerenciadorConexao;
import entidade.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.Cliente.ClienteServlet;
import servlet.produto.ProdutoServlet;

public class ProdutoDAO {
    
    public static List<Produto> getProdutos() {
        
      List<Produto> listaProdutos = new ArrayList();
      try {
          Connection con = GerenciadorConexao.getConexao();
          String query = "select * from produto";
          PreparedStatement ps = con.prepareStatement(query);
          ResultSet rs = ps.executeQuery();
          
          while (rs.next()) {
              String nome = rs.getString("nome");                
              int cod = rs.getInt("cod");
              double preço = rs.getDouble("preço");
              String validade = rs.getString("validade");
              listaProdutos.add(new Produto(nome, cod, preço, validade));
          }
      } catch (SQLException ex) {
          Logger.getLogger(ProdutoServlet.class.getName()).
                  log(Level.SEVERE, null, ex);
      }
      return listaProdutos;
  }
    
     public static void addProduto(Produto produto) throws SQLException, ClassNotFoundException {
         
      Connection con = GerenciadorConexao.getConexao();
      
      String query = "insert into produto(nome, cod, preço, validade) values (?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, produto.getNome());       
      ps.setInt(2, produto.getCod());
      ps.setDouble(3, produto.getPreço());
      ps.setString(4, produto.getValidade());

      ps.execute();
  }
     
      public static void updateProduto(Produto produto) throws ClassNotFoundException, SQLException {
          
      Connection con = GerenciadorConexao.getConexao();
      
      String query = "update produto set nome=?, cod=?,  preço=?, validade=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, produto.getNome());    
      ps.setInt(2, produto.getCod());
      ps.setDouble(3, produto.getPreço());
      ps.setString(4, produto.getValidade());

      ps.execute();
  }
      
      public static void deleteCliente(String cpf_cliente) throws ClassNotFoundException, SQLException {
          
      Connection con = GerenciadorConexao.getConexao();
      
      String query = "delete from cliente where cod=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, cpf_cliente);
      ps.execute();
  }
      
      public static Produto getProduto(int cod) {
          
      Produto produto = null;
      
      try {
          Connection con = GerenciadorConexao.getConexao();
          String query = "select * from produto where cod=?";
          PreparedStatement ps = con.prepareStatement(query);
          ps.setInt(1, cod);
          ResultSet rs = ps.executeQuery();
          if (rs.next()) {
              String nome = rs.getString("nome");
              cod = rs.getInt("cod");
              double preço = rs.getDouble("preço");
              String validade = rs.getString("validade");
              produto = new Produto(nome, cod, preço, validade);
          }
      } catch (SQLException ex) {
          Logger.getLogger(ProdutoServlet.class.getName()).
                  log(Level.SEVERE, null, ex);
      }
      return produto;
  }

    public static void deletaCliente(int cod_produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void deletaProduto(int cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
