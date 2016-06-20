<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="/struts-tags" prefix="s" %>	
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>

</head>
<body class="container">

	<h2>Consulta de Pessoas</h2>
	<a href="index.jsp">Voltar</a> para a página inicial.
	<hr/>
	
	<div>
		${mensagem}
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome da Pessoa</th>
				<th>Email</th>
				<th>Operações</th>
			</tr>
		</thead>
		<tbody>
			
			<s:iterator value="listagemPessoas">
				<tr>
					<td> <s:property value="idPessoa"/> </td>
					<td> <s:property value="nome"/> </td>
					<td> <s:property value="email"/> </td>
					<td> 

						<a href="exibirpessoa.action?id=${idPessoa}" 
						   class="btn btn-primary btn-sm">
							Exibir Dados
						</a>

						<a href="excluirpessoa.action?id=${idPessoa}" 
						   class="btn btn-danger btn-sm">
							Excluir Registro
						</a>

					</td>
				</tr>
			</s:iterator>
			
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="4">
					Quantidade de registro(s): <s:property value="listagemPessoas.size()"/>	
				</td>
			</tr>
		</tfoot>
		
	</table>

</body>
</html>









