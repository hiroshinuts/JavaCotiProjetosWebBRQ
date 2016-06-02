package br.com.brq.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//JPA - Java Persistence API
@Entity
@Table(name = "autor")
@NamedQueries(
		{
			@NamedQuery(name = "autor.findall", 
						query = "select a from Autor as a order by a.nome")
		}
)
public class Autor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idautor")
	private Integer idAutor;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	// Relacionamento (muitos)..
	//1 Autor para muitos Livros
	//definir o nome do atributo na classe Livro que tem a FK..
	@OneToMany(mappedBy = "autor") //nome do atributo na Classe Livro onte esta a FK..
	private List<Livro> livros;

	public Autor() {
		// TODO Auto-generated constructor stub
	}

	public Autor(Integer idAutor, String nome) {
		this.idAutor = idAutor;
		this.nome = nome;
	}

	public Autor(Integer idAutor, String nome, List<Livro> livros) {
		this(idAutor, nome);
		this.livros = livros;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nome=" + nome + "]";
	}

}
