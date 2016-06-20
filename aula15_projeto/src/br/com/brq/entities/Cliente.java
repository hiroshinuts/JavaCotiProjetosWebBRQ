package br.com.brq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.brq.entities.types.Categoria;

@Entity
@Table(name = "cliente")
@NamedQueries(
		{
			@NamedQuery(name = Cliente.FIND_ALL, //nome da consulta..
						query = "select c from Cliente as c") //HQL..
		}
)
public class Cliente extends Pessoa{

	public static final String FIND_ALL = "cliente.findall";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idcliente")
	private Integer idCliente;
	
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "categoria", nullable = false)
	private Categoria categoria;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, String sobrenome, Integer idCliente, String cpf, Categoria categoria) {
		super(nome, sobrenome);
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.categoria = categoria;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", cpf=" + cpf + ", categoria=" + categoria + "]";
	}

}
