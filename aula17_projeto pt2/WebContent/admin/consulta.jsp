<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- TagLib do struts -->
<%@ taglib uri="/struts-tags" prefix="s" %>

<!-- TagLib do JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="/aula17_projeto/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/aula17_projeto/css/bootstrap-theme.css"/>

	<style type="text/css">
		.label { color: #000; }
	</style>

</head>
<body class="container">

	<h2>Consulta de Tarefas</h2>
	<a href="/aula17_projeto/admin/index.jsp">Voltar</a> para a página inicial
	<br/><br/>	
	
	Usuario Autenticado: <label> ${usuariologado.nome} </label> <br/>
	Login de Acesso: <label> ${usuariologado.login} </label>	
	<hr/>
	
	<div>
		Para pesquisar tarefas, informe o periodo de datas:
	</div>
	
	<s:form name="formulario" method="post" action="consultartarefas">
	
		<s:textfield label="Data de" name="dataInicio"/>
		<s:textfield label="Até" name="dataFim"/>
	
		<s:submit value="Pesquisar Tarefas" cssClass="btn btn-primary btn-sm"/>
	
	</s:form>
	
	<p>
		${mensagem}
	</p>
	
	<c:if test="${listagemTarefas != null && fnc:length(listagemTarefas) > 0}">
		
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome da Tarefa</th>
					<th>Data de Entrega</th>
					<th>Descrição</th>
					<th>Status</th>
					<th>Usuario</th>
				</tr>
			</thead>
			<tbody>
				
				<s:iterator value="listagemTarefas">
					<tr>
						<td> <s:property value="idTarefa"/> </td>
						<td> <s:property value="nome"/> </td>
						<td> <s:property value="dataEntrega"/> </td>
						<td> <s:property value="descricao"/> </td>
						<td> <s:property value="status"/> </td>
						<td> <s:property value="usuario.nome"/> </td>
					</tr>
				</s:iterator>
				
			</tbody>
		</table>
		
	</c:if>

</body>
</html>





