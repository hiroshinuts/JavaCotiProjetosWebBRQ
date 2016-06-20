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

		<h3>Bem vindo ao projeto</h3>
		<hr/>
		
		<p>
			Selecione a operação desejada:			
		</p>
		
		<br/><br/>
		
		<div class="col-md-3 panel text-center">
			<div class="glyphicon glyphicon-blackboard" style="font-size: 3em;"></div> 
			<br/><br/>
			<a href="cadastroFornecedor.jsp" class="btn btn-default btn-block">
				Cadastrar Fornecedores
			</a>			
		</div>
		
		<div class="col-md-3 panel text-center">
			<div class="glyphicon glyphicon-tasks" style="font-size: 3em;"></div> 
			<br/><br/>
			<a href="consultaFornecedor.jsp" class="btn btn-default btn-block">
				Consultar Fornecedores
			</a>			
		</div>
		
		<div class="col-md-3 panel text-center">
			<div class="glyphicon glyphicon-erase" style="font-size: 3em;"></div> 
			<br/><br/>
			<a href="cadastroProduto.jsp" class="btn btn-default btn-block">
				Cadastrar Produtos
			</a>			
		</div>
		
		<div class="col-md-3 panel text-center">
			<div class="glyphicon glyphicon-list-alt" style="font-size: 3em;"></div> 
			<br/><br/>
			<a href="consultaProduto.jsp" class="btn btn-default btn-block">
				Consultar Produtos
			</a>			
		</div>
		
	</div>

</body>
</html>





