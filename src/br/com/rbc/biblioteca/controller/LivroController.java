package br.com.rbc.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rbc.biblioteca.dao.JdbcLivroDao;
import br.com.rbc.biblioteca.modelo.Livro;

@Controller
public class LivroController {

	private final JdbcLivroDao dao;

	@Autowired
	public LivroController(JdbcLivroDao dao) {
		this.dao = dao;
	}

	@RequestMapping("adicionaLivro")
	public String adiciona(Livro livro) {
		System.out.println("Adicionando livro " + livro.getTitulo());
		dao.adicionaLivro(livro);
		return "sucesso";
	}

}
