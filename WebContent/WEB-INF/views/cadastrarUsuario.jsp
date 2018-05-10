<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="cabecalho.jsp"></c:import>

<div class="container mt-5">

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Cadastro de usuários</h1>
		</div>
	</div>

	<form method="post" action="adicionaUsuario">
		<div class="form-group">
			<label for="nome">Nome Completo</label> <input type="text" name="nome"
				class="form-control" id="nome"
				placeholder="Digite o nome completo">
		</div>

		<div class="form-group">
			<label for="matricula">Matrícula</label> <input type="text" name="matricula"
				class="form-control" id="matricula" placeholder="Digite a matrícula">
		</div>

		<div class="form-group">
			<label for="oab">OAB (opcional)</label> <input type="text" name="oab"
				class="form-control" id="oab" placeholder="Digite o n° OAB">
		</div>
		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</div>

<c:import url="rodape.jsp"></c:import>