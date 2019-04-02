package br.com.rdocampos.biblioteca.repository;

import br.com.rdocampos.biblioteca.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}
