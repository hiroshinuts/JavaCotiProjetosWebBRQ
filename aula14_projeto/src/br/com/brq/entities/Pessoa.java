package br.com.brq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@NamedQueries(
		{
			@NamedQuery(name  = Pessoa.FINDBY_NOME, 
						query = "select p from Pessoa as p where p.nome like :p1 order by p.nome"),
			
			@NamedQuery(name  = Pessoa.HAS_EMAIL, 
						query = "select count(p) from Pessoa as p where p.email = :p1")
		}
)
public class Pessoa {

	//constantes..
	public static final String FINDBY_NOME = "pessoa.findbynome";
	public static final String HAS_EMAIL = "pessoa.hasemail";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idpessoa")
	private Integer idPessoa;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "sobrenome", length = 50, nullable = false)
	private String sobrenome;
	
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer idPessoa, String nome, String sobrenome, String email) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
				+ "]";
	}

}
