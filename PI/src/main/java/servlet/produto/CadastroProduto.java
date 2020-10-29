package servlet.produto;



import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Rodrxgo
 * 
 */
public class CadastroProduto extends HttpServlet {

      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");        
        int cod = request.getIntHeader("cod");       
        double preço = request.getIntHeader("preço");
        String validade = request.getParameter("validade");
        Produto produto = new Produto(nome, cod, preço, validade);
        try {
            ProdutoDAO.addProduto(produto);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    

   
}