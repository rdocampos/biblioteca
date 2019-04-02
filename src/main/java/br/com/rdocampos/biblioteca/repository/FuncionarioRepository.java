package br.com.rdocampos.biblioteca.repository;

import br.com.rdocampos.biblioteca.model.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}
