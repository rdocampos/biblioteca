package br.com.rdocampos.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LivroController {
	
	@RequestMapping("/cadastrar-livro")
	public String visualizarCadastrarLivro() {

		
		return "/content/cadastrarLivro";
	}
	
	@RequestMapping("/efetuar-cadastro-livro")
	public String efetuarCadastrarLivro() {

		
		return "/alert/respostaCadastroLivro";
	}
}
