package br.com.rdocampos.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);

		
		Funcionario funcionario = new Funcionario();
		funcionario.setMatricula("1234");
		funcionario.setNome("teste");
		funcionario.setOab("4321");
		
		Servico servico = new Servico();

		servico.adicionaFuncionario(funcionario);
	}

}
