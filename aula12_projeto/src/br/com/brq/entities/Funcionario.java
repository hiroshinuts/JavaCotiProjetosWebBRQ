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

//ORM - Mapeamento Objeto Relacional
//JPA - Java Persistence API (Biblioteca para mapeamento)

@Entity //classe é uma entidade mapeada pela JPA
@Table(name = "funcionario") //nome da tabela..
@NamedQueries( //mapear as consultas HQL da entidade..
		{
			//toda consulta HQL sempre faz select na Classe e não na tabela
			@NamedQuery(name = "funcionario.findall", //nome da consulta.. 
				query = "select f from Funcionario as f"), //consulta HQL
			
			@NamedQuery(name = "funcionario.findbydata", 
				query = "select f from Funcionario as f where f.dataAdmissao between :p1 and :p2")
		}
)
public class Funcionario {

	@Id //chave primária..
	@GeneratedValue(strategy=GenerationType.AUTO) //auto_incremento..
	@Column(name = "idfuncionario")
	private Integer idFuncionario;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "salario", nullable = false)
	private Double salario;
	
	@Temporal(TemporalType.DATE) //somente data..
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
