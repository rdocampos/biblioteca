package br.com.rbc.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rbc.biblioteca.dao.JdbcFuncionarioDao;
import br.com.rbc.biblioteca.modelo.Funcionario;

@Controller
public class FuncionarioController {

	private final JdbcFuncionarioDao dao;

	@Autowired
	public FuncionarioController(JdbcFuncionarioDao dao) {
		this.dao = dao;
	}

	@RequestMapping("adicionaUsuario")
	public String adiciona(Funcionario funcionario) {
		System.out.println("chamando user " + funcionario.getNome());
		dao.adiciona(funcionario);
		return "sucesso";
	}
}
