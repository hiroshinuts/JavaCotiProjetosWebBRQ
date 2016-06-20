package br.com.brq.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.brq.entities.Usuario;
import br.com.brq.persistence.DAOUsuario;
import br.com.brq.security.Criptografia;

//Classe de controle para Usuario (MVC)
public class UsuarioAction{

	// atributo para armazenar os dados dos campo
	// das páginas de cadastro e login
	private Usuario usuario; //resgatar os dados dos formularios
	
	// construtor...
	public UsuarioAction() {
		usuario = new Usuario(); // espaço de memória..
	}

	//Método para executar o cadastro do usuario..
	@Action(
			value = "cadastrarusuario", //nome da ação (chamado no formulário..)
			results = { //redirecionamentos..
					@Result(name = "sucesso", location = "/cadastro.jsp")
			}
	)
	public String cadastrar(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try{
			DAOUsuario d = new DAOUsuario(); //classe de persistencia..
			if( ! d.hasLogin(usuario.getLogin())) //se o login ja foi cadastrado..
			{
				//criptografar a senha do usuario..
				usuario.setSenha(Criptografia.encriptarSenha(usuario.getSenha()));
				
				d.saveOrUpdate(usuario); //gravando..
				
				request.setAttribute("mensagem", usuario.getNome() + ", cadastrado com sucesso.");
				usuario = new Usuario(); //limoando espao de memoria..
			}
			else
			{
				throw new Exception("Este login ja encontra-se em uso. Tente outro.");
			}			
		}
		catch(Exception e){
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
		}
		
		return "sucesso";
	}
	
	@Action(
			value = "/autenticarusuario",
			results = {
					@Result( name = "sucesso", location = "/admin/index.jsp"),
					@Result( name = "acessonegado", location = "/login.jsp"),
			}
	)
	public String autenticar(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try{
			
			DAOUsuario d = new DAOUsuario(); //pesistencia..
			//buscar 1 usuario pelo login e senha..
			
			Usuario u = d.authenticate(usuario.getLogin(), 
						Criptografia.encriptarSenha(usuario.getSenha()));
			
			if(u != null){ //se usuario foi encontrado..
				//armazenar os dados do usuario em sessão..
				HttpSession session = request.getSession();
				session.setAttribute("usuariologado", u);
				
				return "sucesso";
			}
			else{
				throw new Exception("Acesso Negado. Tente novamente.");
			}
		}
		catch(Exception e){
			request.setAttribute("mensagem", e.getMessage());
		}
		
		return "acessonegado";
	}
	
	
	@Action(
			value = "/logout",
			results = {
					@Result(name = "sucesso", location = "/login.jsp")
			}
	)
	public String logout(){
		
		//destruir os valores contidos na sessão..
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuariologado"); //excluindo..
		session.invalidate(); //limpar toda a sessão..
		
		return "sucesso";
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}







