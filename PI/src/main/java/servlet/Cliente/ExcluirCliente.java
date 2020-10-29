package servlet.Cliente;

import dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrxgo
 */
public class ExcluirCliente extends HttpServlet {

    

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod_produto = Integer.parseInt(request.getParameter("cod_produto"));
        ClienteDAO.deletaCliente(cod_produto);
        response.getWriter().print(true); 
        
    }


}
