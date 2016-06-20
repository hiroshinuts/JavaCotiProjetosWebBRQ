package br.com.brq.managedbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.brq.entities.Funcionario;
import br.com.brq.persistence.DAOFuncionario;

@ManagedBean(name = "mbfunc")
@ViewScoped
public class ManagedBeanFuncionario {

	//atributo para resgatar os campos do formulário..
	private Funcionario funcionario;
	
	//atributo para retornar os funcionarios da base de dados..
	private List<Funcionario> listagemFuncionarios;
	
	//construtor..
	public ManagedBeanFuncionario() {
		funcionario = new Funcionario(); //instanciando..
	}
	
	//método para a ação de cadastro do funcionario..
	public void cadastrar(){
		
		String mensagem = null;
		
		try{
			DAOFuncionario d = new DAOFuncionario();
			d.insert(funcionario); //gravando..
			
			mensagem = "Funcionario " + funcionario.getNome()
							+ ", cadastrado com sucesso." ;
			
			funcionario = new Funcionario(); //novo espaço de memória..
		}
		catch(Exception e){
			mensagem = e.getMessage();
		}
		
		//exibir mensagem dentro do formulário de cadastro...
		FacesContext.getCurrentInstance()
			.addMessage("formulario", new FacesMessage(mensagem));
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getListagemFuncionarios() {
		
		try{
			DAOFuncionario d = new DAOFuncionario(); //persistencia..
			listagemFuncionarios = d.findAll(); //executando a consulta..
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemFuncionarios;
	}
	
}







