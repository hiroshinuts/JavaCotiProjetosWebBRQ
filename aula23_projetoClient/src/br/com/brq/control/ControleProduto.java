package br.com.brq.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.services.ServiceProdutoProxy;

@WebServlet("/ControleProduto")
public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleProduto() {
		super();
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("cadastrar".equalsIgnoreCase(action)){
			try{
				
				String nome = request.getParameter("nome");
				Double preco = Double.parseDouble(request.getParameter("preco"));
				
				ServiceProdutoProxy service = new ServiceProdutoProxy();
				String mensagem = service.cadastrarProduto(nome, preco);
				
				request.setAttribute("mensagem", mensagem);
			}
			catch(Exception e){
				e.printStackTrace();
				request.setAttribute("mensagem", e.getMessage());
			}
			finally{
				request.getRequestDispatcher("cadastro.jsp")
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
