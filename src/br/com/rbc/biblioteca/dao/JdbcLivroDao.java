package br.com.rbc.biblioteca.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.rbc.biblioteca.modelo.Livro;

@Repository
public class JdbcLivroDao {

	private final Connection connection;

	@Autowired
	public JdbcLivroDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adicionaLivro(Livro livro) {
		String sql = "insert into livros (titulo, autor, editora, area, dataAquisicao, precoLivro) values (?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setString(4, livro.getArea());
			stmt.setDate(5, livro.getDataAquisicao() != null ? new Date(livro.getDataAquisicao().getTimeInMillis()) : null);
			stmt.setString(6, livro.getPrecoLivro());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}