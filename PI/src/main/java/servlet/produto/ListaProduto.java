package servlet.produto;


import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrxgo
 */
public class ListaProduto extends HttpServlet {

   @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Produto> listaProdutos = ProdutoDAO.getProdutos();
        
        request.setAttribute("listaProdutos", listaProdutos);
        
         RequestDispatcher requestDispatcher = getServletContext()
                 .getRequestDispatcher("/listaProduto.jsp");
         requestDispatcher.forward(request, response);
    }

   
}