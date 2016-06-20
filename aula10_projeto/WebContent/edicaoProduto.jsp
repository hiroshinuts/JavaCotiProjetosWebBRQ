<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Referenciar o ManagedBean -->
<jsp:useBean class="br.com.brq.managebeans.ManagedBeanFornecedor" id="mb"></jsp:useBean>
    
<!-- TagLibraries (JSTL) -->
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

		<h3>Editar dados do Produto</h3>
		<a href="consultaProduto.jsp">Voltar</a> para a página de consulta.
		<hr/>
		
		<div class="col-md-4">
		
		<form name="formulario" method="post" action="ControleProduto?acao=atualizar">
		
			<label>Id do Produto:</label>
			<input type="text" name="idproduto" class="form-control"
				value="${produto.idProduto}" readonly="readonly"/>
			<br/>
			
			<label>Nome do Produto:</label>
			<input type="text" name="nome" class="form-control"
				value="${produto.nome}" />
			<br/>
			
			<label>Preço:</label>
			<input type="text" name="preco" class="form-control"
				value="${produto.preco}" />
			<br/>
			
			<label>Quantidade:</label>
			<input type="number" name="quantidade" class="form-control"
				value="${produto.quantidade}" />
			<br/>
			
			<label>Selecione o Fornecedor:</label>
			<select name="fornecedor" class="form-control">
				
				<c:forEach items="${mb.listagemFornecedores}" var="f">
				
					<option value="${f.idFornecedor}"
						${f.idFornecedor == produto.fornecedor.idFornecedor ? 'selected' : ''}
					> ${f.nome} </option>
					
				</c:forEach>
				
			</select>
			<br/>
			
			<input type="submit" value="Atualizar Dados"
				   class="btn btn-success"/>
			<br/>
			
			<h4>${mensagem}</h4>
		
		</form>
		
		</div>
		
	</div>

</body>
</html>





