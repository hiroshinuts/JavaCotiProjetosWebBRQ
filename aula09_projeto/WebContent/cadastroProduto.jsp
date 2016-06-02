<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Referenciar o ManagedBean -->
<jsp:useBean class="br.com.brq.managebeans.ManagedBeanFornecedor" id="mb"></jsp:useBean>
    
<!-- JSTL (TagLibraries) -->
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

		<h3>Cadastro de Produtos</h3>
		<a href="index.jsp">Voltar</a> para a página inicial.
		<hr/>
		
		<div class="col-md-4">
		
			<form name="formulario" method="post" action="ControleProduto?acao=cadastrar">
		
				<label>Nome do Produto:</label>
				<input type="text" name="nome" id="nome"
					class="form-control" placeholder="Digite aqui"/>
				<br/>
				
				<label>Preço:</label>
				<input type="text" name="preco" id="preco"
					class="form-control" placeholder="Digite aqui"/>
				<br/>
				
				<label>Quantidade:</label>
				<input type="number" min="1" max="1000" name="quantidade" 
					id="quantidade" class="form-control" />	
				<br/>
				
				<label>Selecione o Fornecedor:</label>
				<select name="fornecedor" id="fornecedor" 
					class="form-control">
					
					<option value="">- Escolha uma Opção -</option>
					
					<!-- Varrer os fornecedores e gerar opções no campo -->
					<c:forEach items="${mb.listagemFornecedores}" var="f">
					
						<option value="${f.idFornecedor}"> ${f.nome} </option>
					
					</c:forEach>
					
				</select>
				<br/>
				
				<input type="submit" value="Cadastrar Produto"
					class="btn btn-success"/>
					
				<br/>
				
				<!-- EL Expression Language -->
				<h4>${mensagem}</h4>
		
			</form>
		
		</div>
		
	</div>

</body>
</html>





