<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>

	<style type="text/css">
		label.error { color: #FF0000; }
	</style>

	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready( //quando a página carregar...
			function(){ //faça..
				
				//validar o formulário..
				$("#formulario").validate(
					{
						rules:{
							nome : "required"
						},
						messages:{
							nome:{
								required : "Por favor, informe o nome do Autor."
							}
						}
					}		
				);
				
			}		
		);
	
	</script>

</head>
<body class="container">

	<jsp:include page="templates/topo.jsp"></jsp:include>

	<div class="col-md-12">
	
		<h4>Cadastro de Autores</h4>
		Para incluir um novo Autor, informe os dados abaixo:
		<hr/>
		
		<div class="col-md-4">
			
			<form id="formulario" name="formulario" method="post" 
				  action="ControleAutor?action=cadastrar">
				
				<label>Nome do Autor:</label>
				<input type="text" id="nome" name="nome"
					class="form-control" placeholder="Digite aqui"/>
				<br/>
				
				<input type="submit" value="Cadastrar Autor"
					class="btn btn-success"/>
				<br/><br/>
				
				${mensagem}
			
			</form>
		
		</div>
		
		
	</div>

</body>
</html>