package br.com.brq.control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.brq.entities.Livro;
import br.com.brq.persistence.DAOAutor;
import br.com.brq.persistence.DAOEditora;
import br.com.brq.persistence.DAOLivro;

@WebServlet("/ControleLivro")
@MultipartConfig() //habilitando o servlet a receber um upload..
public class ControleLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleLivro() {
		super();
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("cadastrar".equalsIgnoreCase(action)){
			
			try{
				
				Livro l = new Livro(); //entidade..
				
				l.setTitulo(request.getParameter("titulo"));
				l.setResumo(request.getParameter("resumo"));
				
				UUID guid = UUID.randomUUID(); //GUID - Global unique identifier..
				l.setFoto(guid.toString() + ".jpg");
				
				//obter o autor e a editora do livro..
				DAOAutor daoAutor = new DAOAutor();
				DAOEditora daoEditora = new DAOEditora();
				DAOLivro daoLivro = new DAOLivro();
				
				//resgatar o autor e a editora selecionados..
				Integer idAutor = Integer.parseInt(request.getParameter("autor"));
				Integer idEditora = Integer.parseInt(request.getParameter("editora"));
				
				//buscar autor e editora e relacionar ao livro..
				l.setAutor(daoAutor.findById(idAutor)); //relacionando..
				l.setEditora(daoEditora.findById(idEditora)); //relacionando..
				
				//cadastrar o livro..
				daoLivro.insert(l);
				
				//upload...
				//resgatar o campo foto (file)
				Part foto = request.getPart("foto"); //arquivo..
				//definir o local onde o arquivo será salvo..
				//String pasta = getServletContext().getRealPath("/img");
				String pasta = "C:\\Users\\treina2\\Desktop\\workspace\\aula13_projeto\\WebContent\\img";
				
				FileOutputStream stream = new FileOutputStream(pasta + "/" + l.getFoto());
				InputStream input = foto.getInputStream(); //lendo o arquivo..
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0){
					stream.write(buffer);
				}
				stream.close();
				
				request.setAttribute("mensagem", "Livro " + l.getTitulo()
							+ ", cadastrado com sucesso.");
			}
			catch(Exception e){
				e.printStackTrace();
				request.setAttribute("mensagem", e.getMessage());
			}
			finally{
				request.getRequestDispatcher("cadastroLivro.jsp")
					.forward(request, response);
			}
		}		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

}
