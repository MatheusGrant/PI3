package servlet.produto;

import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rodrxgo
 */
public class PesquisarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod = request.getIntHeader("cod");
        Produto produtos = ProdutoDAO.getProduto(cod);
        request.setAttribute("produtos", produtos);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/produto.jsp");
        rd.forward(request, response);
    }

}
