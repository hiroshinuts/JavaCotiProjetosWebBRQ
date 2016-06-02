package br.com.brq.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.entities.Editora;
import br.com.brq.persistence.DAOEditora;

@WebServlet("/ControleEditora")
public class ControleEditora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleEditora() {
        super();
    }

    protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("cadastrar".equalsIgnoreCase(action)){
			
			try{				
				Editora e = new Editora();
				e.setNome(request.getParameter("nome"));
				
				DAOEditora d = new DAOEditora();
				d.insert(e); //gravando..
				
				request.setAttribute("mensagem", "Editora " + e.getNome() 
													+ ", cadastrado com sucesso.");
			}
			catch(Exception e){
				request.setAttribute("mensagem", e.getMessage());
			}
			finally{
				request.getRequestDispatcher("cadastroEditora.jsp")
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
