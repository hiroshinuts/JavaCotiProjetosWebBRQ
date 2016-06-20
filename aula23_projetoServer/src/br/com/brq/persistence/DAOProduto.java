package br.com.brq.persistence;

import br.com.brq.entities.Produto;

public class DAOProduto extends DAO{

	public void insert(Produto p) throws Exception{
		
		openConnection(); //abrir conexão..
		
		stmt = con.prepareStatement("insert into produto(nome, preco) values(?, ?)");
		stmt.setString(1, p.getNome());
		stmt.setDouble(2, p.getPreco());
		stmt.execute();
		stmt.close();
		
		closeConnection(); //fechar conexão..
	}
	
}
