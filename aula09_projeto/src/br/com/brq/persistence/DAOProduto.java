package br.com.brq.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.brq.entities.Fornecedor;
import br.com.brq.entities.Produto;

public class DAOProduto extends DAO{

	//método para inserir um produto na base de dados..
	public void insert(Produto p) throws Exception{
		
		String query = "insert into produto(nome, preco, quantidade, datacadastro, idfornecedor) "
					 + "values(?, ?, ?, now(), ?)";
		
		openConnection();
	
		stmt = con.prepareStatement(query);
		stmt.setString(1, p.getNome());
		stmt.setDouble(2, p.getPreco());
		stmt.setInt(3, p.getQuantidade());
		stmt.setInt(4, p.getFornecedor().getIdFornecedor());
		stmt.execute();
		
		stmt.close();
		closeConnection();
	}
	
	//método para atualizar um produto..
	public void update(Produto p) throws Exception{
		
		String query = "update produto set nome = ?, preco = ?, quantidade = ?, idfornecedor = ? "
					 + "where idproduto = ?";
		
		openConnection();
		
		stmt = con.prepareStatement(query);
		stmt.setString(1, p.getNome());
		stmt.setDouble(2, p.getPreco());
		stmt.setInt(3, p.getQuantidade());
		stmt.setInt(4, p.getFornecedor().getIdFornecedor());
		stmt.setInt(5, p.getIdProduto());
		stmt.execute();
		
		stmt.close();
		closeConnection();
	}
	
	//método para excluir 1 produto da base de dados..
	public void delete(Integer idProduto) throws Exception{
		
		String query = "delete from produto where idproduto = ?";
		
		openConnection();
		
		stmt = con.prepareStatement(query);
		stmt.setInt(1, idProduto);
		stmt.execute();
		
		stmt.close();
		closeConnection();
	}
	
	//método para listar todos os produtos da base de dados..
	public List<Produto> findAll() throws Exception{
		
		String query = "select * from vwprodutofornecedor";
		
		openConnection();		
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		
		List<Produto> lista = new ArrayList<Produto>();
		
		while(rs.next()){ //lendo cada registro obtido da view..
			Produto p = new Produto(); //instanciando..
			p.setFornecedor(new Fornecedor()); //instanciando..
			
			p.setIdProduto(rs.getInt("idproduto"));
			p.setNome(rs.getString("nomeproduto"));
			p.setPreco(rs.getDouble("preco"));
			p.setQuantidade(rs.getInt("quantidade"));
			p.getFornecedor().setIdFornecedor(rs.getInt("idfornecedor"));
			p.getFornecedor().setNome(rs.getString("nomefornecedor"));
			p.getFornecedor().setDescricao(rs.getString("descricao"));
			
			lista.add(p); //adicionar dentro da lista..
		}
		
		stmt.close();
		closeConnection();
		
		return lista;
	}
	
	//método para obter 1 produto pelo id...
	public Produto findById(Integer idProduto) throws Exception{
		
		String query = "select * from vwprodutofornecedor where idproduto = ?";
		
		openConnection();		
		stmt = con.prepareStatement(query);
		stmt.setInt(1, idProduto);
		rs = stmt.executeQuery();
		
		Produto p = null; //valor nulo..		
		if(rs.next()){ //se algum registro foi encontrado..
			p = new Produto(); //instanciando...
			p.setFornecedor(new Fornecedor()); //instanciando..
			
			p.setIdProduto(rs.getInt("idproduto"));
			p.setNome(rs.getString("nomeproduto"));
			p.setPreco(rs.getDouble("preco"));
			p.setQuantidade(rs.getInt("quantidade"));
			p.getFornecedor().setIdFornecedor(rs.getInt("idfornecedor"));
			p.getFornecedor().setNome(rs.getString("nomefornecedor"));
			p.getFornecedor().setDescricao(rs.getString("descricao"));
		}
		
		stmt.close();
		closeConnection();
		
		return p; //retornando o produto..
	}
	
	
}














