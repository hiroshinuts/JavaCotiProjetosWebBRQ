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

@Entity
@Table(name = "editora")
@NamedQueries(
		{
			@NamedQuery(name = "editora.findall", 
						query = "select e from Editora as e order by e.nome")
		}
)
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ideditora")
	private Integer idEditora;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	// Relacionamento (muitos)...
	@OneToMany(mappedBy = "editora") //nome do atributo na classe Livro que contem a FK..
	private List<Livro> livros;

	public Editora() {
		// TODO Auto-generated constructor stub
	}

	public Editora(Integer idEditora, String nome) {
		this.idEditora = idEditora;
		this.nome = nome;
	}

	public Editora(Integer idEditora, String nome, List<Livro> livros) {
		this(idEditora, nome);
		this.livros = livros;
	}

	public Integer getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(Integer idEditora) {
		this.idEditora = idEditora;
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
		return "Editora [idEditora=" + idEditora + ", nome=" + nome + "]";
	}

}
