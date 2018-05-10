<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="cabecalho.jsp"></c:import>

<div class="container mt-5">

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Registrar devolu��o</h1>
		</div>
	</div>


	<form class="form-group">

		<div class="form-group">
			<label class="font-weight-bold" for="pesquisarUsuario">Pesquisar us�ario</label> <input type="search"
				results="10" class="form-control mb-1" id="pesquisarUsuario"
				placeholder="Pesquisar nome, matr�cula ou n� OAB"
				aria-label="pesquisarUsuario">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
		</div>
</form>
Nome: 
<br />
Usu�rio: 
<br />
Matr�cula: 
<br />
OAB: 
<br />

<h5 class="mt-5">Lista de livros pendentes de devolu��o:</h5>


</div>
	<c:import url="rodape.jsp"></c:import>