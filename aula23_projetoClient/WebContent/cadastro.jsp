<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto</title>
</head>
<body>

	<h3>Cadastro de Produtos</h3>
	<hr/>
	
	<p>
		Informe os dados abaixo:
	</p>
	
	<form name="formcadastro" method="post" action="ControleProduto?action=cadastrar">
	
		Nome do Produto: <br/>
		<input type="text" name="nome" placeholder="Digite aqui"
			required="required" title="Por favor, informe o nome do produto"/>
		<br/><br/>
		
		Preço: <br/>
		<input type="text" name="preco" placeholder="Digite aqui"
			required="required" title="Por favor, informe o preço do produto."/>
		<br/><br/>
		
		<input type="submit" value="Cadastrar Produto"/>
	
		<div>
			<h4>${mensagem}</h4>
		</div>
	
	</form>

</body>
</html>