package br.com.rbc.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.rbc.biblioteca.modelo.Funcionario;

@Repository
public class JdbcFuncionarioDao {

	private final Connection connection;

	@Autowired
	public JdbcFuncionarioDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Funcionario funcionario) {
		String sql = "insert into funcionarios (nome, matricula, oab) values (?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getMatricula());
			stmt.setString(3, funcionario.getOab());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
