package servlet.produto;


import dao.ProdutoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrxgo
 */
public class ExcluirProduto extends HttpServlet {

    

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod = Integer.parseInt(request.getParameter("cod"));
        ProdutoDAO.deletaProduto(cod);
        response.getWriter().print(true); 
        
    }


}
