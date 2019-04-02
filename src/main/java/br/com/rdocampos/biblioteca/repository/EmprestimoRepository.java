package br.com.rdocampos.biblioteca.repository;

import br.com.rdocampos.biblioteca.model.Emprestimo;
import org.springframework.data.repository.CrudRepository;

public interface EmprestimoRepository extends CrudRepository<Emprestimo, Long> {
}
