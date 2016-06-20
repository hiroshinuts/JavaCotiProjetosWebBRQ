package br.com.brq.filters;

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

@WebFilter( 
		{ 
			"/admin/*", 
			"/cadastrartarefa.action", 
			"/consultartarefas.action"
		})
public class FilterAdmin implements Filter {

	public FilterAdmin() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("usuariologado") != null){
			chain.doFilter(request, response); //prossegue...
		}
		else{
			resp.sendRedirect("/aula17_projeto/login.jsp");
		}		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
