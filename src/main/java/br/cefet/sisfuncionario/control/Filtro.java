package br.cefet.sisfuncionario.control;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.sisfuncionario.model.Cliente;

/**
 * Servlet Filter implementation class Filtro
 */
//@WebFilter(filterName="Filtro",urlPatterns=".html")

@WebFilter("/*")
public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) response;

		//Pegar a sseion e o cliente
		HttpSession session = req.getSession();
		Cliente cliente = null;
		cliente = (Cliente) session.getAttribute("cliente");
		String url = req.getRequestURI();
		
		if (url.endsWith("login.jsp") || url.endsWith("ServletCliente")) 
			chain.doFilter(request, response);	
		else
		if (cliente != null)
			chain.doFilter(request, response);	
		else
			resp.sendRedirect("/sisfuncionario/login.jsp");
			
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
