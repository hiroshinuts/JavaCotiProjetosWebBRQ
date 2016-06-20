<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

		<h3>Detalhes do Produto</h3>
		<a href="consultaProduto.jsp">Voltar</a> para a página de consulta.
		<hr/>
		
		<h4>${mensagem}</h4>
		
		<h4>Dados do Produto</h4>
		
		<label>Id do Produto: </label> ${produto.idProduto}
		<br/>		
		<label>Nome do Produto: </label> ${produto.nome}
		<br/>		
		<label>Preço: </label> ${produto.preco}
		<br/>		
		<label>Quantidade: </label> ${produto.quantidade}
		<br/>		
		<label>Total: </label> ${produto.preco * produto.quantidade}
		<br/>
		<label>Nome do Fornecedor: </label> ${produto.fornecedor.nome}
		<br/>
		<label>Descrição: </label> ${produto.fornecedor.descricao}
		<br/>
		
	</div>

</body>
</html>





