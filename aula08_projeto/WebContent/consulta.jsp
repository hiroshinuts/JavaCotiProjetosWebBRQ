<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Registrar o JSTL (Biblioteca de TAGS do JSP) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Consulta de Clientes</h3>
	Informe o nome do cliente desejado para realizar a busca.
	<hr/>
	
	<p>
		<a href="index.jsp">Voltar</a> para a página inicial.
	</p>

	<!-- FORMULARIO DE PESQUISA -->
	<form name="formulario" method="post" action="ControleCliente?acao=consultar">
	
		<label>Nome do Cliente:</label>
		<input type="text" name="nome"/>
		
		<!-- Botão para enviar os dados para o servidor -->
		<input type="submit" value="Pesquisar"/>
		
		<!-- Botão para limpar o conteudo dos campos -->
		<input type="reset" value="Limpar"/>
		
		<h4>${mensagem}</h4>
			
	</form>
		
	<h4>Resultado da busca:</h4>
	
	<table width="100%" border="1">
		<thead>
			<tr>	
				<th>Id do Cliente</th>
				<th>Nome do Cliente</th>
				<th>Sexo</th>
				<th>Estado Civil</th>
				<th>Email</th>
			</tr>	
		</thead>
		<tbody>
		
			<!-- Varrer a lista (dados) usando JSTL -->
			<c:forEach items="${dados}" var="cli">
				
				<tr>
					<td> ${cli.idCliente} </td>
					<td> ${cli.nome} </td>
					<td> ${cli.email} </td>
					<td> ${cli.sexo} </td>
					<td> ${cli.estadoCivil} </td>
				</tr>
				
			</c:forEach>
			
		</tbody>		
	</table>	

</body>
</html>





