<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Formulário de Cadastro de Clientes</h3>	
	Para incluir um novo cliente, informe os dados abaixo:
	<hr/>
	
	<p>
		<a href="index.jsp">Voltar</a> para a página inicial.
	</p>
	
	<!-- FORMULARIO -->
	<form name="formulario" method="post" action="ControleCliente?acao=cadastrar">
	
		<label>Nome do Cliente:</label> <br/>
		<input type="text" name="nome"/>
		<br/><br/>
		
		<label>Email:</label> <br/>
		<input type="text" name="email"/>
		<br/><br/>
		
		<label>Sexo:</label> <br/>
		<select name="sexo">
			<option value="">- Escolha uma Opção -</option>
			<option value="Masculino">Masculino</option>
			<option value="Feminino">Feminino</option>
		</select>		
		<br/><br/>
		
		<label>Estado Civil:</label> <br/>
		<input type="radio" name="estadocivil" value="Solteiro"/> Solteiro <br/>
		<input type="radio" name="estadocivil" value="Casado"/> Casado <br/>
		<input type="radio" name="estadocivil" value="Viuvo"/> Viuvo <br/>
		<input type="radio" name="estadocivil" value="Divorciado"/> Divorciado <br/>
		<br/>
		
		<!-- Botão para enviar os dados do formulario para o servidor.. -->
		<input type="submit" value="Cadastrar Cliente"/>
		
		<!-- Botão para apagar o conteudo dos campos -->
		<input type="reset" value="Limpar"/>
		
		<!-- EL Expression Language -->
		<h4>${mensagem}</h4>
		
	</form>

</body>
</html>







