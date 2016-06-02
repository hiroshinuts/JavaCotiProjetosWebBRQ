package br.com.brq.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.entities.Autor;
import br.com.brq.persistence.DAOAutor;

@WebServlet("/ControleAutor")
public class ControleAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleAutor() {
		super();
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("cadastrar".equalsIgnoreCase(action)){
			
			try{				
				Autor a = new Autor();
				a.setNome(request.getParameter("nome"));
				
				DAOAutor d = new DAOAutor();
				d.insert(a); //gravando..
				
				request.setAttribute("mensagem", "Autor " + a.getNome() 
													+ ", cadastrado com sucesso.");
			}
			catch(Exception e){
				request.setAttribute("mensagem", e.getMessage());
			}
			finally{
				request.getRequestDispatcher("cadastroAutor.jsp")
					.forward(request, response);
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

}
