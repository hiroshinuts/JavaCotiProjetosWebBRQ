<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Referenciar o ManagedBean -->
<!-- Este comando não é um JSTL, é um comando nativo do JSP -->
<jsp:useBean class="br.com.brq.managebeans.ManagedBeanFornecedor" id="mb"></jsp:useBean>    

<!-- Declarar as bibliotecas JSTL -->
<!-- JSP Standart Tag Libraries -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Treinamento Java BRQ</title>

	<!-- Arquivos CSS do bootstrap -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>

</head>
<body class="container">

	<!-- Cabeçalho da página -->
	<div class="well well-sm">
		<h2>Projeto Controle de Fornecedores e Produtos</h2>
		Treinamento BRQ COTI Informatica - Java Developer
	</div>
	
	<!-- Conteudo principal da página -->
	<div class="col-md-12">

		<h3>Consulta de Fornecedores</h3>
		<a href="index.jsp">Voltar</a> para a página inicial.
		<hr/>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome do Fornecedor</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
			
				<!-- tag JSTL para varrer coleções de objetos -->
				<c:forEach items="${mb.listagemFornecedores}" var="f">
				
					<tr>
						<td> ${f.idFornecedor} </td>
						<td> ${f.nome} </td>
						<td> ${f.descricao} </td>
					</tr>
				
				</c:forEach>
			
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">
						Quantidade de registros: ${fnc:length(mb.listagemFornecedores)}						
					</td>
				</tr>
			</tfoot>
		</table>
		
	</div>

</body>
</html>





