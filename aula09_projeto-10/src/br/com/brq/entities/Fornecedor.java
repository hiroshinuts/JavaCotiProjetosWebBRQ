package br.com.brq.entities;

import java.util.Collection;

public class Fornecedor {

	private Integer idFornecedor;
	private String nome;
	private String descricao;

	// Relacionamento (Cada Fornecedor TEM Muitos Produtos)
	private Collection<Produto> produtos;

	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	public Fornecedor(Integer idFornecedor, String nome, String descricao) {
		super();
		this.idFornecedor = idFornecedor;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Fornecedor(Integer idFornecedor, String nome, String descricao, Collection<Produto> produtos) {
		this(idFornecedor, nome, descricao);
		this.produtos = produtos;
	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
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

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Fornecedor [idFornecedor=" + idFornecedor + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

}
