<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Taglib do struts -->
<%@ taglib uri="/struts-tags" prefix="s" %>    
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
	
</head>
<body class="container">

	<h2>Consulta de Funcionarios</h2>
	<a href="index.jsp">Voltar</a> para a página inicial.
	<hr/>
	
	<div>
		Relação de Funcionários cadastrados:
	</div>
	
	<h4>${mensagem}</h4>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome do Funcionario</th>
				<th>Email</th>
				<th>Salário</th>
				<th>Função</th>
				<th>Operações</th>
			</tr>
		</thead>
		<tbody>
			
			<!-- varrer a listagem de funcionarios.. -->
			<s:iterator value="listagemFuncionarios">				
				<tr>
					<td> <s:property value="idFuncionario"/> </td>	
					<td> <s:property value="nome"/> </td>	
					<td> <s:property value="email"/> </td>	
					<td> <s:property value="salario"/> </td>	
					<td> <s:property value="funcao"/> </td>	
					<td>
					
						<a href="excluirfuncionario.action?id=${idFuncionario}"
						   class="btn btn-danger btn-sm">
							Excluir
						</a>
					
					</td>			
				</tr>				
			</s:iterator>
		
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">
					Quantidade de Funcionarios: <s:property value="listagemFuncionarios.size()"/>
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>








