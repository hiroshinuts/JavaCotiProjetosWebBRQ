package br.com.brq.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries(
		{
			@NamedQuery(name  = Usuario.HAS_LOGIN, 
						query = "select count(u) from Usuario as u where u.login = :p1"),
			
			@NamedQuery(name = Usuario.AUTHENTICATE, 
						query = "select u from Usuario as u where u.login = :p1 and u.senha = :p2")
		}
)
public class Usuario {

	public static final String HAS_LOGIN = "usuario.haslogin";
	public static final String AUTHENTICATE = "usuario.authenticate";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idusuario")
	private Integer idUsuario;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "login", length = 25, nullable = false, unique = true)
	private String login;
	
	@Column(name = "senha", length = 50, nullable = false)
	private String senha;

	@OneToMany(mappedBy = "usuario") //1 usuario tem muitas tarefas..
	private List<Tarefa> tarefas;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer idUsuario, String nome, String login, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(Integer idUsuario, String nome, String login, String senha, List<Tarefa> tarefas) {
		this(idUsuario, nome, login, senha);
		this.tarefas = tarefas;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
	}

}
