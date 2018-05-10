<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="cabecalho.jsp"></c:import>

<div class="container mt-5">

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Registrar saída</h1>
		</div>
	</div>


	<form class="form-group">

		<div class="form-group">
			<label class="font-weight-bold" for="pesquisarUsuario">Pesquisar usúario</label> <input type="search"
				results="10" class="form-control mb-1" id="pesquisarUsuario"
				placeholder="Pesquisar nome, matrícula ou n° OAB"
				aria-label="pesquisarUsuario">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
		</div>

Nome: 
<br />
Usuário: 
<br />
Matrícula: 
<br />
OAB: 
<br />


		<div class="form-group mt-5">
			<label class="font-weight-bold" for="pesquisarLivro">Pesquisar livro</label> <input type="search"
				results="10" class="form-control mb-1" id="pesquisarLivro"
				placeholder="Pesquisar título, autor(es) ou editora"
				aria-label="pesquisarLivro">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
		</div>

Título: 
<br />
Autor(es): 
<br />
Editora: 
<br />
Área/assunto: 
<br />
ID n°:
<br />
<br />
Data do empréstimo:
<br />
Devolver até: 
<br />

<button type="submit" class="btn btn-primary">Salvar</button>
	</form>

</div>
	<c:import url="rodape.jsp"></c:import>