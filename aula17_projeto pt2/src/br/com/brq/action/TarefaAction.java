package br.com.brq.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.brq.entities.Tarefa;
import br.com.brq.entities.Usuario;
import br.com.brq.entities.types.Status;
import br.com.brq.persistence.DAOTarefa;

public class TarefaAction {

	private Tarefa tarefa; // atributo..
	private List<Tarefa> listagemTarefas; //exibir a consulta..
	private Date dataInicio; //filtro..
	private Date dataFim; //filtro..

	// construtor..
	public TarefaAction() {
		tarefa = new Tarefa(); // instanciando..
	}

	@Action(
			value = "/cadastrartarefa",
			results = {
					@Result(name = "sucesso", location = "/admin/cadastro.jsp")
			}
	)
	public String cadastrar(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		try{
			tarefa.setStatus(Status.EM_ABERTO); //definindo o status..
			
			//resgatar o usuario da sessão...
			Usuario u = (Usuario) session.getAttribute("usuariologado");
			tarefa.setUsuario(u); //relacionando o usuario com a tarefa..
			
			DAOTarefa d = new DAOTarefa(); //persistencia..
			d.saveOrUpdate(tarefa); //gravando..
			
			request.setAttribute("mensagem", "Tarefa " + tarefa.getNome() 
									+ ", cadastrado com sucesso." );
			
			tarefa = new Tarefa(); //novo espaço de memoria..
		}
		catch(Exception e){
			request.setAttribute("mensagem", e.getMessage());
		}
		
		return "sucesso";
	}
	
	
	@Action(
			value = "/consultartarefas",
			results = {
					@Result(name = "sucesso", location = "/admin/consulta.jsp")
			}
	)
	public String consultar(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		try{
			//resgatar o usuario da sessão..
			Usuario u = (Usuario) session.getAttribute("usuariologado");
			
			//executar a busca..
			DAOTarefa d = new DAOTarefa();
			listagemTarefas = d.findByData(dataInicio, dataFim, u.getIdUsuario());		
			
			request.setAttribute("mensagem", "Tarefas encontradas: " + listagemTarefas.size());
		}
		catch(Exception e){
			request.setAttribute("mensagem", e.getMessage());
		}
		
		return "sucesso";
	}
	
	
	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getListagemTarefas() {
		return listagemTarefas;
	}

	public void setListagemTarefas(List<Tarefa> listagemTarefas) {
		this.listagemTarefas = listagemTarefas;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	
}
