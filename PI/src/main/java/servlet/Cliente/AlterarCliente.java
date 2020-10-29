package servlet.Cliente;

import com.sun.deploy.uitoolkit.impl.fx.Utils;
import dao.ClienteDAO;
import entidade.Cliente;
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
public class AlterarCliente extends HttpServlet {

  
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf_cliente = request.getParameter("cpf_cliente");
        Cliente cliente = ClienteDAO.getCliente(cpf_cliente);
        request.setAttribute("cliente", cliente);
         RequestDispatcher rd = 
                 getServletContext().getRequestDispatcher("/alterarCliente.jsp");
         rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String cpf_cliente = request.getParameter("cpf_cliente");
         String nome = request.getParameter("nome");
         String telefone = request.getParameter("telefone");
         String data_nasc = request.getParameter("data_nasc");
         String endereco = request.getParameter("endereco");
         String sexo = request.getParameter("sexo");
         
         Cliente cliente = ClienteDAO.getCliente(cpf_cliente);
         cliente.setNome(nome);
         cliente.setTelefone(telefone);
         cliente.setData_nasc(data_nasc);
         cliente.setEndereco(endereco);
         cliente.setSexo(sexo);
         
         try {
             ClienteDAO.updateCliente(cliente);
             response.sendRedirect("sucesso.jsp");
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);

         } 
        
    }
}

