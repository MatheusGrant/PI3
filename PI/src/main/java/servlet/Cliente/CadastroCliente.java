package servlet.Cliente;

import dao.ClienteDAO;
import entidade.Cliente;
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
public class CadastroCliente extends HttpServlet {

      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");        
        String cpf_cliente = request.getParameter("cpf_cliente");       
        String telefone = request.getParameter("telefone");
        String data_nasc = request.getParameter("data_nasc");
        String endereco = request.getParameter("endereco");
        String sexo = request.getParameter("sexo");
        Cliente cliente = new Cliente(nome, cpf_cliente, telefone, data_nasc, endereco, sexo);
        try {
            ClienteDAO.addCliente(cliente);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    

   
}