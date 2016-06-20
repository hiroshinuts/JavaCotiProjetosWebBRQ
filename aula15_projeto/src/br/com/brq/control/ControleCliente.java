package br.com.brq.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.entities.Cliente;
import br.com.brq.entities.types.Categoria;
import br.com.brq.persistence.DAOCliente;
import br.com.brq.persistence.HibernateUtil;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;

@WebServlet("/ControleCliente")
public class ControleCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleCliente() {
		super();
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("cadastrar".equalsIgnoreCase(action)){
			try{
				
				Cliente c = new Cliente(); //entidade..
				
				c.setNome(request.getParameter("nome"));
				c.setSobrenome(request.getParameter("sobrenome"));
				c.setCpf(request.getParameter("cpf"));
				c.setCategoria(Categoria.valueOf(request.getParameter("categoria")));
				
				DAOCliente d = new DAOCliente();
				d.saveOrUpdate(c); //gravando..
				
				request.setAttribute("mensagem", "Cliente " + c.getNome() 
										+ ", cadastrado com sucesso.");
			}
			catch(Exception e){
				request.setAttribute("mensagem", e.getMessage());
			}
			finally{
				request.getRequestDispatcher("clientes.jsp")
					.forward(request, response);
			}
		}
		else if("relatorio".equalsIgnoreCase(action)){
			
			try{				
				//pegando o caminho onde esta o relatorio..
				ServletContext context = getServletContext();
				InputStream input = (InputStream) context.getResourceAsStream
										("/reports/relatorioclientes.jasper");
				
				//fornecer uma conexão de banco de dados para o relatorio..
				byte[] pdf = JasperRunManager.runReportToPdf(input, null, 
									HibernateUtil.getSessionFactory().openSession().connection());
				
				//donwload..
				response.setHeader("Content-Disposition", "filename=relatorio.pdf");
				response.setContentLength(pdf.length);
				
				OutputStream out = response.getOutputStream();
				out.write(pdf); //download..
				out.flush();
				out.close();
			}
			catch(Exception e){
				e.printStackTrace();
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
