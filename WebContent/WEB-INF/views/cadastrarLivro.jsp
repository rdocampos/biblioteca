<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="cabecalho.jsp"></c:import>

<div class="container mt-5">

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Cadastro de livros</h1>
		</div>
	</div>

	<form action="adicionaLivro" method="post">
		<div class="form-group">
			<label for="titulo">Título</label> <input type="text"
				class="form-control" id="titulo" name="titulo"
				placeholder="Digite o título do livro">
		</div>

		<div class="form-group">
			<label for="autor">Autor(es)</label> <input type="text" name="autor"
				class="form-control" id="autor" placeholder="Digite o(s) autor(es)">
		</div>

		<div class="form-group">
			<label for="editora">Editora</label> <input type="text"
				name="editora" class="form-control" id="editora"
				placeholder="Digite a Editora">
		</div>

		<div class="form-group">
			<label for="area">Área</label> <input type="text" name="area"
				class="form-control" id="área" placeholder="Digite a área/assunto">
		</div>

		<div class="form-group">
			<label for="dataAquisicao">Data de aquisição</label> <input
				type="text" name="dataAquisicao" class="form-control"
				id="dataAquisicao" placeholder="dd/MM/yyyy">
		</div>

		<div class="form-group">
			<label for="precoLivro">Preço de custo R$</label> <input type="text"
				name="precoLivro" class="form-control" id="precoLivro"
				placeholder="0,00">
		</div>

		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</div>

<c:import url="rodape.jsp"></c:import>

<script>
	$('#precoLivro').mask('#.##0,00', {
		reverse : true
	});
	$('#dataAquisicao').mask('00/00/0000');
</script>
