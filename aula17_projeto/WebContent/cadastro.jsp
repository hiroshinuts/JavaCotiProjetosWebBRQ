<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- taglib do struts -->
<%@ taglib uri="/struts-tags" prefix="s" %>    
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="/aula17_projeto/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/aula17_projeto/css/bootstrap-theme.min.css"/>

	<style>
		.label { color: #000; }
	</style>

</head>
<body class="container">

	<h2>Cadastro de Usuarios</h2>
	<a href="/aula17_projeto/index.jsp">Voltar</a> para a página inicial.
	<hr/>
	
	<!-- Formulario para cadastro do cliente.. -->
	<s:form id="formulario" method="post" action="cadastrarusuario">
	
		<s:textfield label="Nome do Usuario:" name="usuario.nome"/>
		<s:textfield label="Login de Acesso:" name="usuario.login"/>
		<s:password label="Informe sua Senha:" name="usuario.senha"/>
		
		<s:submit value="Cadastrar Usuario" 
				  cssClass="btn btn-success btn-sm"/>
	
	</s:form>
	
	<p>
		${mensagem}
	</p>

</body>
</html>






