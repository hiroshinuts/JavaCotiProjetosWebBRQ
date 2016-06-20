package br.com.brq.control;

import java.io.IOException;

import javax.management.openmbean.OpenDataException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.entities.Fornecedor;
import br.com.brq.entities.Produto;
import br.com.brq.persistence.DAOProduto;

@WebServlet("/ControleProduto")
public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleProduto() {
        super();
    }

    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	//resgatar uma variavel acao..
    	String acao = request.getParameter("acao");
    	
    	if(acao != null){
    		if(acao.equalsIgnoreCase("cadastrar")){
    			
    			try{
    				
    				//resgatar os dados do produto..
    				Produto p = new Produto(); //instanciando..
    				p.setFornecedor(new Fornecedor()); //instanciando..
    				
    				p.setNome(request.getParameter("nome"));
    				p.setPreco(Double.parseDouble(request.getParameter("preco")));
    				p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
    				p.getFornecedor().setIdFornecedor(
    						Integer.parseInt(request.getParameter("fornecedor")));
    				
    				DAOProduto d = new DAOProduto(); //persistencia..
    				d.insert(p); //gravando na base de dados..
    				
    				//gerando mensagem de sucesso..
    				request.setAttribute("mensagem", "Produto " + p.getNome()
    										+ ", cadastrado com sucesso.");    				
    			}
    			catch(Exception e){
    				//gerando mensagem de erro..
    				request.setAttribute("mensagem", "Erro: " + e.getMessage());
    			}
    			finally{
    				//redirecionar de volta para a página de cadastro de produto..
    				request.getRequestDispatcher("cadastroProduto.jsp")
    					.forward(request, response);
    			}
    		}
    		else if(acao.equalsIgnoreCase("visualizar")){
    			
    			try{    				
    				//resgatar o id enviado pelo link..
    				Integer idProduto = Integer.parseInt(request.getParameter("id"));
    				
    				//buscar o produto pelo id..
    				DAOProduto d = new DAOProduto();
    				Produto p = d.findById(idProduto);
    				
    				//enviar um objeto no request.setAttribute...
    				request.setAttribute("produto", p);
    			}
    			catch(Exception e){
    				//mensagem de erro..
    				request.setAttribute("mensagem", "Erro: " + e.getMessage());
    			}
    			finally{
    				//redirecionar para a página de detalhes do produto..
    				request.getRequestDispatcher("detalhesProduto.jsp")
    					.forward(request, response);
    			}    			
    		}
    		else if(acao.equalsIgnoreCase("excluir")){
    			
    			try{
    				
    				//resgatando o id do produto enviado pela URL (barra de endereço)
    				Integer idProduto = Integer.parseInt(request.getParameter("id"));
    				
    				DAOProduto d = new DAOProduto();
    				d.delete(idProduto); //excluindo..
    				
    				//enviando mensagem de sucesso..
    				request.setAttribute("mensagem", "Produto excluido com sucesso.");
    			}
    			catch(Exception e){
    				//enviando mensagem de erro..
    				request.setAttribute("mensagem", "Erro: " + e.getMessage());
    			}
    			finally{
    				//redirecionar para a página de consulta...
    				request.getRequestDispatcher("consultaProduto.jsp")
    					.forward(request, response);
    			}
    		}
    		else if(acao.equalsIgnoreCase("editar")){
    			
    			try{
    				
    				Integer idProduto = Integer.parseInt(request.getParameter("id"));
    				
    				//buscar 1 produto pelo id..
    				DAOProduto d = new DAOProduto();
    				Produto p = d.findById(idProduto);
    				
    				//enviar o objeto Produto para a página de edição..
    				request.setAttribute("produto", p);
    			}
    			catch(Exception e){
    				//enviar mensagem de erro..
    				request.setAttribute("mensagem", "Erro: " + e.getMessage());
    			}
    			finally{
    				//redirecionar para a página de edição..
    				request.getRequestDispatcher("edicaoProduto.jsp")
    					.forward(request, response);
    			}    			
    		}
    		else if(acao.equalsIgnoreCase("atualizar")){
    			
    			try{
    				
    				Produto p = new Produto(); //instanciando..
    				p.setFornecedor(new Fornecedor()); //instanciando..
    				
    				//resgatar os campos enviados pelo formulario..
    				p.setIdProduto(Integer.parseInt(request.getParameter("idproduto")));
    				p.setNome(request.getParameter("nome"));
    				p.setPreco(Double.parseDouble(request.getParameter("preco")));
    				p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
    				p.getFornecedor().setIdFornecedor(
    						Integer.parseInt(request.getParameter("fornecedor")));
    				
    				DAOProduto d = new DAOProduto();
    				d.update(p); //atualizando o produto..
    				
    				//enviar mensagem de sucesso para a página..
    				request.setAttribute("mensagem", "Produto " + p.getNome()
    										+ ", atualizado com sucesso.");
    			}
    			catch(Exception e){
    				//enviar mensagem de erro..
    				request.setAttribute("mensagem", "Erro: " + e.getMessage());
    			}
    			finally{
    				//redirecionar para a página de consulta..
    				request.getRequestDispatcher("consultaProduto.jsp")
    					.forward(request, response);
    			}
    			
    		}
    		
    	}
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
