package br.com.brq.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.brq.entities.Fornecedor;

public class DAOFornecedor extends DAO{

	//método para cadastrar um fornecedor na base de dados..
	public void insert(Fornecedor f) throws Exception{
		
		String query = "insert into fornecedor(nome, descricao) "
					 + "values(?, ?)";
		
		openConnection();
		
		stmt = con.prepareStatement(query);
		stmt.setString(1, f.getNome());
		stmt.setString(2, f.getDescricao());
		stmt.execute();
		stmt.close();
		
		closeConnection();
	}
	
	
	//método para listar os fornecedores da base de dados..
	public List<Fornecedor> findAll() throws Exception{
		
		String query = "select * from fornecedor";
		
		openConnection();		
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		while(rs.next()){ //enquanto houver registros..
			Fornecedor f = new Fornecedor();
			f.setIdFornecedor(rs.getInt("idfornecedor"));
			f.setNome(rs.getString("nome"));
			f.setDescricao(rs.getString("descricao"));
			
			lista.add(f); //adicionar na lista..
		}
		
		stmt.close();
		closeConnection();
		
		return lista;
	}
	
	
}





