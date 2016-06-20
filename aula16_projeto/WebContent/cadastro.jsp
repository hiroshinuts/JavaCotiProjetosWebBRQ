<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Tag lib principal do struts -->
<%@ taglib uri="/struts-tags" prefix="s" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
	
	<style type="text/css">
		.label { color: #000; }
		.errorMessage { color: #FF0000; font-size: 10pt; }
	</style>
	
</head>
<body class="container">

	<h2>Cadastro de Funcionarios</h2>
	<a href="index.jsp">Voltar</a> para a página inicial.
	<hr/>
	
	<div>
		Para cadastrar um novo funcionario, informe os dados abaixo:
	</div>
	<br/>
	
	<!-- formulário padrão struts -->
	<s:form name="formulario" method="post" action="cadastrarfuncionario">
	
		<s:textfield label="Nome do Funcionario" name="funcionario.nome"/>
		<s:textfield label="Email" name="funcionario.email"/>
		<s:textfield label="Salário" name="funcionario.salario"/>
		<s:textfield label="Função" name="funcionario.funcao"/>
	
		<s:submit value="Cadastrar Funcionario" cssClass="btn btn-success btn-sm"/>
	
	</s:form>
	
	<h4>${mensagem}</h4>
	
</body>
</html>




