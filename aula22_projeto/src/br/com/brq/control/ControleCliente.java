package br.com.brq.control;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import br.com.brq.entities.Cliente;
import br.com.brq.persistence.DAOCliente;

public class ControleCliente extends ActionSupport {

	// atributo para armazenar os dados do cliente do formulário..
	private Cliente cliente;
	//atributo para a classe de persistencia..
	private DAOCliente daoCliente;

	// construtor..
	public ControleCliente() {
		cliente = new Cliente(); // instanciando..
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		daoCliente = (DAOCliente) ctx.getBean("daocliente"); //nome no xml..
	}
	
	//método para a ação de cadastro..
	public String cadastrar(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try{
			
			daoCliente.insert(cliente); //gravando
			
			request.setAttribute("mensagem", "Dados gravados.");
			cliente = new Cliente(); //instanciando..
		}
		catch(Exception e){
			e.printStackTrace();
			request.setAttribute("mensagem", e.getMessage());
		}
		
		return SUCCESS;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
