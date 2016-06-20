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

		<h3>Cadastro de Fornecedores</h3>
		<a href="index.jsp">Voltar</a> para a página inicial.
		<hr/>
		
		<div class="col-md-4">
			
			<form name="formulario" method="post" action="ControleFornecedor?acao=cadastrar">
			
				<label>Nome do Fornecedor:</label> 
				<input type="text" name="nome" id="nome"
					class="form-control" placeholder="Digite aqui"/>
				<br/>
			
				<label>Descrição:</label>
				<textarea name="descricao" id="descricao"
					class="form-control"></textarea>
				<br/>
				
				<input type="submit" value="Cadastrar Fornecedor"
					   class="btn btn-success"/>
			
				<!-- EL (Expression Language) -->
				<h4>${mensagem}</h4>
			
			</form>
			
		</div>
		
	</div>

</body>
</html>





