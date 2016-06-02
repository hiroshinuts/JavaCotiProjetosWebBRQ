package br.com.brq.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.brq.entities.Cliente;
import br.com.brq.entities.types.EstadoCivil;
import br.com.brq.entities.types.Sexo;

public class DAOCliente extends DAO{

	//método para inserir um cliente na tabela..
	public void insert(Cliente c) throws Exception{
		
		String query = "insert into cliente(nome, email, sexo, estadocivil) "
					 + "values(?, ?, ?, ?)";
		
		openConnection();
		
		stmt = con.prepareStatement(query);
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.setString(3, c.getSexo().name());
		stmt.setString(4, c.getEstadoCivil().name());
		stmt.execute();
		stmt.close();
		
		closeConnection();
	}
	
	//metodo para atualizar um cliente na tabela..
	public void update(Cliente c) throws Exception{
		
		String query = "update cliente set nome=?, email=?, sexo=?, estadocivil=? "
					 + "where idcliente = ?";
		
		openConnection();
		
		stmt = con.prepareStatement(query);
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.setString(3, c.getSexo().name());
		stmt.setString(4, c.getEstadoCivil().name());
		stmt.setInt(5, c.getIdCliente());
		stmt.execute();
		stmt.close();
		
		closeConnection();
	}
	
	
	//método para excluir 1 cliente na tabela..
	public void delete(Integer idCliente) throws Exception{
		
		String query = "delete from cliente where idcliente = ?";
		
		openConnection();
		
		stmt = con.prepareStatement(query);
		stmt.setInt(1, idCliente);
		stmt.execute();
		stmt.close();
		
		closeConnection();
	}
	
	//método para obter 1 cliente pelo id..
	public Cliente findById(Integer idCliente) throws Exception{
		
		String query = "select * from cliente where idcliente = ?";
		
		openConnection();
		
		stmt = con.prepareStatement(query);
		stmt.setInt(1, idCliente);
		rs = stmt.executeQuery();
		
		Cliente c = null; //sem espaço de memória..
		
		if(rs.next()){ //se algum registro foi encontrado.. 
			c = new Cliente(); //espaço de memória..
			
			c.setIdCliente(rs.getInt("idcliente"));
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			c.setSexo(Sexo.valueOf(rs.getString("sexo")));
			c.setEstadoCivil(EstadoCivil.valueOf(rs.getString("estadocivil")));
		}
		
		stmt.close();
		closeConnection();
		
		return c; //retornar o cliente...
	}
	
	//metodo para listar todos os clientes da tabela..
	public List<Cliente> findAll() throws Exception{
		
		String query = "select * from cliente";
		
		openConnection();
		
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		
		List<Cliente> lista = new ArrayList<Cliente>(); //lista vazia..
		
		while(rs.next()){ //enquanto houver registros..
			Cliente c = new Cliente(); //criando objeto..
			c.setIdCliente(rs.getInt("idcliente"));
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			c.setSexo(Sexo.valueOf(rs.getString("sexo")));
			c.setEstadoCivil(EstadoCivil.valueOf(rs.getString("estadocivil")));
			
			lista.add(c); //adicionar dentro da lista..
		}
		
		stmt.close();
		closeConnection();
		
		return lista; //retornando a lista..
	}
	
	//método para listar os clientes pelo nome..
	public List<Cliente> findAllByNome(String nome) throws Exception{
		
		String query = "select * from cliente where nome like ?";
		
		openConnection();
		
		stmt = con.prepareStatement(query);
		stmt.setString(1, "%" + nome + "%"); //contendo..
		rs = stmt.executeQuery(); //executa e le os dados da consulta..
		
		List<Cliente> lista = new ArrayList<Cliente>(); //lista vazia..
		
		while(rs.next()){ //enquanto houver registros..
			Cliente c = new Cliente(); //criando objeto..
			c.setIdCliente(rs.getInt("idcliente"));
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			c.setSexo(Sexo.valueOf(rs.getString("sexo")));
			c.setEstadoCivil(EstadoCivil.valueOf(rs.getString("estadocivil")));
			
			lista.add(c); //adicionar dentro da lista..
		}
		
		stmt.close();
		closeConnection();
		
		return lista; //retornando a lista..
	}
	
	
}










