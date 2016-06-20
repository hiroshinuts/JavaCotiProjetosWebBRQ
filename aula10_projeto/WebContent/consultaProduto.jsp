<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Referenciar o ManagedBean -->
<jsp:useBean class="br.com.brq.managebeans.ManagedBeanProduto" id="mb"></jsp:useBean>

<!-- declarar as TagLibraries (JSTL) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Treinamento Java BRQ</title>

	<!-- Arquivos CSS do bootstrap -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>

</head>
<body class="container">

	<!-- Cabeçalho da página -->
	<div class="well well-sm">
		<h2>Projeto Controle de Fornecedores e Produtos</h2>
		Treinamento BRQ COTI Informatica - Java Developer
	</div>
	
	<!-- Conteudo principal da página -->
	<div class="col-md-12">

		<h3>Consulta de Produtos</h3>
		<a href="index.jsp">Voltar</a> para a página inicial.
		<hr/>
		
		<h4>${mensagem}</h4>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome do Produto</th>
					<th>Preço</th>
					<th>Quantidade</th>
					<th>Total</th>					
					<th>Fornecedor</th>
					<th>Operações</th>
				</tr>
			</thead>
			<tbody>
			
				<!-- varrer a lista de produtos com JSTL -->
				<c:forEach items="${mb.listagemProdutos}" var="p">
				
					<tr>
						<td>${p.idProduto}</td>
						<td>${p.nome}</td>
						<td>
							<fmt:formatNumber value="${p.preco}" type="currency">
							</fmt:formatNumber>
						</td>
						<td align="center">${p.quantidade}</td>
						<td>
							<fmt:formatNumber value="${p.preco * p.quantidade}" type="currency">
							</fmt:formatNumber>
						</td>
						<td>${p.fornecedor.nome}</td>
						<td>
						
							<a href="ControleProduto?acao=visualizar&id=${p.idProduto}"
							   class="btn btn-warning btn-sm">
								<span class="glyphicon glyphicon-search"></span> Visualizar
							</a>
							
							<a href="ControleProduto?acao=excluir&id=${p.idProduto}"
							   class="btn btn-danger btn-sm"
							   onclick="return confirm('Deseja excluir este Produto?');">
								<span class="glyphicon glyphicon-trash"></span> Excluir
							</a>
							
							<a href="ControleProduto?acao=editar&id=${p.idProduto}"
							   class="btn btn-primary btn-sm">
								<span class="glyphicon glyphicon-pencil"></span> Editar
							</a>
						
						</td>
					</tr>
				
				</c:forEach>
			
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7">
						Quantidade de registros: ${fnc:length(mb.listagemProdutos)}
					</td>
				</tr>
			</tfoot>
		</table>
		
	</div>

</body>
</html>





