<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Referenciar o ManagedBean -->
<jsp:useBean class="br.com.brq.manager.ManagedBeanFuncionario" id="mb"></jsp:useBean>
    
<!-- Declarar as taglibs -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto</title>

	<!-- Arquivos CSS do bootstrap -->	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
	
	<!-- Bloco CSS (Folha de estilo) -->
	<style type="text/css">		
		/* formatação das mensagens de erro.. */
		label.error
		{
			color: #FF0000; 
			font-weight: bold; 
		}
		
		/* formatação nos campos que obtiveram erro */
		input.error
		{
			border: 1px solid #FF0000;
			background-color: #FFCCCC;
		}
		
	</style>	
	
	<!-- Arquivos JavaScript -->
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/messages_pt_BR.min.js"></script>

	<!-- bloco javascript -->
	<script type="text/javascript">
	
		//função inicial do jquery..
		$(document).ready( //quando a página estiver carregada..
			function(){ //faça..
				
				//aplicar validação ao formulario (jquery validate)
				$("#formulario").validate();
				
			}		
		);
	
	</script>

</head>
<body class="container">

	<h2>Manter Funcionarios</h2>
	<a href="index.jsp">Voltar</a> para a página inicial.
	<hr/>
	
	<div class="col-md-12">
	
		<button data-target="#janela" data-toggle="modal"
			class="btn btn-primary btn-sm">
			Cadastrar Funcionario
		</button>
		
		<br/>
		
		<h4>${mensagem}</h4>
		
		<br/>
		
		<h4>Relação de Funcionarios cadastrados:</h4>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome do Funcionario</th>
					<th>Salário</th>
					<th>Data de Admissão</th>
					<th>Operações</th>
				</tr>
			</thead>
			<tbody>	

				<c:forEach items="${mb.listagemFuncionarios}" var="f">				
				<tr>
					<td>${f.idFuncionario}</td>
					<td>${f.nome}</td>
					<td>
						<fmt:formatNumber type="currency" value="${f.salario}"/>
					</td>
					<td>
						<fmt:formatDate pattern="dd/MM/yyyy" value="${f.dataAdmissao}"/>
					</td>
					<td> <a href="ControleFuncionario?action=excluir&id=${f.idFuncionario}" 
							class="btn btn-danger btn-sm"
							onclick="return confirm('Deseja excluir?');">Excluir</a> </td>
				</tr>				
				</c:forEach>
							
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">Quantidade de Funcionarios: 
									${fnc:length(mb.listagemFuncionarios)} 
					</td>
				</tr>
			</tfoot>
		</table>
		
	
	</div>
	
	<!-- Janela de cadastro do funcionario.. -->
	<div id="janela" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h3>Cadastro de Funcionarios</h3>
				</div>
				<div class="modal-body">
					
					Para cadastrar um novo funcionario, informe os dados abaixo:
					<hr/>
					
					<form name="formulario" id="formulario" method="post" 
						  action="ControleFuncionario?action=cadastrar">
					
						<label>Nome do Funcionario:</label>
						<input type="text" name="nome" 
							class="form-control required"
							placeholder="Digite aqui"/>
						<br/>
						
						<label>Salário</label>
						<input type="text" name="salario" 
							class="form-control required number"
							placeholder="Digite aqui"/>
						<br/>
						
						<label>Data de Admissão</label>
						<input type="date" name="dataadmissao" 
							   class="form-control required"/>
						<br/>
						
						<input type="submit" value="Cadastrar Funcionario"
							class="btn btn-success btn-block"/>
					
					</form>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>








