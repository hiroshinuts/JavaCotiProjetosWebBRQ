package br.com.brq.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.brq.entities.Pessoa;
import br.com.brq.persistence.DAOPessoa;
import net.sf.ehcache.search.Results;

//classe de controle padrão struts..
public class PessoaAction {

	private static final String SUCCESS = "sucesso"; //constante..
	
	private Pessoa pessoa; // receber os dados do formulario de cadastro
	private List<Pessoa> listagemPessoas; //lista exibida na página de consulta..

	// construtor..
	public PessoaAction() {
		pessoa = new Pessoa(); // instanciando..
	}
	
	@Action(
			value = "/cadastrarpessoa",
			results = {
					@Result(name = SUCCESS, location = "/cadastro.jsp")
			}
	)
	public String cadastrar(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try{
			DAOPessoa d = new DAOPessoa(); //persistencia..
			d.insert(pessoa); //gravando..
			
			request.setAttribute("mensagem", "Pessoa " + pessoa.getNome()
									+ ", cadastrado com sucesso.");
			
			pessoa = new Pessoa(); //novo espaço de memória..
		}
		catch(Exception e){
			request.setAttribute("mensagem", e.getMessage());
		}
		
		return SUCCESS;
	}
	
	
	@Action(
			value = "/consultarpessoas",
			results = {
					@Result(name = SUCCESS, location = "/consulta.jsp")
			}
	)
	public String consultar(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try{
			DAOPessoa d = new DAOPessoa(); //persistencia..
			listagemPessoas = d.findAll(); //executando a consulta..
		}
		catch(Exception e){
			request.setAttribute("mensagem", e.getMessage());
		}
		
		return SUCCESS;
	}
	
	
	@Action(
			value = "/excluirpessoa",
			results = {
					@Result(name = SUCCESS, location = "/consulta.jsp")
			}
	)
	public String excluir(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try{
			//resgatando o id enviado pela URL..
			Integer idPessoa = Integer.parseInt(request.getParameter("id"));
			
			DAOPessoa d = new DAOPessoa(); //persistencia..
			d.delete(d.findById(idPessoa)); //buscando e excluindo pessoa..
			
			listagemPessoas = d.findAll(); //nova consulta...
			
			request.setAttribute("mensagem", "Pessoa excluido com sucesso.");
		}
		catch(Exception e){
			request.setAttribute("mensagem", e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@Action(
			value = "/exibirpessoa",
			results = {
					@Result(name = SUCCESS, location = "/edicao.jsp")
			}
	)
	public String exibir(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try{
			//resgatar o id enviado pela página..
			Integer idPessoa = Integer.parseInt(request.getParameter("id"));
			
			DAOPessoa d = new DAOPessoa(); //persistencia..
			pessoa = d.findById(idPessoa); //buscando pessoa pelo id..
		}
		catch(Exception e){
			request.setAttribute("mensagem", e.getMessage());
		}
		
		return SUCCESS;
	}
	
	
	@Action(
			value = "/atualizarpessoa",
			results = {
					@Result(name = SUCCESS, location = "/edicao.jsp")
			}
	)
	public String atualizar(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try{
			DAOPessoa d = new DAOPessoa(); //persistencia..
			d.update(pessoa); //atualizando..
			
			request.setAttribute("mensagem", "Pessoa " + pessoa.getNome()
									+ ", atualizado com sucesso.");
		}
		catch(Exception e){
			request.setAttribute("mensagem", e.getMessage());
		}
		
		return SUCCESS;
	}
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListagemPessoas() {
		return listagemPessoas;
	}

	public void setListagemPessoas(List<Pessoa> listagemPessoas) {
		this.listagemPessoas = listagemPessoas;
	}
}
