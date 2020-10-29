package servlet.produto;


import com.sun.deploy.uitoolkit.impl.fx.Utils;
import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Rodrxgo
 */
public class AlterarProduto extends HttpServlet {

  
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int cod = request.getIntHeader("cod");
        Produto produto = ProdutoDAO.getProduto(cod);
        request.setAttribute("produto", produto);
         RequestDispatcher rd = 
                 getServletContext().getRequestDispatcher("/alterarCliente.jsp");
         rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int cod = request.getIntHeader("cod");
         String nome = request.getParameter("nome");
         double preço = request.getIntHeader("preço");
         String validade = request.getParameter("validade");

         
         Produto produto = ProdutoDAO.getProduto(cod);
         produto.setNome(nome);
         produto.setCod(cod);
         produto.setPreço(preço);
         produto.setValidade(validade);
         
         try {
             ProdutoDAO.updateProduto(produto);
             response.sendRedirect("sucesso.jsp");
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(AlterarProduto.class.getName()).log(Level.SEVERE, null, ex);

         } 
        
    }
}

