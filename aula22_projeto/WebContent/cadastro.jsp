<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- taglib do struts -->
<%@ taglib uri="/struts-tags" prefix="s" %>    
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto</title>
</head>
<body>

	<h3>Cadastro de Clientes</h3>
	Projeto Struts 2 com Spring e JDBC
	<hr/>
	
	<s:form action="cadastrar">
	
		<s:textfield label="Nome do Cliente" name="cliente.nome"/>
		<s:textfield label="Endereço de Email" name="cliente.email"/>
		
		<s:submit value="Cadastrar Cliente"/>
		
	</s:form>
	
	<h4> ${mensagem} </h4>

</body>
</html>




