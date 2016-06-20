package br.com.brq.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "funcionario")
@NamedQueries(
		{
			@NamedQuery(name  = Funcionario.FIND_ALL, 
						query = "select f from Funcionario as f")
		}
)
public class Funcionario {

	public static final String FIND_ALL = "funcionario.findall";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idfuncionario")
	private Integer idFuncionario;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "salario", nullable = false)
	private Double salario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataadmissao", nullable = false)
	private Date dataAdmissao;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Integer idFuncionario, String nome, Double salario, Date dataAdmissao) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", salario=" + salario
				+ ", dataAdmissao=" + dataAdmissao + "]";
	}

}
