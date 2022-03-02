package br.cefet.sisfuncionario.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.sisfuncionario.dao.SetorDao;
import br.cefet.sisfuncionario.model.Setor;

/**
 * Servlet implementation class ServletCategoria
 */
@WebServlet("/ServletSetor")
public class ServletSetor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSetor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acao = request.getParameter("acao");
		
		if (acao.equals("add")) {
			String descricao = request.getParameter("descricao");
			Setor setor = new Setor();
			setor.setDescricao(descricao);
			
			SetorDao setDao = new SetorDao();
			try {
				setDao.adicionar(setor);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		if (acao.equals("listar")) {
			
			SetorDao setDao = new SetorDao();
			List<Setor> setores = null;
			try {
				setores = setDao.listarTodos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("setores", setores);
		 
			String nextPage = request.getParameter("nextPage");
		    RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		    rd.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
