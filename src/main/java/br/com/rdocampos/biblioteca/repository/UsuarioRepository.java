package br.com.rdocampos.biblioteca.repository;

import br.com.rdocampos.biblioteca.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario getByEmail(String email);

    Usuario getUsuarioByIdUsuario(Long idUsuario);
}
