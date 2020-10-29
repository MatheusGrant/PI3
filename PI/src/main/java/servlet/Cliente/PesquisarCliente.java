package servlet.Cliente;
import dao.ClienteDAO;
import entidade.Cliente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rodrxgo
 */
public class PesquisarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf_cliente = request.getParameter("cpf_cliente");
        Cliente cliente = ClienteDAO.getCliente(cpf_cliente);
        request.setAttribute("cliente", cliente);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/venda.jsp");
        rd.forward(request, response);
    }

}
