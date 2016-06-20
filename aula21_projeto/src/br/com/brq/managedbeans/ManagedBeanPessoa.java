package br.com.brq.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.brq.entities.Pessoa;
import br.com.brq.persistence.DAOPessoa;

@ManagedBean(name = "mbpessoa")
@ViewScoped
public class ManagedBeanPessoa {

	// atributo para resgatar os campos do formulário..
	private Pessoa pessoa;
	
	//atributo para receber a configuração mapeada no spring..
	@ManagedProperty(value = "#{daopessoa}") //nome mapeado no spring..
	private DAOPessoa daoPessoa; //Injeção de dependencia..

	// construtor..
	public ManagedBeanPessoa() {
		pessoa = new Pessoa(); // instanciando..
	}

	//método para cadastrar pessoa..
	public void cadastrar(){
		String mensagem = null;
		
		try{
			daoPessoa.insert(pessoa); //gravando..
			
			mensagem = "Pessoa " + pessoa.getNome() + ", cadastrado com sucesso.";
			pessoa = new Pessoa(); //instanciando..
		}
		catch(Exception e){
			mensagem = e.getMessage();
		}
		
		FacesContext.getCurrentInstance().addMessage("formcadastro", 
								new FacesMessage(mensagem));
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DAOPessoa getDaoPessoa() {
		return daoPessoa;
	}

	public void setDaoPessoa(DAOPessoa daoPessoa) {
		this.daoPessoa = daoPessoa;
	}

}
