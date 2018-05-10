<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="cabecalho.jsp"></c:import>

<div class="container mt-5">
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Iniciar sessão</h1>
		</div>
	</div>
	<form method="post" action="efetuaLogin">
		<div class="form-group">
			<label for="login">Usuario</label> <input type="text" name="login" 
				class="form-control" id="login"
				placeholder="Digite o nome de usuario">
		</div>
		<div class="form-group">
			<label for="senha">Senha</label> <input
				type="password"  name="senha" class="form-control" id="senha"
				placeholder="Senha">
		</div>
		<button type="submit" class="btn btn-primary">Entrar</button>
	</form>
</div>

<c:import url="rodape.jsp"></c:import>