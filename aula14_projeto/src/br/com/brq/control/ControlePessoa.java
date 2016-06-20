package br.com.brq.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.entities.Pessoa;
import br.com.brq.persistence.DAOPessoa;

@WebServlet("/ControlePessoa")
public class ControlePessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControlePessoa() {
		super();
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		
		if("cadastrar".equalsIgnoreCase(action)){
			try{

				Pessoa p = new Pessoa(); //entidade..
				p.setNome(request.getParameter("nome"));
				p.setSobrenome(request.getParameter("sobrenome"));
				p.setEmail(request.getParameter("email"));
				
				DAOPessoa d = new DAOPessoa(); //persistencia..
				if( ! d.hasEmail(p.getEmail())){ //se email nao existe..
					
					d.insert(p); //gravando..
					
					out.println("Pessoa " + p.getNome() + ", cadastrado com sucesso.");
				}
				else{
					throw new Exception("Este email ja encontra-se cadastrado, tente outro.");
				}				
			}
			catch(Exception e){
				out.print(e.getMessage()); //mensagem de erro..
			}			
		}
		else if("pesquisar".equalsIgnoreCase(action)){
			
			try{				
				String nome = request.getParameter("nome");
				
				DAOPessoa d = new DAOPessoa(); //persistencia..
				List<Pessoa> lista = d.findByNome(nome); //executando a busca..
				
				if(lista.size() > 0){ //se alguma pessoa foi encontrada..					
					for(Pessoa p : lista){ //varrendo cada pessoa contida na lista..
						out.println("<tr>");
							out.println("<td>" + p.getIdPessoa() + "</td>");
							out.println("<td>" + p.getNome() + "</td>");
							out.println("<td>" + p.getSobrenome() + "</td>");
							out.println("<td>" + p.getEmail() + "</td>");
						out.println("</tr>");
					}					
				}
				else{
					out.println("Nenhum registro foi encontrado.");
				}
			}
			catch(Exception e){
				out.println(e.getMessage());
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
