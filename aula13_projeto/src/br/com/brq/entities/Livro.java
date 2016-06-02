package br.com.brq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
@NamedQueries(
		{
			@NamedQuery(name = "livro.findall", 
						query = "select l from Livro as l")
		}
)
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idlivro")
	private Integer idLivro;
	
	@Column(name = "titulo", length = 50, nullable = false)
	private String titulo;
	
	@Column(name = "resumo", length = 255, nullable = false)
	private String resumo;
	
	@Column(name = "foto", length = 50, nullable = false, unique = true)
	private String foto;

	/*
	 * Em JPA, temos 4 tipos de relacionamentos:
	 * OneToOne, ManyToOne, OnetoMany e ManyToMany
	 */
	
	@ManyToOne //muitos Livros para 1 Autor..
	@JoinColumn(name = "idautor", nullable = false) //chave esrangeira..
	private Autor autor;
	
	@ManyToOne //muitos livros para 1 Editora..
	@JoinColumn(name = "ideditora", nullable = false) //chave estrangeira..
	private Editora editora;

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(Integer idLivro, String titulo, String resumo, String foto) {
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.resumo = resumo;
		this.foto = foto;
	}

	public Livro(Integer idLivro, String titulo, String resumo, String foto, Autor autor, Editora editora) {
		this(idLivro, titulo, resumo, foto);
		this.autor = autor;
		this.editora = editora;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", resumo=" + resumo + ", foto=" + foto + "]";
	}

}
