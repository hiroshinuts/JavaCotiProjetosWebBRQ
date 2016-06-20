<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="/aula17_projeto/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/aula17_projeto/css/bootstrap-theme.css"/>

</head>
<body class="container">

	<h2>Bem vindo ao Sistema</h2>
	Área Restrita da aplicação.
	<hr/>
	
	Usuario Autenticado: <label> ${usuariologado.nome} </label> <br/>
	Login de Acesso: <label> ${usuariologado.login} </label> <br/>
	<br/>
	
	<a href="logout.action" class="btn btn-danger btn-sm">
		Sair do Sistema
	</a>
	
	<hr/>
	
	<ul>
		<li> <a href="/aula17_projeto/admin/cadastro.jsp">Cadastrar Tarefas</a> </li>
		<li> <a href="/aula17_projeto/admin/consulta.jsp">Consultar Tarefas</a> </li>
	</ul>

</body>
</html>