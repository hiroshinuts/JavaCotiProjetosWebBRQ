package br.com.brq.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.brq.entities.types.Status;

@Entity
@Table(name = "tarefa")
@NamedQueries(
		{
			@NamedQuery(name  = Tarefa.FINDBY_DATA, 
						query = "select t from Tarefa as t where t.dataEntrega between :p1 and :p2")
		}
)
public class Tarefa {

	public static final String FINDBY_DATA = "tarefa.findbydata";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtarefa")
	private Integer idTarefa;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataentrega", nullable = false)
	private Date dataEntrega;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 25, nullable = false)
	private Status status;

	@ManyToOne //muitas tarefas para 1 usuario..
	@JoinColumn(name = "idusuario", nullable = false) //chave estrangeira
	private Usuario usuario; // TER-1

	public Tarefa() {
		// TODO Auto-generated constructor stub
	}

	public Tarefa(Integer idTarefa, String nome, String descricao, Date dataEntrega, Status status) {
		super();
		this.idTarefa = idTarefa;
		this.nome = nome;
		this.descricao = descricao;
		this.dataEntrega = dataEntrega;
		this.status = status;
	}

	public Tarefa(Integer idTarefa, String nome, String descricao, Date dataEntrega, Status status, Usuario usuario) {
		this(idTarefa, nome, descricao, dataEntrega, status);		
		this.usuario = usuario;
	}

	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Tarefa [idTarefa=" + idTarefa + ", nome=" + nome + ", descricao=" + descricao + ", dataEntrega="
				+ dataEntrega + ", status=" + status + "]";
	}

}
