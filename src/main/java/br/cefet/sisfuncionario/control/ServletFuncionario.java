package br.cefet.sisfuncionario.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.sisfuncionario.dao.FuncionarioDao;
import br.cefet.sisfuncionario.dao.SetorDao;
import br.cefet.sisfuncionario.model.Funcionario;
import br.cefet.sisfuncionario.model.Setor;


/**
 * Servlet implementation class ServletProduto
 */
@WebServlet("/ServletFuncionario")
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFuncionario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acao = request.getParameter("acao");
		PrintWriter saida = response.getWriter();
		
		if (acao.equals("add")) {
			// Extrair os valores do request
			String nome = request.getParameter("nome");
			String profissao = request.getParameter("profisao");
			int idSetor = Integer.valueOf(request.getParameter("idSetor"));
		    
			// Instanciar uma Categoria
			SetorDao setDao = new SetorDao();
		    Setor setor = null;
			try {
				setor = setDao.listarUm(idSetor);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			// Instanciar o produto
			Funcionario funcionario = new Funcionario();
			funcionario.setNome(nome);
			funcionario.setProfissao(profissao);
			funcionario.setSetor(setor);
			
			// Salvar o produto
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			try {
				funcionarioDao.adicionar(funcionario);
			} catch (SQLException e) {
				saida.println("Não é possível registrar o funcionário!");
				
			}
			
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
