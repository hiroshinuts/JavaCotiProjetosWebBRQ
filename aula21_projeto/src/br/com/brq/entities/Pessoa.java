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
			@NamedQuery(name  = Pessoa.FIND_ALL, 
						query = "from Pessoa")
		}
)
public class Pessoa {

	public static final String FIND_ALL = "pessoa.findall";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idpessoa")
	private Integer idPessoa;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;

	public Pessoa() {
	}

	public Pessoa(Integer idPessoa, String nome, String email) {
		this.idPessoa = idPessoa;
		this.nome = nome;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", email=" + email + "]";
	}

}
