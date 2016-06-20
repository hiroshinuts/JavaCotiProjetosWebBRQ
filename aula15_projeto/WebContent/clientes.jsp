<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean class="br.com.brq.managedbeans.ManagedBeanCategoria" id="mb"/>    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>

</head>
<body class="container">

	<div class="well well-sm">
		<h2>Projeto Controle de Clientes</h2>
	</div>
	
	<div class="col-md-12">
	
		<h3>Cadastro de Clientes</h3>
		<hr/>
	
		<div class="col-md-4">
		
			<form name="formulario" method="post" action="ControleCliente?action=cadastrar">
			
				<label>Nome do Cliente:</label>
				<input type="text" name="nome" class="form-control"
					   placeholder="Digite aqui"/>
				<br/>
				
				<label>Sobrenome:</label>
				<input type="text" name="sobrenome" class="form-control"
					   placeholder="Digite aqui"/>
				<br/>
				
				<label>Cpf:</label>
				<input type="text" name="cpf" class="form-control"
					   placeholder="Digite aqui"/>
				<br/>
				
				<label>Selecione a Categoria:</label>
				<br/>
				
				<c:forEach items="${mb.listagemCategorias}" var="cat">
					
					<input type="radio" name="categoria" value="${cat}"/> ${cat}
					<br/>
					
				</c:forEach>			
				
				<br/>
				
				<input type="submit" value="Cadastrar Cliente"
					   class="btn btn-success"/>
				<br/><br/>
				
				${mensagem}
			
			</form>
			
			<hr/>
			
			<a href="ControleCliente?action=relatorio" class="btn btn-primary">
				Gerar Relatório de Clientes
			</a>
		
		</div>
	
	</div>

</body>
</html>





