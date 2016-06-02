package br.com.brq.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.entities.Cliente;
import br.com.brq.entities.types.EstadoCivil;
import br.com.brq.entities.types.Sexo;
import br.com.brq.persistence.DAOCliente;

@WebServlet("/ControleCliente") //nome que será chamado pelo formulario na JSP..
public class ControleCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//construtor.
	public ControleCliente() {
		super();
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		//resgatar a variavel 'acao' enviada pelos formularios..
		String acao = request.getParameter("acao");
		
		if(acao != null){ //se a variavel obteve valor..
			if(acao.equals("cadastrar")){
				
				try{
					
					//resgatar os campos do formulario de cadastro de clientes..
					Cliente c = new Cliente(); //entidade
					
					c.setNome(request.getParameter("nome"));
					c.setEmail(request.getParameter("email"));
					c.setSexo(Sexo.valueOf(request.getParameter("sexo")));
					c.setEstadoCivil(EstadoCivil.valueOf(request.getParameter("estadocivil")));
					
					DAOCliente d = new DAOCliente(); //persistencia
					d.insert(c); //gravando..
					
					//enviar um valor para a página..
					request.setAttribute("mensagem", "Cliente cadastrado com sucesso.");
				}
				catch(Exception e){
					//imprimir mensagem de erro..
					request.setAttribute("mensagem", "Erro: " + e.getMessage());
				}
				finally{ //finalizador..
					//redirecionar de volta para a página de cadastro..
					request.getRequestDispatcher("cadastro.jsp").forward(request, response);
				}
				
			}
			else if(acao.equals("consultar")){
				
				try{
					
					//resgatando o valor do campo nome do formulario..
					String nome = request.getParameter("nome"); //campo nome..
					
					//Classe de persistencia..
					DAOCliente d = new DAOCliente();
					List<Cliente> lista = d.findAllByNome(nome);
					
					//enviando para a página..
					request.setAttribute("dados", lista); //enviando a lista..
					request.setAttribute("mensagem", "Consulta realizada com sucesso.");					
				}
				catch(Exception e){
					request.setAttribute("mensagem", "Erro: " + e.getMessage());
				}
				finally{
					//redirecionar de volta para a página..
					request.getRequestDispatcher("consulta.jsp").forward(request, response);
				}
			}
		}		
	}	
	
	//receber requições do tipo HTTP GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		//PrintWriter out = response.getWriter(); //impressão..
		//out.print("recebendo chamada GET..");
		execute(request, response);
	}

	//receber requisições do tipo HTTP POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		//PrintWriter out = response.getWriter();
		//out.println("recebendo chamada POST..");	
		execute(request, response);
	}

}
