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

	<h2>Editar dados de Pessoa</h2>
	<a href="index.jsp">Voltar</a> para a página inicial.
	<hr/>
	
	<div class="col-md-4">
	
		<form name="formulario" method="post" action="atualizarpessoa.action">
		
			Para atualizar uma pessoa, altere os dados abaixo:
			<br/><br/>
		
			<label>Código:</label>
			<input type="text" name="pessoa.idPessoa" class="form-control"
				   readonly="readonly" value="${pessoa.idPessoa}"/>
			<br/>
		
			<label>Nome da Pessoa:</label>
			<input type="text" name="pessoa.nome" class="form-control"
				   placeholder="Digite aqui" value="${pessoa.nome}"/>
			<br/>
			
			<label>Email:</label>
			<input type="text" name="pessoa.email" class="form-control"
				   placeholder="Digite aqui" value="${pessoa.email}"/>
			<br/>
	
			<input type="submit" value="Atualizar Pessoa"
				   class="btn btn-primary btn-sm"/>
			<br/><br/>
			
			${mensagem}
	
		</form>
	
	</div>
	

</body>
</html>







