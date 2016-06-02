package br.com.brq.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.entities.Funcionario;
import br.com.brq.persistence.DAOFuncionario;
import br.com.brq.util.FormatacaoData;

@WebServlet("/ControleFuncionario")
public class ControleFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleFuncionario() {
		super();
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//resgatar a variavel de ação enviada pela página..
		String action = request.getParameter("action");
		
		if("cadastrar".equalsIgnoreCase(action)){
			
			try{
				
				Funcionario f = new Funcionario(); //entidade..
				
				f.setNome(request.getParameter("nome"));
				f.setSalario(Double.parseDouble(request.getParameter("salario")));
				f.setDataAdmissao(FormatacaoData.convertToDate(request.getParameter("dataadmissao")));
				
				DAOFuncionario d = new DAOFuncionario();
				d.insert(f); //gravando..
				
				request.setAttribute("mensagem", "Funcionario " + f.getNome() 
										+ ", cadastrado com sucesso.");
			}
			catch(Exception e){
				//gerar mensagem de erro..
				request.setAttribute("mensagem", e.getMessage());
			}
			finally{
				//redirecionar de volta para a página..
				request.getRequestDispatcher("manterfuncionarios.jsp")
					.forward(request, response);
			}
			
		}
		else if("excluir".equalsIgnoreCase(action)){
			
			try{
				
				//resgatar o id do funcionario..
				Integer idFuncionario = Integer.parseInt(request.getParameter("id"));
				
				//classe de persistencia..
				DAOFuncionario d = new DAOFuncionario();
				//buscar o funcionario pelo id..
				Funcionario f = d.findById(idFuncionario);
				
				//excluir o funcionario..
				d.delete(f);
				
				request.setAttribute("mensagem", "Funcionario " + f.getNome()
										+ ", excluido com sucesso.");
			}
			catch(Exception e){
				//mensagem de erro..
				request.setAttribute("mensagem", e.getMessage());
			}
			finally{
				//redirecionar de volta para a página..
				request.getRequestDispatcher("manterfuncionarios.jsp")
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
