package br.com.brq.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.entities.Fornecedor;
import br.com.brq.persistence.DAOFornecedor;

@WebServlet("/ControleFornecedor")
public class ControleFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleFornecedor() {
		super();
	}

	//método para centralizar as requisições recebidas pelos métodos doGet e doPost
	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//resgatar o comando enviado pela página..
		String acao = request.getParameter("acao");
		
		if(acao != null){ //se o valor foi resgatado..
			if(acao.equalsIgnoreCase("cadastrar")){
				
				try{
					
					//resgatando os valores dos campos do formulário..
					Fornecedor f = new Fornecedor(); //entidade..
					f.setNome(request.getParameter("nome")); //valor do campo nome..
					f.setDescricao(request.getParameter("descricao")); //valor do campo descricao..
					
					//gravar na base de dados..
					DAOFornecedor d = new DAOFornecedor(); //peristencia..
					d.insert(f); //gravando o fornecedor..
					
					//enviando mensagem para a página..
					request.setAttribute("mensagem", "Fornecedor " + f.getNome() 
											+ ", cadastrado com sucesso.");
				}
				catch(Exception e){
					//enviando mensagem de erro.
					request.setAttribute("mensagem", "Ocorreu um Erro: " + e.getMessage());
				}
				finally{ //sempre é executado..
					//redirecionar de volta para a página de cadastro do fornecedor...
					request.getRequestDispatcher("cadastroFornecedor.jsp")
						.forward(request, response);
				}
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response); //encaminhando para o execute..
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response); //encaminhando para o execute..
	}

}


