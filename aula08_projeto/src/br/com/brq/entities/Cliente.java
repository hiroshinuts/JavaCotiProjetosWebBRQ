package br.com.brq.entities;

import br.com.brq.entities.types.EstadoCivil;
import br.com.brq.entities.types.Sexo;

public class Cliente { //JavaBean

	private Integer idCliente;
	private String nome;
	private String email;
	private Sexo sexo;
	private EstadoCivil estadoCivil;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer idCliente, String nome, String email, Sexo sexo, EstadoCivil estadoCivil) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", sexo=" + sexo
				+ ", estadoCivil=" + estadoCivil + "]";
	}

}
