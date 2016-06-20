<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>

</head>
<body class="container">

	<h2>Cadastro de Pessoas</h2>
	<a href="index.jsp">Voltar</a> para a página inicial.
	<hr/>
	
	<div class="col-md-4">
	
		<form name="formulario" method="post" action="cadastrarpessoa.action">
		
			Para cadastrar uma pessoa, informe os dados abaixo:
			<br/><br/>
		
			<label>Nome da Pessoa:</label>
			<input type="text" name="pessoa.nome" class="form-control"
				   placeholder="Digite aqui"/>
			<br/>
			
			<label>Email:</label>
			<input type="text" name="pessoa.email" class="form-control"
				   placeholder="Digite aqui"/>
			<br/>
	
			<input type="submit" value="Cadastrar Pessoa"
				   class="btn btn-success btn-sm"/>
			<br/><br/>
			
			${mensagem}
	
		</form>
	
	</div>
	

</body>
</html>







