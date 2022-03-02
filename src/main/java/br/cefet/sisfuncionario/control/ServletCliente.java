package br.cefet.sisfuncionario.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.sisfuncionario.dao.ClienteDao;
import br.cefet.sisfuncionario.model.Cliente;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		if(acao.equals("logar"))
			this.login(request, response);
		
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String erro = "";
		String nextPage = "";
		
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = null;
		try {
			cliente = clienteDao.listarUm(login, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Não encontrou o cliente
		if (cliente==null) {
			erro = "Login n�o identificado!";
			request.setAttribute("erro", erro);
			nextPage = "/login.jsp";
		  
		}else {
	   // Encontrou o cliente - Pegar a session
		HttpSession session = request.getSession();
		session.setAttribute("cliente", cliente);
		nextPage = "/index.jsp";
		}
		
		//Ir para a próxima página
		  RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		  rd.forward(request, response);
		
	}
	
}
