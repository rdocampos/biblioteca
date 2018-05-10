package br.com.rbc.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BibliotecaController {

	@RequestMapping("/cadastrarLivro")
	public String cadastrarLivro() {
		return "cadastrarLivro";
	}

	@RequestMapping("/cadastrarUsuario")
	public String cadastrarUsuario() {
		return "cadastrarUsuario";
	}

	@RequestMapping("/retirar")
	public String retirar() {
		return "retirar";
	}

	@RequestMapping("/devolver")
	public String devolver() {
		return "devolver";
	}

}
