package servlet.Cliente;
import dao.ClienteDAO;
import entidade.Cliente;
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
public class ListaCliente extends HttpServlet {

   @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Cliente> listaClientes = ClienteDAO.getClientes();
        
        request.setAttribute("listaClientes", listaClientes);
        
         RequestDispatcher requestDispatcher = getServletContext()
                 .getRequestDispatcher("/listaCliente.jsp");
         requestDispatcher.forward(request, response);
    }

   
}