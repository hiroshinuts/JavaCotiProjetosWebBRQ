<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto</title>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>

	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready( //quando a página for carregada..
			function(){ //faça..
				
				//criar um evento quando o botão 'btncadastro' for clicado..
				$("#btncadastro").click( //quando o botão for clicado..
					function(){ //faça..

						//JSON (JavaScript Object Notation)
						var dados = {
							"nome" 		: $("#nome").val(),
							"sobrenome" : $("#sobrenome").val(),
							"email" 	: $("#email").val()
						};
						
						//alert(JSON.stringify(dados));
						$("#mensagem").html("Enviando requisição...");
						
						//ajax..
						$.ajax(
							{
								type : "POST",
								url  : "ControlePessoa?action=cadastrar",
								data : dados,
								success : function(msg){
									
									$("#mensagem").html(msg);
									
									//limpar os campos..
									$("#nome").val("");
									$("#sobrenome").val("");
									$("#email").val("");
									
								},
								error : function(e){
									$("#mensagem").html("Erro: " + e.status);
								}
							}		
						);
					
					}		
				);
			
				//criar um evento quando digitarmos no campo de pesquisa
				$("#nomepesquisa").keyup( //quando digitarmos no campo..
					function(){ //faça..

						//JSON (Javascript object notation)
						var dados = {
							"nome" : $("#nomepesquisa").val()
						};
					
						//função ajax..
						$.ajax(
							{
								type : "POST",
								url  : "ControlePessoa?action=pesquisar",
								data : dados,
								success : function(resultado){
									$("#tabela tbody").html(resultado);
								},
								error : function(e){
									$("#mensagem").html("Erro: " + e.status);
								}
							}		
						);
					
					}		
				);
				
			}		
		);
	
	</script>

</head>
<body class="container">

	<div class="well well-sm">
		<h2>Projeto Controle de Pessoas</h2>
		JSP, Servçets, Ajax (JQuery) e Hibernate
	</div>
	
	<div class="col-md-12">
	
		<div class="col-md-4">
		
			<h3>Cadastro de Pessoas</h3>
			<hr/>
			
			<label>Nome da Pessoa:</label>
			<input type="text" id="nome" class="form-control"
				   placeholder="Digite aqui"/>
			<br/>
			
			<label>Sobrenome:</label>
			<input type="text" id="sobrenome" class="form-control"
				   placeholder="Digite aqui"/>
			<br/>
			
			<label>Email:</label>
			<input type="text" id="email" class="form-control"
				   placeholder="Digite aqui"/>
			<br/>
			
			<button id="btncadastro" class="btn btn-success">
				Cadastrar Pessoa
			</button>
			<br/><br/>
			
			<span id="mensagem"></span>
		
		</div>
		
		
		<div class="col-md-8">
		
			<h3>Pesquisa de Pessoas</h3>
			<hr/>
			
			<label>Informe o nome desejado:</label>
			<input type="text" id="nomepesquisa" class="form-control"
				   placeholder="Digite aqui"/>
			<br/><br/>
			
			<table id="tabela" class="table table-hover">
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome da Pessoa</th>
						<th>Sobrenome</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							Registros encontrado(s): <span id="quantidade">0</span>
						</td>
					</tr>
				</tfoot>
			</table>
		
		</div>
		
	</div>

</body>
</html>






