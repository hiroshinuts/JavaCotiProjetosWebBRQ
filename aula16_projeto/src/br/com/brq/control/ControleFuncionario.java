package br.com.brq.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.brq.entities.Funcionario;
import br.com.brq.persistence.DAOFuncionario;

//Classe de controle do struts 2..
//Toda Classe de controle do Struts, dever� herdar ActonSupport
//Toda Classe de controle do Struts dever� implementar a interface
//ModelDriven atrav�s do qual ir� definir a sua classe de modelo (dados)
public class ControleFuncionario extends ActionSupport implements ModelDriven<Funcionario>{

	//atributo..
	private Funcionario funcionario; //entidade..
	private List<Funcionario> listagemFuncionarios; //consulta.
	
	//construtor..
	public ControleFuncionario() {
		//espa�o de mem�ria para o atributo funcionario..
		funcionario = new Funcionario(); //instanciando..
	}
	
	//m�todo para receber o submit do formul�rio de cadastro...
	public String cadastrar(){
		
		//criar o request e o response...
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
										.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			DAOFuncionario d = new DAOFuncionario(); //persistencia..
			d.saveOrUpdate(funcionario); //gravando..	
			
			request.setAttribute("mensagem", "Funcionario " + funcionario.getNome()
												+ ", cadastrado com sucesso.");
			
			funcionario = new Funcionario(); //novo espa�o de mem�ria..
		}
		catch(Exception e){
			//mensagem de erro..
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
		}
		
		return SUCCESS;
	}
	
	//m�todo para executar a consulta de funcionarios..
	public String consultar(){
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
										.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			DAOFuncionario d = new DAOFuncionario(); //persistencia..
			listagemFuncionarios = d.findAll(); //executando a consulta..
		}
		catch(Exception e){
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String excluir(){
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{			
			//resgatando o id enviado pela URL..
			Integer idFuncionario = Integer.parseInt(request.getParameter("id"));
			
			//buscar o funcionario pelo id..
			DAOFuncionario d = new DAOFuncionario(); //persistencia..
			Funcionario f = d.findById(idFuncionario); //obtendo..
			
			d.delete(f); //excluindo..
			
			request.setAttribute("mensagem", "Funcionario " + f.getNome()
									+ ", excluido com sucesso.");
			
			listagemFuncionarios = d.findAll();
		}
		catch(Exception e){
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
		}
		
		return SUCCESS;
	}
	
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<Funcionario> getListagemFuncionarios() {
		return listagemFuncionarios;
	}

	@Override
	public Funcionario getModel() {
		//retornar um objeto instanciado da classe de modelo..
		return funcionario; //retornando o atributo..
	}	
	
}
