package br.com.brq.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.brq.entities.Cliente;

public class DAOCliente {

	//ferramenta para desenvolvimento JDBC com Spring...
	private JdbcTemplate jdbcTemplate;
	
	//INJEÇÂO DE DEPENDENCIA..
	//Método set para que o atributo jdbcTemplate receba a configuração
	//definida no arquivo applicationContext.xml
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	//método para gravar um cliente na base de dados..
	public void insert(Cliente c) throws Exception{
		
		String query = "insert into cliente(nome, email) values(?, ?)";		
		jdbcTemplate.update(query, 
				new Object[]{ c.getNome(), c.getEmail() } );		
	}

	//método para atualizar um cliente na base de dados..
	public void update(Cliente c) throws Exception{
		
		String query = "update cliente set nome = ?, email = ? where idcliente = ?";		
		jdbcTemplate.update(query, 
				new Object[]{ c.getNome(), c.getEmail(), c.getIdCliente() });
	}
	
	//método para excluir 1 cliente..
	public void delete(Integer idCliente) throws Exception{
		
		String query = "delete from cliente where idcliente = ?";		
		jdbcTemplate.update(query, new Object[]{ idCliente });
	}
	
	//método para listar todos os clientes..
	public List<Cliente> findAll() throws Exception{
		
		String query = "select * from cliente order by nome";
		
		@SuppressWarnings("unchecked")
		List<Cliente> lista = jdbcTemplate.query(query, new ClienteMapper());
		return lista;		
	}
	
	//método para buscar 1 cliente pelo id..
	public Cliente findById(Integer idCliente) throws Exception{
		
		String query = "select * from cliente where idcliente = ?";
		
		@SuppressWarnings("unchecked")
		List<Cliente> lista = jdbcTemplate.query(query, 
								new Object[]{ idCliente }, new ClienteMapper());
		
		if(lista != null && !lista.isEmpty()){
			return lista.get(0); //retornar o primeiro elemento da lista..
		}
		else{
			return null; //vazio..
		}
	}
	
}

//classe auxiliar para ler os campos da tabela cliente e montar um objeto..
class ClienteMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cliente c = new Cliente(); //entidade..
		
		c.setIdCliente(rs.getInt("idcliente"));
		c.setNome(rs.getString("nome"));
		c.setEmail(rs.getString("email"));
		
		return c;
	}
	
}





