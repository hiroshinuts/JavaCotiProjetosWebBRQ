<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Referenciar os ManagedBeans -->
<jsp:useBean class="br.com.brq.managedbeans.ManagedBeanAutor" id="mbAutor"></jsp:useBean>
<jsp:useBean class="br.com.brq.managedbeans.ManagedBeanEditora" id="mbEditora"></jsp:useBean>
    
<!-- TagLibraries (JSTL) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
    
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
		
		$(document).ready(
			function(){				
				$("#formulario").validate(
					{
						rules:{
							titulo  : "required",
							resumo  : "required",
							foto    : "required",
							autor   : "required",
							editora : "required"
						},
						messages:{
							titulo  :{ required : "Por favor, informe o titulo do Livro." },
							resumo  :{ required : "Por favor, informe o resumo do Livro." },
							foto    :{ required : "Por favor, envie a foto do Livro." },
							autor   :{ required : "Por favor, selecione o autor do Livro." },
							editora :{ required : "Por favor, selecione a editora do Livro." }
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
	
		<h4>Cadastro de Livros</h4>
		Para incluir um novo Livro, informe os dados abaixo:
		<hr/>
		
		<div class="col-md-4">
		
			<form id="formulario" name="formulario" 
				method="post" enctype="multipart/form-data"
				action="ControleLivro?action=cadastrar">
			
				<label>Título do Livro:</label>
				<input type="text" id="titulo" name="titulo"
						class="form-control" placeholder="Digite aqui"/>
				<br/>
				
				<label>Resumo do Livro:</label>
				<textarea id="resumo" name="resumo"
					class="form-control"></textarea>
				<br/>
				
				<label>Foto do Livro:</label>
				<input type="file" id="foto" name="foto"
					class="form-control"/>
				<br/>
				
				<label>Autor do Livro:</label>
				<select id="autor" name="autor" class="form-control">
					<option value="">- Selecione uma Opção -</option>
					
					<c:forEach items="${mbAutor.listagemAutores}" var="a">
						<option value="${a.idAutor}"> ${a.nome} </option>
					</c:forEach>
					
				</select>
				<br/>
				
				<label>Editora do Livro:</label>
				<select id="editora" name="editora" class="form-control">
					<option value="">- Selecione uma Opção -</option>
					
					<c:forEach items="${mbEditora.listagemEditoras}" var="e">
						<option value="${e.idEditora}"> ${e.nome} </option>
					</c:forEach>
					
				</select>
				<br/>
				
				<input type="submit" value="Cadastrar Livro"
					   class="btn btn-success"/>
				<br/><br/>
			
				${mensagem}
			
			</form>
		
		</div>
		
	</div>

</body>
</html>



