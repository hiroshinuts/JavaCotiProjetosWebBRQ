<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Taglib do Struts -->
<%@ taglib uri="/struts-tags" prefix="s" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="/aula17_projeto/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/aula17_projeto/css/bootstrap-theme.css"/>

	<style type="text/css">
		.label { color: #000; }
	</style>
	
</head>
<body class="container">

	<h2>Cadastro de Tarefas</h2>
	<a href="/aula17_projeto/admin/index.jsp">Voltar</a> para a página inicial
	<br/><br/>	
	
	Usuario Autenticado: <label> ${usuariologado.nome} </label> <br/>
	Login de Acesso: <label> ${usuariologado.login} </label>	
	<hr/>
	
	<div>
		Para cadastrar uma nova tarefa, informe os dados abaixo:
	</div>
	
	<s:form name="formulario" method="post" action="cadastrartarefa">
	
		<s:textfield label="Nome da Tarefa" name="tarefa.nome"/>
		<s:textarea label="Descrição da Tarefa" name="tarefa.descricao" cols="30" rows="4"/>
		<s:textfield label="Data de Entrega" name="tarefa.dataEntrega" />
		
		<s:submit value="Cadastrar Tarefa" cssClass="btn btn-success btn-sm"/>	
	
	</s:form>
	
	<p>
		${mensagem}
	</p>
	
</body>
</html>







